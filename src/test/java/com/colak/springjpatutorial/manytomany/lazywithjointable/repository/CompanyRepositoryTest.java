package com.colak.springjpatutorial.manytomany.lazywithjointable.repository;

import com.colak.springjpatutorial.manytomany.lazywithjointable.jpa.Company;
import com.colak.springjpatutorial.manytomany.lazywithjointable.specification.CompanySpecifications;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class CompanyRepositoryTest {

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    void testHasName() {
        Specification<Company> specification = CompanySpecifications.hasName("company-1");
        List<Company> companyList = companyRepository.findAll(specification);
        assertEquals(1, companyList.size());
    }

    @Test
    void testIdRange() {
        Specification<Company> specification = CompanySpecifications.isWithinIdRange(1, 2);
        List<Company> companyList = companyRepository.findAll(specification);
        assertEquals(2, companyList.size());
    }

    @Test
    void testHasNames() {
        Specification<Company> specification = CompanySpecifications.hasNames(List.of("company-1", "company-2"));
        List<Company> companyList = companyRepository.findAll(specification);
        assertEquals(2, companyList.size());
    }

    @Test
    void testHasAtLeastProjects() {
        Specification<Company> specification = CompanySpecifications.hasAtLeastProjects(1);
        List<Company> companyList = companyRepository.findAll(specification);
        assertEquals(1, companyList.size());
    }

    public interface CompanyIdOnly {
        int getId();
    }

    @Test
    void testHasAtLeastProjectsWithProjection() {
        Specification<Company> specification = CompanySpecifications.hasAtLeastProjects(1);
        List<CompanyIdOnly> companyList = companyRepository.findBy(specification, q -> q.as(CompanyIdOnly.class).all());;
        assertEquals(1, companyList.size());
        CompanyIdOnly first = companyList.getFirst();
        assertEquals(1, first.getId());
    }
}
