package com.colak.springjpatutorial.onetomany.bidirectional.lazywithjoincolumn.controller;

import com.colak.springjpatutorial.onetomany.bidirectional.lazywithjoincolumn.dto.AuthorDTO;
import com.colak.springjpatutorial.onetomany.bidirectional.lazywithjoincolumn.dto.BookDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
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

        assertAuthor(firstAuthorDTO);
    }

    @Test
    void testFindAllWithBooksEntityGraph() {
        String getUrl = "/api/author/findByIdEntityGraph/1";

        ResponseEntity<AuthorDTO> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });
        AuthorDTO authorDTO = response.getBody();

        assertAuthor(authorDTO);
    }

    @Test
    void testFindAllWithBooksEntityGraphNoBooks() {
        String getUrl = "/api/author/findByIdEntityGraph/2";

        ResponseEntity<AuthorDTO> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });
        AuthorDTO authorDTO = response.getBody();

        AuthorDTO expected = new AuthorDTO();
        expected.setId(2L);
        expected.setName("author-2");
        expected.setBooks(Collections.emptyList());

        assertEquals(expected, authorDTO);
    }

    private static void assertAuthor(AuthorDTO firstAuthorDTO) {
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
