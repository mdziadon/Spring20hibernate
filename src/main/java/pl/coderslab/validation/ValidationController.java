package pl.coderslab.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.book.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
public class ValidationController {

    private Validator validator;

    @Autowired
    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @GetMapping(value = "/validate", produces = "text/html; charset=utf-8")
    @ResponseBody
    public String validate() {
        Book book = new Book();

        Set<ConstraintViolation<Book>> errors = validator.validate(book);
        StringBuilder sb = new StringBuilder();
        for (ConstraintViolation<Book> error : errors) {
            sb.append(error.getPropertyPath()).append(": ").append(error.getMessage()).append("<br>");
        }
        return sb.toString();
    }
}
