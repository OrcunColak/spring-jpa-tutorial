package com.colak.springjpatutorial.manytomany.lazywithjointable.controller;

import com.colak.springjpatutorial.manytomany.lazywithjointable.dto.CompanyDTO;
import com.colak.springjpatutorial.manytomany.lazywithjointable.jpa.Company;
import com.colak.springjpatutorial.manytomany.lazywithjointable.mapstruct.CompanyMapper;
import com.colak.springjpatutorial.manytomany.lazywithjointable.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/getCompany/{companyId}")
    public CompanyDTO getCompany(@PathVariable(name = "companyId") Integer companyId) {
        CompanyMapper mapper = CompanyMapper.INSTANCE;

        return companyService.findById(companyId)
                .map(mapper::companyToDTO)
                .orElseThrow();
    }
}
