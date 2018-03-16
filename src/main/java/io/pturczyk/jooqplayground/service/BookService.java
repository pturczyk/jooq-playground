package io.pturczyk.jooqplayground.service;

import io.pturczyk.jooqplayground.domain.AuthorEntity;
import io.pturczyk.jooqplayground.domain.BookEntity;
import io.pturczyk.jooqplayground.dto.AuthorDTO;
import io.pturczyk.jooqplayground.dto.BookCreateDTO;
import io.pturczyk.jooqplayground.dto.BookDTO;
import io.pturczyk.jooqplayground.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class BookService {

    private final BookRepository repository;

    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public BookDTO createBook(final BookCreateDTO book) {
        final BookEntity bookEntity = toBookEntity(book);
        int bookId = repository.createBook(bookEntity);
        return new BookDTO(bookId, book.getTitle(), null);
    }

    public int deleteBook(final int bookId) {
        return repository.deleteBook(bookId);
    }

    public List<BookDTO> getBooks() {
        return repository.findAll().stream()
                .map(this::toBookDTO)
                .collect(toList());
    }

    private BookEntity toBookEntity(final BookCreateDTO book) {
        // TODO: add support for author
        return new BookEntity(book.getId(), book.getTitle(), null);
    }

    private BookDTO toBookDTO(final BookEntity entity) {
        return new BookDTO(
                entity.getId(),
                entity.getTitle(),
                toAuthorDTO(entity.getAuthor())
        );
    }
    private AuthorDTO toAuthorDTO(final AuthorEntity author) {
        AuthorDTO authorDTO = null;
        if (author != null) {
            authorDTO = new AuthorDTO(
                    author.getId(),
                    author.getFirstName(),
                    author.getLastName());
        }
        return authorDTO;
    }

}
