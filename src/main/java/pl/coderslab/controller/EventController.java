package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import pl.coderslab.entity.Event;

import pl.coderslab.repository.EventDao;

import java.util.List;

@Controller
@RequestMapping("/event")
public class EventController {



    @Autowired
    private EventDao eventDao;

    @RequestMapping("/test")
    public String hello(){
        return "{hello: World}";
    }

//    @RequestMapping("/helloEvent")
//    public Event showEvent(){
//
//        return new Event(1L, "domowka", "u Asi", "2017-03-25");
//    }

    @GetMapping("/add")
    private String eventForm(Model model){
        model.addAttribute("event", new Event());
        return "add_event_form";
    }

    @PostMapping("/add")
    @ResponseBody
    private String addEvent(@ModelAttribute Event event){
        eventDao.save(event);
    return "event has been added";
    }


}
