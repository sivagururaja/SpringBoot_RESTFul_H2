package in.rajava.rest.h2.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Set;

@Entity
public class Book {

    @Id
    private int id = 0;
    private String title;
    private String type;
    private double price = 0;
    private int numOfPages = 0;
    private String language;
    private String isbn13;
    private String authorIds;

    @Transient
    private Set<Author> authors;

    public Book() {
    }

    public Book(int id, String title, String type, double price, int numOfPages, String language, String isbn13, String authorIds) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.price = price;
        this.numOfPages = numOfPages;
        this.language = language;
        this.isbn13 = isbn13;
        this.authorIds = authorIds;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public String getLanguage() {
        return language;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public String getAuthorIds() {
        return authorIds;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}