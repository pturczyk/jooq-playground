/**
 * This class is generated by jOOQ
 */
package io.pturczyk.jooq.domain;


import io.pturczyk.jooq.domain.tables.Authors;
import io.pturczyk.jooq.domain.tables.Books;
import io.pturczyk.jooq.domain.tables.records.AuthorsRecord;
import io.pturczyk.jooq.domain.tables.records.BooksRecord;

import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;


/**
 * A class modelling foreign key relationships between tables of the <code>publib</code> 
 * schema
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<AuthorsRecord, Integer> IDENTITY_AUTHORS = Identities0.IDENTITY_AUTHORS;
    public static final Identity<BooksRecord, Integer> IDENTITY_BOOKS = Identities0.IDENTITY_BOOKS;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AuthorsRecord> AUTHORS_PKEY = UniqueKeys0.AUTHORS_PKEY;
    public static final UniqueKey<BooksRecord> BOOKS_PKEY = UniqueKeys0.BOOKS_PKEY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<BooksRecord, AuthorsRecord> BOOKS__BOOKS_B_AUTHOR_ID_FKEY = ForeignKeys0.BOOKS__BOOKS_B_AUTHOR_ID_FKEY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 extends AbstractKeys {
        public static Identity<AuthorsRecord, Integer> IDENTITY_AUTHORS = createIdentity(Authors.AUTHORS, Authors.AUTHORS.A_ID);
        public static Identity<BooksRecord, Integer> IDENTITY_BOOKS = createIdentity(Books.BOOKS, Books.BOOKS.B_ID);
    }

    private static class UniqueKeys0 extends AbstractKeys {
        public static final UniqueKey<AuthorsRecord> AUTHORS_PKEY = createUniqueKey(Authors.AUTHORS, "authors_pkey", Authors.AUTHORS.A_ID);
        public static final UniqueKey<BooksRecord> BOOKS_PKEY = createUniqueKey(Books.BOOKS, "books_pkey", Books.BOOKS.B_ID);
    }

    private static class ForeignKeys0 extends AbstractKeys {
        public static final ForeignKey<BooksRecord, AuthorsRecord> BOOKS__BOOKS_B_AUTHOR_ID_FKEY = createForeignKey(io.pturczyk.jooq.domain.Keys.AUTHORS_PKEY, Books.BOOKS, "books__books_b_author_id_fkey", Books.BOOKS.B_AUTHOR_ID);
    }
}
