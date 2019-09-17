package pl.coderslab.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

public class AuthorConverter implements Converter<String, Author> {

    @Autowired
    private AuthorService authorService;

    @Override
    public Author convert(String s) {
        if (StringUtils.isEmpty(s)) {
            return null;
        }
        return authorService.findAuthor(Long.valueOf(s));
    }
}
