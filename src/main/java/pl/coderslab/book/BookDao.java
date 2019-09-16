package pl.coderslab.book;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
