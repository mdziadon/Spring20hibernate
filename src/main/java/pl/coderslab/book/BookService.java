package pl.coderslab.book;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    public Book findBook(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book findBookWithAuthors(Long id) {
        Book book = findBook(id);
        Hibernate.initialize(book.getAuthors());
        return book;
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> getRatingList(int rating) {
        return bookRepository.findByRatingGreaterThan(rating);
    }

    public List<Book> findAll() {
        List<Book> books = bookRepository.findAll();
        books.forEach(b -> Hibernate.initialize(b.getAuthors()));
        return books;
    }

    public List<Book> findAllPropositions() {
        return bookRepository.findByPropositionTrue();
    }

    public List<Book> findBooksByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public List<Book> findBooksByCategoryId(Long categoryId) {
        return bookRepository.findByCategoryId(categoryId);
    }

    public List<Book> findBooksByAuthorId(Long authorId) {
        return bookRepository.findByAuthorsId(authorId);
    }

    public Book findFirstByCategoryIdOrderByTitle(Long categoryId) {
        return bookRepository.findFirstByCategoryIdOrderByTitle(categoryId);
    }
}
