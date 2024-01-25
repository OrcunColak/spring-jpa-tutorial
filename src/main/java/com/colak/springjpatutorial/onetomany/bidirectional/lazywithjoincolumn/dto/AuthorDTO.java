package com.colak.springjpatutorial.onetomany.bidirectional.lazywithjoincolumn.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class AuthorDTO {

    private Long id;

    private String name;

    private List<BookDTO> books;
}
