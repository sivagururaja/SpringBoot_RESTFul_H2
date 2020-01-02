package in.rajava.rest.h2.presentation;

import in.rajava.rest.h2.model.Author;
import in.rajava.rest.h2.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public List getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/authors/{id}")
    public Author getAuthor(@PathVariable int authorId) {
        return authorService.getAuthor(authorId);
    }

    @PostMapping("/authors")
    public void addAuthor(@RequestBody List<Author> authors) {
        for (Author author : authors)
            authorService.addAuthor(author);
    }

    @PutMapping("/authors/{id}")
    public void updateAuthor(@PathVariable int authorId, @RequestBody Author author) {
        authorService.updateAuthor(authorId, author);
    }

    @DeleteMapping("/authors/{id}")
    public void deleteAuthor(@PathVariable int authorId) {
        authorService.deleteAuthor(authorId);
    }
}