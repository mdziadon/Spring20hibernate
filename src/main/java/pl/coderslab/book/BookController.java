package pl.coderslab.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorService;
import pl.coderslab.publisher.Publisher;
import pl.coderslab.publisher.PublisherService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    private PublisherService publisherService;

    private AuthorService authorService;

    @Autowired
    public BookController(BookService bookService, PublisherService publisherService, AuthorService authorService) {
        this.bookService = bookService;
        this.publisherService = publisherService;
        this.authorService = authorService;
    }

    @GetMapping("/add")
    @ResponseBody
    public String addBook() {
        // Tworzymy wydawce
        Publisher publisher = new Publisher();
        publisher.setName("Wydawca testowy");

        // Tworzymy listę autorów
        List<Author> authors = new ArrayList<>();
        Author author = new Author();
        author.setFirstName("Bruce");
        author.setLastName("Eckel");
        authors.add(author);

        // Tworzymy książkę
        Book book = new Book();
        book.setTitle("Thinking in Java");
        book.setAuthors(authors);
        book.setPublisher(publisher);

        authorService.saveAuthor(author);
        publisherService.savePublisher(publisher);
        bookService.saveBook(book);
        return "Dodano ksiazke o id: " + book.getId();
    }

    @GetMapping("/update/{id}")
    @ResponseBody
    public String updateBook(@PathVariable Long id) {
        Book book = bookService.findBook(id);
        book.setTitle("Thinking in Javaaaa");
        bookService.updateBook(book);
        return "Zaktualizowano ksiazke o id: " + book.getId();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String findById(@PathVariable Long id) {
        Book book = bookService.findBook(id);
        return book.toString();
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "Usunieto ksiazke o id: " + id;
    }
}
