package io.pturczyk.jooqplayground.controller;

import io.pturczyk.jooqplayground.dto.BookCreateDTO;
import io.pturczyk.jooqplayground.dto.BookDTO;
import io.pturczyk.jooqplayground.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(final BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/books")
    private List<BookDTO> getBooks() {
        return bookService.getBooks();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/books/{id}")
    private ResponseEntity deleteBook(@PathVariable("id") final int bookId) {
        final boolean deleted = bookService.deleteBook(bookId) > 0;
        return new ResponseEntity(deleted ? NO_CONTENT : NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/books")
    private ResponseEntity<BookDTO> createBook(@RequestBody BookCreateDTO book) {
        final BookDTO created = bookService.createBook(book);
        return ResponseEntity.created(URI.create("/books/" + created.getId())).body(created);
    }


}
