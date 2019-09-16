package pl.coderslab.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/add")
    @ResponseBody
    public String addBook() {
        Book book = new Book();
        book.setTitle("Thinking in Java");
        book.setAuthor("Bruce Eckel");
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
