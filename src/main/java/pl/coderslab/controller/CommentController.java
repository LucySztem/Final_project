package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.entity.Comment;
import pl.coderslab.entity.User;
import pl.coderslab.repository.CommentDao;
import pl.coderslab.repository.UserDao;
import pl.coderslab.security.UserPrincipal;

@Controller

public class CommentController {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private UserDao userDao;

    @GetMapping("/comment/add")
    private String showAddForm(Model model) {
        model.addAttribute("comment", new Comment());
        return "comment/add_new_comment";
    }

    @PostMapping("/comment/add")
    private String addNewComment(@ModelAttribute Comment comment, @AuthenticationPrincipal UserPrincipal principal) {

        User user = userDao.findById(principal.getUserId());
        comment.setUser(user);
        commentDao.save(comment);
        return "redirect:/event/all";
    }

}
