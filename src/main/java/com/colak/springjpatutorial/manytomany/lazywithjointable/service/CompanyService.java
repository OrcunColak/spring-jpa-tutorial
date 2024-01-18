package com.colak.springjpatutorial.manytomany.lazywithjointable.service;

import com.colak.springjpatutorial.manytomany.lazywithjointable.jpa.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {

    Optional<Company> findById (Integer id);

    Company save(Company company);

    List<Company> findAllWithName (String name);
}
