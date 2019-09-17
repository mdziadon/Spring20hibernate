package pl.coderslab.book;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveBook(Book book) {
        entityManager.persist(book);
    }

    public void updateBook(Book book) {
        entityManager.merge(book);
    }

    public Book findBook(Long id) {
        return entityManager.find(Book.class, id);
    }

    public void deleteBook(Long id) {
        Book book = findBook(id);
        if (book != null) {
            entityManager.remove(book);
        }
    }

    public List<Book> getRatingList(int rating) {
        Query query = entityManager.createQuery("select b from Book b where b.rating > :param");
        query.setParameter("param", rating);
        return query.getResultList();
    }

    public List<Book> findAll() {
        Query query = entityManager.createQuery("select distinct b from Book b left join fetch b.authors");
        return query.getResultList();
    }
}
