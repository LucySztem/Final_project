package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Drink;
import pl.coderslab.model.TypeOfDrink;
import pl.coderslab.repository.DrinkDao;

import java.util.List;

@Controller
//@RequestMapping("/drink")
public class DrinkController {

    @Autowired
    private DrinkDao drinkDao;

    @GetMapping("/drink/add")
    public String showForm(Model model){
        model.addAttribute("drink", new Drink());
        model.addAttribute("types", TypeOfDrink.values());
        return "drink/add_drink_form";
    }

    @PostMapping("/drink/add")
    //@ResponseBody
    public String addDrink(@ModelAttribute Drink drink){

        drinkDao.save(drink);
        return "redirect:/event/" + drink.getEvent().getId();
    }
    @GetMapping("/drink/update/{id}")
    public String updateDrinkForm(Model model, @PathVariable long id){
        Drink drink = drinkDao.findById(id);
        model.addAttribute("drink", drink);
        return "drink/update_drink_form";
    }

    @PostMapping("/drink/update")
    public String updateDrink(@ModelAttribute Drink drink){
        drinkDao.update(drink);
        return "redirect:/event/" + drink.getEvent().getId();
    }
    @GetMapping("/drink/delete/{drinkId}/{eventId}")
    public String deleteDrink(@PathVariable long drinkId, @PathVariable long eventId){
        drinkDao.delete(drinkId);
        return "redirect:/event/" + eventId;
    }
}
