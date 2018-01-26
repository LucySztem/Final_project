package pl.coderslab.repository;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Drink;
import pl.coderslab.model.TypeOfDrink;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class DrinkDao {
    @PersistenceContext
    private EntityManager em;

    /* metoda do zapisu danych do DB */
    public void save(Drink drink) {
        em.persist(drink);
    }

    /* edycja danych */
    public void update(Drink drink) {
        em.merge(drink);
    }

    /* ususwanie, po wczesniejszym spr czy dana encja istnieje */
    public void delete(long id) {
        Drink drink = this.findById(id);
        em.remove(em.contains(drink) ? drink : em.merge(drink));
    }

    public Drink findById(long id) {
        return em.find(Drink.class, id);
    }


    public List<Drink> getAll() {
        TypedQuery<Drink> query = em.createQuery("SELECT d From Drink d", Drink.class);
        return query.getResultList();
    }

    public List<Drink> getSoftDrinks() {
        TypedQuery<Drink> query = em.createQuery("Select d from Drink as d where d.type = :typeOfDrink", Drink.class)
                .setParameter("typeOfDrink", TypeOfDrink.SOFT);
        return query.getResultList();
    }

    public List<Drink> getAlcoholDrinks() {
        TypedQuery<Drink> query = em.createQuery("Select d from Drink as d where d.type = :typeOfDrink", Drink.class)
                .setParameter("typeOfDrink", TypeOfDrink.ALCOHOL);
        return query.getResultList();
    }

    public List<Drink> getDrinksByEventId(long id) {
        TypedQuery<Drink> query = em.createQuery("Select d from Drink as d where d.event.id= :id", Drink.class)
                .setParameter("id", id);
        return query.getResultList();
    }


}
