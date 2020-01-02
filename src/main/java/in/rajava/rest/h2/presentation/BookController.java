package in.rajava.rest.h2.presentation;

import in.rajava.rest.h2.model.Book;
import in.rajava.rest.h2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable int bookId) {
        return bookService.getBook(bookId);
    }

    @PostMapping("/books")
    public void addBook(@RequestBody List<Book> books) {
        for (Book book : books)
            bookService.addBook(book);
    }

    @PutMapping("/books/{id}")
    public void updateBook(@PathVariable int bookId, @RequestBody Book book) {
        bookService.updateBook(bookId, book);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable int bookId) {
        bookService.deleteBook(bookId);
    }
}