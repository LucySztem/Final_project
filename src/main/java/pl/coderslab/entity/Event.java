package pl.coderslab.entity;

import pl.coderslab.converter.UserConverter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String description;
    private String place;
    private String date;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Food> listOfFood = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    private List<Drink> listOfDrinks = new ArrayList<>();

    public List<Food> getList() {
        return listOfFood;
    }

    public List<Drink> getListOfDrinks() {
        return listOfDrinks;
    }

    public Event() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
