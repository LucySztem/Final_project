package pl.coderslab.repository;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Drink;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

    /*dodajc ksiazke bedziemy mieli liste wszytskich Drinkow*/
    public List<Drink> getAll() {
        Query query = em.createQuery("SELECT d From Drink d");
        return query.getResultList();
    }
    public List<Drink> getTypesOfDrinks(){
        Query query = em.createQuery("Select d from Drink as d where :type");
        return query.getResultList();
    }
}
