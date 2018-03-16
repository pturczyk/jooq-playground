package io.pturczyk.jooqplayground.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthorEntity {
    final Integer id;
    final String firstName;
    final String lastName;
}
