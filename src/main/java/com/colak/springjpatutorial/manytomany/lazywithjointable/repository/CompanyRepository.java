package com.colak.springjpatutorial.manytomany.lazywithjointable.repository;

import com.colak.springjpatutorial.manytomany.lazywithjointable.jpa.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
