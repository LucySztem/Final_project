package pl.coderslab.entity;

import pl.coderslab.model.TypeOfFood;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "foods")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private TypeOfFood type;

    private double price;

    private double amount;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Food() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }


    public TypeOfFood getType() {
        return type;
    }

    public void setType(TypeOfFood type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
