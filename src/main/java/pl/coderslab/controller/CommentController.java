package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Comment;
import pl.coderslab.repository.CommentDao;
import pl.coderslab.security.UserPrincipal;

@Controller

public class CommentController {

    @Autowired
    private CommentDao commentDao;

    @GetMapping("/comment/add")
    private String showAddForm(Model model){
        model.addAttribute("comment", new Comment());
        return "comments/add_new_comment";
    }

    @PostMapping("/comment/add")
    private String addNewComment(@ModelAttribute Comment comment, @AuthenticationPrincipal UserPrincipal principal){
        commentDao.save(comment);
        return "redirect:/event/all";
    }

}
