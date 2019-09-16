package pl.coderslab.person;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void savePerson(Person person) {
        entityManager.persist(person);
    }

    public void updatePerson(Person person) {
        entityManager.merge(person);
    }

    public Person findPerson(Long id) {
        return entityManager.find(Person.class, id);
    }

    public void deletePerson(Long id) {
        Person person = findPerson(id);
        if (person != null) {
            entityManager.remove(person);
        }
    }
}
