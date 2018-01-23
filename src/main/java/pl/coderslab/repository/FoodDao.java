package pl.coderslab.repository;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Event;
import pl.coderslab.entity.Food;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class FoodDao {

    @PersistenceContext
    private EntityManager em;

    /* metoda do zapisu danych do DB */
    public void save(Food food) {
        em.persist(food);
    }

    /* edycja danych */
    public void update(Food food) {
        em.merge(food);
    }

    /* ususwanie, po wczesniejszym spr czy dana encja istnieje */
    public void delete(long id) {
        Food food = this.findById(id);
        em.remove(em.contains(food) ? food : em.merge(food));
    }

    public Food findById(long id) {
        return em.find(Food.class, id);
    }

    /*dodajc ksiazke bedziemy mieli liste wszytskich Foodow*/
    public List<Food> getAll() {
        Query query = em.createQuery("SELECT e From Food as e");
        return query.getResultList();
    }
}
