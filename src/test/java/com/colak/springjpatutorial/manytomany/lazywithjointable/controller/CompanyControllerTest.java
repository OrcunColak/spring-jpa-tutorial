package com.colak.springjpatutorial.manytomany.lazywithjointable.controller;

import com.colak.springjpatutorial.manytomany.lazywithjointable.dto.CompanyDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CompanyControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    void testGetCompany() {
        String getUrl = "/api/company/getCompany/1";

        ResponseEntity<CompanyDTO> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        CompanyDTO companyDTO = response.getBody();

        CompanyDTO expected = new CompanyDTO()
                .setId(1)
                .setName("company-1")
                .setProjectIds(Set.of(10));

        assertThat(companyDTO).isEqualTo(expected);
    }
}
