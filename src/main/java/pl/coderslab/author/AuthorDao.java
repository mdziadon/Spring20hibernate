package pl.coderslab.author;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class AuthorDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveAuthor(Author author) {
        entityManager.persist(author);
    }

    public void updateAuthor(Author author) {
        entityManager.merge(author);
    }

    public Author findAuthor(Long id) {
        return entityManager.find(Author.class, id);
    }

    public void deleteAuthor(Long id) {
        Author author = findAuthor(id);
        if (author != null) {
            entityManager.remove(author);
        }
    }

    public void deleteAuthorRelations(Long id) {
        Query query = entityManager.createNativeQuery("delete from book_authors where author_id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public List<Author> findAll() {
        Query query = entityManager.createQuery("select a from Author a");
        return query.getResultList();
    }
    
}
