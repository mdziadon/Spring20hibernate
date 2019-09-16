package pl.coderslab.publisher;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PublisherDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void savePublisher(Publisher publisher) {
        entityManager.persist(publisher);
    }

    public void updatePublisher(Publisher publisher) {
        entityManager.merge(publisher);
    }

    public Publisher findPublisher(Long id) {
        return entityManager.find(Publisher.class, id);
    }

    public void deletePublisher(Long id) {
        Publisher publisher = findPublisher(id);
        if (publisher != null) {
            entityManager.remove(publisher);
        }
    }
}
