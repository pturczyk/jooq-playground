package io.pturczyk.jooqplayground.repository;

import io.pturczyk.jooqplayground.domain.AuthorEntity;
import io.pturczyk.jooqplayground.domain.BookEntity;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static io.pturczyk.jooq.domain.Tables.AUTHORS;
import static io.pturczyk.jooq.domain.Tables.BOOKS;
import static java.util.stream.Collectors.toList;

@Repository
public class BookRepository {

    private final DSLContext dsl;

    @Autowired
    public BookRepository(final DSLContext dsl) {
        this.dsl = dsl;
    }

    public List<BookEntity> findAll() {
        return dsl.select()
                .from(BOOKS)
                .leftJoin(AUTHORS).on(BOOKS.B_AUTHOR_ID.equal(AUTHORS.A_ID))
                .fetch().stream()
                .map(this::toBookEntity)
                .collect(toList());
    }

    public int createBook(final BookEntity bookEntity) {
        return dsl.insertInto(BOOKS)
                .set(BOOKS.B_TITLE, bookEntity.getTitle())
                .returning(BOOKS.B_ID)
                .fetchOne()
                .getBId();
    }

    public int deleteBook(final int bookId) {
        return dsl.deleteFrom(BOOKS).where(BOOKS.B_ID.equal(bookId)).execute();
    }

    private BookEntity toBookEntity(Record record) {
        return new BookEntity(
                record.getValue(BOOKS.B_ID),
                record.getValue(BOOKS.B_TITLE),
                toAuthorEntity(record)
        );
    }

    private AuthorEntity toAuthorEntity(Record record) {
        return new AuthorEntity(
                record.getValue(AUTHORS.A_ID),
                record.getValue(AUTHORS.A_FIRST_NAME),
                record.getValue(AUTHORS.A_LAST_NAME)
        );
    }
}
