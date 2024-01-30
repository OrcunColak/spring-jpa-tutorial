package com.colak.springjpatutorial.hibernate.formula.repository;


import com.colak.springjpatutorial.hibernate.formula.jpa.AuthorFormula;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AuthorFormulaRepositoryTest {

    @Autowired
    private AuthorFormulaRepository authorFormulaRepository;

    @Test
    void testFormula() {
        AuthorFormula authorFormula = new AuthorFormula();
        authorFormula.setAge(40);
        AuthorFormula savedAuthorFormula = authorFormulaRepository.saveAndFlush(authorFormula);

        AuthorFormula byId = authorFormulaRepository.findById(savedAuthorFormula.getId()).get();
        assertEquals(400, byId.getTenAge());
    }
}

