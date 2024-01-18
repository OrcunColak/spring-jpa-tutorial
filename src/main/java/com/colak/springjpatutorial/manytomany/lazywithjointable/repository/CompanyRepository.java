package com.colak.springjpatutorial.manytomany.lazywithjointable.repository;

import com.colak.springjpatutorial.manytomany.lazywithjointable.jpa.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

// We can also use QuerydslPredicateExecutor  instead of JpaSpecificationExecutor
public interface CompanyRepository extends JpaRepository<Company, Integer>, JpaSpecificationExecutor<Company> {
}
