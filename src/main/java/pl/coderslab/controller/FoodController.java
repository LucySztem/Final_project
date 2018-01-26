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
//@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodDao foodDao;

    @GetMapping("/food/add")
    private String showFrom(Model model){

        model.addAttribute("food", new Food());
        model.addAttribute("types", TypeOfFood.values());
        return "food/add_food_form";
    }

    @PostMapping("/food/add")
    private String addFood(@ModelAttribute Food food){

        foodDao.save(food);
        return "redirect:/event/" + food.getEvent().getId();
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

    @GetMapping("/food/update/{id}")
    public String updateDrinkForm(Model model, @PathVariable long id){
        Food food= foodDao.findById(id);
        model.addAttribute("food", food);
        return "food/update_food_form";
    }

    @PostMapping("/food/update")
    public String updateDrink(@ModelAttribute Food food){
        foodDao.update(food);
        return "redirect:/event/" + food.getEvent().getId();
    }
    @GetMapping("/food/delete/{foodId}/{eventId}")
    public String deleteDrink(@PathVariable long foodId, @PathVariable long eventId){
        foodDao.delete(foodId);
        return "redirect:/event/" + eventId;
    }
}
