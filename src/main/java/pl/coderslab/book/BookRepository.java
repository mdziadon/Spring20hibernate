package pl.coderslab.book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByRatingGreaterThan(int rating);

    List<Book> findByPropositionTrue();

    List<Book> findByTitle(String title);

    List<Book> findByCategoryId(Long categoryId);

    List<Book> findByAuthorsId(Long authorId);

    List<Book> findByPublisherId(Long publisherId);

    List<Book> findByRating(int rating);

    Book findFirstByCategoryIdOrderByTitle(Long categoryId);
}
