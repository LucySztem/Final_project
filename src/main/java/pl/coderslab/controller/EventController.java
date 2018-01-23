package pl.coderslab.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.entity.Event;

@RestController
@RequestMapping("/event")
public class EventController {

    @RequestMapping("/test")
    public String hello(){
        return "{hello: World}";
    }

    @RequestMapping("/helloEvent")
    public Event showEvent(){

        return new Event(1L, "domowka", "u Asi", "2017-03-25");
    }
}
