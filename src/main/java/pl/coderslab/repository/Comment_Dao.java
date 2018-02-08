package pl.coderslab.repository;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Comment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class Comment_Dao {

    @PersistenceContext
    private EntityManager em;

    public void save(Comment comment){
        em.persist(comment);
    }
    public void update(Comment comment){
        em.merge(comment);
    }

    public void delete(long id){
        Comment comment = this.findById(id);
        em.remove(em.contains(comment) ? comment : em.merge(comment));
    }

    public Comment findById(long id){
        return em.find(Comment.class,id);
    }

    public List<Comment> getAll(){
        TypedQuery<Comment> query = em.createQuery("SELECT c from Comment as c", Comment.class);
        return query.getResultList();
    }

    public List<Comment> getCommentByUserID(long id){
        TypedQuery<Comment> query = em.createQuery("select c from Comment as c where c.user.id =:id", Comment.class).setParameter("id", id);
        return query.getResultList();
    }
}
