package pl.coderslab.book;

import org.hibernate.validator.constraints.Range;
import pl.coderslab.author.Author;
import pl.coderslab.category.Category;
import pl.coderslab.publisher.Publisher;
import pl.coderslab.validation.BookValidationGroup;
import pl.coderslab.validation.PropositionValidationGroup;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(groups = {BookValidationGroup.class, PropositionValidationGroup.class})
    @Size(min = 5, groups = {BookValidationGroup.class, PropositionValidationGroup.class})
    private String title;

    @Range(min = 1, max = 10, groups = BookValidationGroup.class)
    private int rating;

    @Min(value = 2, groups = BookValidationGroup.class)
    private int pages;

    @NotBlank(groups = PropositionValidationGroup.class)
    @Size(max = 600, groups = {BookValidationGroup.class, PropositionValidationGroup.class})
    private String description;

    private boolean proposition = false;

    @NotNull(groups = BookValidationGroup.class)
    @ManyToOne
    private Publisher publisher;

    @NotEmpty(groups = BookValidationGroup.class)
    @ManyToMany
    @JoinTable(name = "book_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors;

    @ManyToOne
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isProposition() {
        return proposition;
    }

    public void setProposition(boolean proposition) {
        this.proposition = proposition;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
