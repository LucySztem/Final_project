package pl.coderslab.repository;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Drink;
import pl.coderslab.entity.Event;
import pl.coderslab.entity.Food;
import pl.coderslab.model.TypeOfFood;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
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

    /*wyciagniecie wsyztskich typow jedzenia
    * typowanie na Food, wiec wie ze zwraca obiet typu Food*/
    public List<Food> getAll() {
        TypedQuery<Food> query = em.createQuery("SELECT e From Food as e", Food.class);
        return query.getResultList();
    }
    /*mappowanie na Food i zabezpiecznie przed SQL injection poprzez ustawienie parametru*/
    public List<Food> getSnacks(){
        TypedQuery<Food> query = em.createQuery("SELECT f from Food as f where f.type=:typeOfFood", Food.class )
                .setParameter("typeOfFood", TypeOfFood.SNACK);
        return query.getResultList();
    }

    public List<Food> getHotFood(){
        TypedQuery<Food> query = em.createQuery("Select f from Food as f where f.type=:typeOfFood", Food.class)
                .setParameter("typeOfFood", TypeOfFood.HOT_FOOD);
        return query.getResultList();
    }
   public List<Food> getFoodByEventId(long id){
       TypedQuery<Food> query = em.createQuery("Select f from Food as f where f.event.id= :id", Food.class)
               .setParameter("id", id);
       return query.getResultList();
   }
}
