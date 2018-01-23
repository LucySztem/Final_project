package pl.coderslab.repository;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Event;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class EventDao {
    @PersistenceContext
    private EntityManager em;

    /* metoda do zapisu danych do DB */
    public void save(Event event) {
        em.persist(event);
    }

    /* edycja danych */
    public void update(Event event) {
        em.merge(event);
    }

    /* ususwanie, po wczesniejszym spr czy dana encja istnieje */
    public void delete(long id) {
        Event event = this.findById(id);
        em.remove(em.contains(event) ? event : em.merge(event));
    }

    public Event findById(long id) {
        return em.find(Event.class, id);
    }

    /*dodajc ksiazke bedziemy mieli liste wszytskich Eventow*/
    public List<Event> getAll() {
        Query query = em.createQuery("SELECT e From Event as e");
        return query.getResultList();
    }
    
}
