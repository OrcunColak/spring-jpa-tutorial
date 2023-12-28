package com.colak.springjpatutorial.manytomany.lazywithjointable.service.impl;

import com.colak.springjpatutorial.manytomany.lazywithjointable.jpa.Company;
import com.colak.springjpatutorial.manytomany.lazywithjointable.repository.CompanyRepository;
import com.colak.springjpatutorial.manytomany.lazywithjointable.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public Optional<Company> findById(Integer id) {
        return companyRepository.findById(id);
    }

    @Transactional
    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }
}
