package pl.coderslab.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonService {

    private PersonDao personDao;

    @Autowired
    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public void savePerson(Person person) {
        personDao.savePerson(person);
    }

    public void updatePerson(Person person) {
        personDao.updatePerson(person);
    }

    public Person findPerson(Long id) {
        return personDao.findPerson(id);
    }

    public void deletePerson(Long id) {
        personDao.deletePerson(id);
    }
}
