package com.colak.springjpatutorial.manytomany.lazywithjointable.service.impl;

import com.colak.springjpatutorial.manytomany.lazywithjointable.jpa.Company;
import com.colak.springjpatutorial.manytomany.lazywithjointable.respository.CompanyRepository;
import com.colak.springjpatutorial.manytomany.lazywithjointable.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Transactional
    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }
}
