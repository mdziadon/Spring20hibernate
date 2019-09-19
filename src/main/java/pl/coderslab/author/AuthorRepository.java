package pl.coderslab.author;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findByEmail(String email);

    Author findByPesel(String pesel);

    List<Author> findByLastName(String lastName);
}
