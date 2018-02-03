package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserDao;
import pl.coderslab.security.UserPrincipal;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserDao userDao;

    @GetMapping("/add")
    public String sendForm(Model model){
        model.addAttribute("user", new User());
        return "user/add_user_form";
    }

    @PostMapping("/add")
    //@ResponseBody
    public String addNewUser(@ModelAttribute User user){
        user.setPassword(encoder.encode(user.getPassword()));
        userDao.save(user);
       return "/";
    }

    @GetMapping("/login")
    public String logIn(){
        return "login_form";
    }

    @PostMapping("/login")
    private String showAllEvents(@AuthenticationPrincipal UserPrincipal principal){

        if (principal == null) {
            return "redirect:/user/login";
        } else {

            return "redirect:/home";
        }
    }
}
