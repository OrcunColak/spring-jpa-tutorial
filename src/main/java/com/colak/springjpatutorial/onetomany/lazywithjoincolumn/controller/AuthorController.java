package com.colak.springjpatutorial.onetomany.lazywithjoincolumn.controller;

import com.colak.springjpatutorial.onetomany.lazywithjoincolumn.dto.AuthorDTO;
import com.colak.springjpatutorial.onetomany.lazywithjoincolumn.mapstruct.AuthorMapper;
import com.colak.springjpatutorial.onetomany.lazywithjoincolumn.service.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/author")
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/findAllWithBooks")
    @Operation(
            summary = "Retrieve Author and Book using JPQL 'JOIN FETCH'",
            tags = {"Author Controller"},
            description = "Shows solution to N+1 Select Problem using JPQL"
    )
    public List<AuthorDTO> findAllWithBooks() {
        AuthorMapper mapper = AuthorMapper.INSTANCE;

        return authorService.findAllWithBooks()
                .stream()
                .map(mapper::authorToDTO)
                .toList();
    }

    @GetMapping("/findByIdEntityGraph/{id}")
    @Operation(
            summary = "Retrieve Author and Book using @EntityGraph",
            tags = {"Author Controller"},
            description = "Shows solution to N+1 Select Problem using Spring's @EntityGraph annotation"
    )

    public AuthorDTO findByIdEntityGraph(@PathVariable(name = "id") Long id) {
        AuthorMapper mapper = AuthorMapper.INSTANCE;

        return authorService.findById(id)
                .map(mapper::authorToDTO)
                .orElseThrow();

    }
}
