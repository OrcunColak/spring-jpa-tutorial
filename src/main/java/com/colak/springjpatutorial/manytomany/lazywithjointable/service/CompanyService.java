package com.colak.springjpatutorial.manytomany.lazywithjointable.service;

import com.colak.springjpatutorial.manytomany.lazywithjointable.jpa.Company;

import java.util.Optional;

public interface CompanyService {

    Optional<Company> findById (Integer id);

    Company save(Company company);
}
