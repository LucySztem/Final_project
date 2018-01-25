package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import pl.coderslab.entity.Drink;
import pl.coderslab.entity.Event;

import pl.coderslab.entity.Food;
import pl.coderslab.entity.User;
import pl.coderslab.model.TypeOfDrink;
import pl.coderslab.model.TypeOfFood;
import pl.coderslab.repository.DrinkDao;
import pl.coderslab.repository.EventDao;
import pl.coderslab.repository.UserDao;

import java.util.List;

@Controller
@RequestMapping("/event")
public class EventController {


    @Autowired
    private DrinkDao drinkDao;

    @Autowired
    private EventDao eventDao;

    @Autowired
    private UserDao userDao;

    @RequestMapping("/test")
    public String hello(){
        return "{hello: World}";
    }



    @GetMapping("/add")
    private String eventForm(Model model){
        model.addAttribute("event", new Event());
        return "addForms/add_event_form";
    }

    @PostMapping("/add")
    @ResponseBody
    private String addEvent(@ModelAttribute Event event){
        eventDao.save(event);
    return "event has been added";
    }


    @GetMapping("/all")
    private String showAllEvents(Model showAll){
        List<Event> listOfEvents = eventDao.getAll();
        showAll.addAttribute("events", listOfEvents);
        return "all_events";
    }

    @GetMapping("/{id}")
    public String eventView(Model model, @PathVariable long id){
        Event eventByID = eventDao.findById(id);
        model.addAttribute("event", eventByID);

        List<Drink> listOfDrinks = drinkDao.getDrinksByEventId(id);
        model.addAttribute("drinks", listOfDrinks);

        Food food = new Food();
        food.setEvent(eventByID);
        model.addAttribute("food", food);
        model.addAttribute("typesOfDrinks", TypeOfFood.values());

        Drink drink = new Drink();
        drink.setEvent(eventByID);
        model.addAttribute("drink", drink);
        model.addAttribute("typesOfFood", TypeOfDrink.values());

        double sum = drinkDao.getSum();
        model.addAttribute("sum", sum);
        return "event_01";

    }

}
