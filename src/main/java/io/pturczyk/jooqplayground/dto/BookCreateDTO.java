package io.pturczyk.jooqplayground.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookCreateDTO {
    private Integer id;
    private String title;
}
