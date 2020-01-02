package in.rajava.rest.h2.service;

import in.rajava.rest.h2.model.Author;
import in.rajava.rest.h2.model.Book;
import in.rajava.rest.h2.persistence.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    // TODO: Beware of circular dependency
    @Autowired
    private BookService bookService;

    public List getAllAuthors() {
        List authors = new ArrayList<Author>();

        authorRepository.findAll().forEach(author -> {

            //To populate Book objects based on book id's
            Set<Book> books = Arrays.stream(author.getBookIds().split(",")).map(bookId -> {
                return bookService.getBook(Integer.parseInt(bookId));
            }).collect(Collectors.toSet());

            author.setBooks(books);
            authors.add(author);
        });

        return authors;
    }

    public Author getAuthor(int id) {
        return authorRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    public void updateAuthor(int id, Author author) {
        authorRepository.save(author);
    }

    public void deleteAuthor(int id) {
        authorRepository.deleteById(id);
    }
}