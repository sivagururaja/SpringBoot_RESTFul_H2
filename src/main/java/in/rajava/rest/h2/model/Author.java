package in.rajava.rest.h2.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Set;

@Entity
public class Author {

    @Id
    private int id = -1;
    private String name;
    private int age = -1;
    private String bookIds;

    @Transient
    private Set<Book> books;

    public Author() {
    }

    public Author(int id, String name, int age, String bookIds) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.bookIds = bookIds;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBookIds() {
        return bookIds;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}