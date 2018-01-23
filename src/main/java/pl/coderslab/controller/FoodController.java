package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Food;
import pl.coderslab.repository.FoodDao;

@Controller
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodDao foodDao;

    @GetMapping("/add")
    private String showFrom(Model model){
        model.addAttribute("food", new Food());
        return "add_food_form";
    }

    @PostMapping("/add")
    private String addFood(@ModelAttribute Food food){
        foodDao.save(food);
        return "redirect:index";
    }
}
