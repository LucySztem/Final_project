package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Drink;
import pl.coderslab.model.TypeOfDrink;
import pl.coderslab.repository.DrinkDao;

@Controller
@RequestMapping("/drink")
public class DrinkController {

    @Autowired
    private DrinkDao drinkDao;

    @GetMapping("/add")
    public String showForm(Model model){
        model.addAttribute("drink", new Drink());
        model.addAttribute("types", TypeOfDrink.values());
        return "add_drink_form";
    }

    @PostMapping("/add")
    @ResponseBody
    public String addDrink(@ModelAttribute Drink drink){
        drinkDao.save(drink);
        return "drink has been added";
    }

}
