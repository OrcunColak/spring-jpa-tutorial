package com.colak.springjpatutorial.manytomany.lazywithjointable.service.impl;

import com.colak.springjpatutorial.manytomany.lazywithjointable.jpa.Company;
import com.colak.springjpatutorial.manytomany.lazywithjointable.repository.CompanyRepository;
import com.colak.springjpatutorial.manytomany.lazywithjointable.service.CompanyService;
import com.colak.springjpatutorial.manytomany.lazywithjointable.specification.CompanySpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Transactional(readOnly = true)
    @Override
    public Optional<Company> findById(Integer id) {
        return companyRepository.findById(id);
    }

    @Transactional
    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Company> findAllWithName(String name) {
        Specification<Company> specification = CompanySpecifications.hasName(name);
        return companyRepository.findAll(specification);
    }
}
