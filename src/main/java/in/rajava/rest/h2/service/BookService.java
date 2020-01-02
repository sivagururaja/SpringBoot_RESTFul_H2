package in.rajava.rest.h2.service;

import in.rajava.rest.h2.model.Author;
import in.rajava.rest.h2.model.Book;
import in.rajava.rest.h2.persistence.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // TODO: Beware of circular dependency
    @Autowired
    private AuthorService authorService;

    public List getAllBooks() {
        List books = new ArrayList<Book>();

        bookRepository.findAll().forEach(book -> {

            //To populate Author objects based on author id's
            Set<Author> authors = Arrays.stream(book.getAuthorIds().split(",")).map(authorId -> {
                return authorService.getAuthor(Integer.parseInt(authorId));
            }).collect(Collectors.toSet());

            book.setAuthors(authors);
            books.add(book);
        });

        return books;
    }

    public Book getBook(int id) {
        return bookRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void updateBook(int id, Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }
}