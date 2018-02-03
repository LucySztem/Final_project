package pl.coderslab.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.security.UserPrincipal;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping("")
    public String showHomepage(@AuthenticationPrincipal UserPrincipal principal){
        if(principal==null){
            return "redirect:/user/login";
        } else {
            return "homepage";
        }
    }
}
