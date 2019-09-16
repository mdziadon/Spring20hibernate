package pl.coderslab.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthorService {

    private AuthorDao authorDao;

    @Autowired
    public AuthorService(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public void saveAuthor(Author author) {
        authorDao.saveAuthor(author);
    }

    public void updateAuthor(Author author) {
        authorDao.updateAuthor(author);
    }

    public Author findAuthor(Long id) {
        return authorDao.findAuthor(id);
    }

    public void deleteAuthor(Long id) {
        authorDao.deleteAuthor(id);
    }
}
