package com.colak.springjpatutorial.onetomany.lazywithjoincolumn.controller;

import com.colak.springjpatutorial.onetomany.lazywithjoincolumn.dto.AuthorDTO;
import com.colak.springjpatutorial.onetomany.lazywithjoincolumn.dto.BookDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AuthorControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testFindAllWithBooks() {

        String getUrl = "/api/author/findAllWithBooks";

        ResponseEntity<List<AuthorDTO>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });
        List<AuthorDTO> authorDTOList = response.getBody();
        assert authorDTOList != null;
        AuthorDTO firstAuthorDTO = authorDTOList.getFirst();

        BookDTO book1 = new BookDTO();
        book1.setId(1L);
        book1.setTitle("book-1");

        BookDTO book2 = new BookDTO();
        book2.setId(2L);
        book2.setTitle("book-2");

        AuthorDTO expected = new AuthorDTO();
        expected.setId(1L);
        expected.setName("author-1");
        expected.setBooks(List.of(book1, book2));

        assertEquals(expected, firstAuthorDTO);
    }

}
