package pl.coderslab.book;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {

    private BookDao bookDao;

    @Autowired
    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void saveBook(Book book) {
        bookDao.saveBook(book);
    }

    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    public Book findBook(Long id) {
        return bookDao.findBook(id);
    }

    public Book findBookWithAuthors(Long id) {
        Book book = bookDao.findBook(id);
        Hibernate.initialize(book.getAuthors());
        return book;
    }

    public void deleteBook(Long id) {
        bookDao.deleteBook(id);
    }

    public List<Book> getRatingList(int rating) {
        return bookDao.getRatingList(rating);
    }

    public List<Book> findAll() {
        return bookDao.findAll();
    }
}
