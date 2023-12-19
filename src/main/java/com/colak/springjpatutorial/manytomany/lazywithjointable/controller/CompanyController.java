package com.colak.springjpatutorial.manytomany.lazywithjointable.controller;

import com.colak.springjpatutorial.manytomany.lazywithjointable.dto.CompanyDTO;
import com.colak.springjpatutorial.manytomany.lazywithjointable.jpa.Company;
import com.colak.springjpatutorial.manytomany.lazywithjointable.mapstruct.CompanyMapper;
import com.colak.springjpatutorial.manytomany.lazywithjointable.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/company")
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping("/createCompany")
    public Company createCompany(@RequestBody CompanyDTO companyDTO) {
        Company company = CompanyMapper.INSTANCE.dtoToCompany(companyDTO);

        return companyService.save(company);
    }
}
