/**
 * This class is generated by jOOQ
 */
package io.pturczyk.jooq.domain;


import io.pturczyk.jooq.domain.tables.Authors;
import io.pturczyk.jooq.domain.tables.Books;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Sequence;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Publib extends SchemaImpl {

    private static final long serialVersionUID = 1731033861;

    /**
     * The reference instance of <code>publib</code>
     */
    public static final Publib PUBLIB = new Publib();

    /**
     * The table <code>publib.authors</code>.
     */
    public final Authors AUTHORS = io.pturczyk.jooq.domain.tables.Authors.AUTHORS;

    /**
     * The table <code>publib.books</code>.
     */
    public final Books BOOKS = io.pturczyk.jooq.domain.tables.Books.BOOKS;

    /**
     * No further instances allowed
     */
    private Publib() {
        super("publib", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Sequence<?>> getSequences() {
        List result = new ArrayList();
        result.addAll(getSequences0());
        return result;
    }

    private final List<Sequence<?>> getSequences0() {
        return Arrays.<Sequence<?>>asList(
            Sequences.AUTHORS_A_ID_SEQ,
            Sequences.BOOKS_B_ID_SEQ);
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            Authors.AUTHORS,
            Books.BOOKS);
    }
}
