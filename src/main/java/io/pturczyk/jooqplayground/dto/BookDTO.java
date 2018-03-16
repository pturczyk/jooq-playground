package io.pturczyk.jooqplayground.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDTO {
    private Integer id;
    private String title;
    private AuthorDTO author;
}
