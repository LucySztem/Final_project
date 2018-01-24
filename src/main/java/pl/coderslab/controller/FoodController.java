package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Food;
import pl.coderslab.model.TypeOfFood;
import pl.coderslab.repository.FoodDao;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodDao foodDao;

    @GetMapping("/add")
    private String showFrom(Model model){

        model.addAttribute("food", new Food());
        model.addAttribute("types", TypeOfFood.values());
        return "add_food_form";
    }

    @PostMapping("/add")
    private String addFood(@ModelAttribute Food food){
        foodDao.save(food);
        return "redirect:index";
    }
// to jest model attribute globalny dla claego kontrolera wiec mozna go uzyc w wielu miejscach
//    @ModelAttribute("types")
//    public List<String> typesOfFood(){
//        List<String> list = foodDao.typesOfFood();
//        return list;
//    }

    @GetMapping("/all")
    @ResponseBody
    public List<Food> getAll(){
        List<Food> list = foodDao.getSnacks();
        return list;
    }
}
