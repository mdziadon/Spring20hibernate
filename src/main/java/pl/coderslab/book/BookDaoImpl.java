package pl.coderslab.book;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class BookDaoImpl implements BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void resetRating(int rating) {
        Query query = entityManager.createQuery("update Book b set b.rating = :rating");
        query.setParameter("rating", rating);
        query.executeUpdate();
    }
}
