package pl.coderslab.author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findByEmail(String email);

    @Query("select a from Author a where a.email like ?1%")
    List<Author> findByEmailStartWith(String emailPrefix);

    Author findByPesel(String pesel);

    @Query("select a from Author a where a.pesel like ?1%")
    List<Author> findByPeselStartWith(String peselPrefix);

    List<Author> findByLastName(String lastName);
}
