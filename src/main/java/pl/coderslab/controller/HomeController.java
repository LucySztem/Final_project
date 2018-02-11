package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserDao;
import pl.coderslab.security.UserPrincipal;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserDao userDao;

    @GetMapping("")
    public String showHomepage(@AuthenticationPrincipal UserPrincipal principal, Model model){
        if(principal==null){
            return "redirect:/user/login";
        } else {
            User user = userDao.findById(principal.getUserId());
            model.addAttribute("user", user);
            return "homepage";
        }
    }
}
