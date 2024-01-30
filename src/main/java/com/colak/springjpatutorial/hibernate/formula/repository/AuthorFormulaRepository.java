package com.colak.springjpatutorial.hibernate.formula.repository;

import com.colak.springjpatutorial.hibernate.formula.jpa.AuthorFormula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorFormulaRepository extends JpaRepository<AuthorFormula,Long> {
}
