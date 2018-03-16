package io.pturczyk.jooqplayground.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookEntity {
    private Integer id;
    private String title;
    private AuthorEntity author;
}
