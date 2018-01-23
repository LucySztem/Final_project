package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.entity.Drink;
import pl.coderslab.entity.Event;
import pl.coderslab.repository.DrinkDao;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private DrinkDao drinkDao;

    @RequestMapping("/test")
    public String hello(){
        return "{hello: World}";
    }

    @RequestMapping("/helloEvent")
    public Event showEvent(){

        return new Event(1L, "domowka", "u Asi", "2017-03-25");
    }


}
