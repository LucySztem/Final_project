package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserDao;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/add")
    public String sendForm(Model model){
        model.addAttribute("user", new User());
        return "add_user_form";
    }

    @PostMapping("/add")
    @ResponseBody
    private String addNewUser(@ModelAttribute User user){
       userDao.save(user);
       return "new user has been added";
    }
}
