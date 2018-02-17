package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.*;
import pl.coderslab.model.*;
import pl.coderslab.repository.*;
import pl.coderslab.security.UserPrincipal;

import java.util.List;

@Controller
@RequestMapping("/event")
public class EventController {

    @Autowired
    private FoodDao foodDao;

    @Autowired
    private DrinkDao drinkDao;

    @Autowired
    private EventDao eventDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private CommentDao commentDao;

    @RequestMapping("/test")
    public String hello() {
        return "{hello: World}";
    }


    @GetMapping("/add")
    private String eventForm(Model model) {

        model.addAttribute("event", new Event());
        return "event/add_event_form";
    }

    @PostMapping("/add")
    private String addEvent(@ModelAttribute Event event, @AuthenticationPrincipal UserPrincipal principal) {
        if (principal == null) {
            return "redirect:/user/login";
        } else {

            User user = userDao.findById(principal.getUserId());
            event.setUser(user);
            eventDao.save(event);
            return "redirect:all";
        }
    }


    @GetMapping("/all")
    private String showAllEvents(@AuthenticationPrincipal UserPrincipal principal, Model showAll) {

        if (principal == null) {
            return "redirect:/user/login";
        } else {
            List<Event> listOfEvents = eventDao.getAll();
            showAll.addAttribute("events", listOfEvents);
            showAll.addAttribute("comment", new Comment());

            List<Comment> comments = commentDao.getAll();
            showAll.addAttribute("comments", comments);

            return "event/all_events";
        }
    }

    @GetMapping("/{id}")
    public String eventView(Model model, @PathVariable long id) {
        Event eventByID = eventDao.findById(id);
        model.addAttribute("event", eventByID);

        List<Drink> listOfDrinks = drinkDao.getDrinksByEventId(id);
        model.addAttribute("drinks", listOfDrinks);

        List<Food> listOfFood = foodDao.getFoodByEventId(id);
        model.addAttribute("foods", listOfFood);

        Food food = new Food();
        food.setEvent(eventByID);
        model.addAttribute("food", food);
        model.addAttribute("typesOfFood", TypeOfFood.values());

        Drink drink = new Drink();
        drink.setEvent(eventByID);
        model.addAttribute("drink", drink);
        model.addAttribute("typesOfDrinks", TypeOfDrink.values());


        return "event/show_event";
    }

    @GetMapping("/update/{id}")
    public String updateEventForm(Model model, @PathVariable long id) {
        Event event = eventDao.findById(id);
        model.addAttribute("event", event);
        return "event/update_event_form";
    }

    @PostMapping("/update")
    public String updateEvent(@ModelAttribute Event event) {
        eventDao.update(event);
        return "redirect:/event/" + event.getId();
    }

    @GetMapping("/delete/{eventId}")
    public String deleteEvent(@PathVariable long eventId) {
        eventDao.delete(eventId);
        return "redirect:/event/all";
    }

    @GetMapping("/stats/{id}")
    public String showEventStats(Model model, @PathVariable long id){

        Event event = eventDao.findById(id);
        model.addAttribute("event", event);

        List<Drink> alcohol = drinkDao.getAlcoholByEvent(id);
        model.addAttribute("alcohol", alcohol);

        List<Food> snacks = foodDao.getSnacksByEvent(id);
        model.addAttribute("snacks", snacks);

        List<Food> hotFood = foodDao.getHotFoodByEventId(id);
        model.addAttribute("hotFood", hotFood);

        return "event/event_statistics";
    }
}
