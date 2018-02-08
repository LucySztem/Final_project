package pl.coderslab.repository;


import org.springframework.stereotype.Component;
import pl.coderslab.entity.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class UserDao {

    @PersistenceContext
    private EntityManager em;

    /* metoda do zapisu danych do DB */
    public void save(User user) {
        em.persist(user);
    }

    /* edycja danych */
    public void update(User user) {
        em.merge(user);
    }

    /* ususwanie, po wczesniejszym spr czy dana encja istnieje */
    public void delete(long id) {
        User user = this.findById(id);
        em.remove(em.contains(user) ? user : em.merge(user));
    }

    public User findById(long id) {
        return em.find(User.class, id);
    }

    /*wyciagniecie wsyztskich typow jedzenia
     * typowanie na User, wiec wie ze zwraca obiet typu User*/
    public List<User> getAll() {
        TypedQuery<User> query = em.createQuery("SELECT e From User as e", User.class);
        return query.getResultList();
    }
    public User findByUsername(String username){
        TypedQuery<User> query = em.createQuery("Select u from User as u where u.username = :username", User.class)
        .setParameter("username", username);
        return query.getSingleResult();
    }

}
