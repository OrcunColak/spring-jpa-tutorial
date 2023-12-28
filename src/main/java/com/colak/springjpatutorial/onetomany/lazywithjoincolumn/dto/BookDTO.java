package com.colak.springjpatutorial.onetomany.lazywithjoincolumn.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class BookDTO {
    private Long id;

    String title;
}
