package com.colak.springjpatutorial.manytomany.lazywithjointable.mapstruct;

import com.colak.springjpatutorial.manytomany.lazywithjointable.dto.CompanyDTO;
import com.colak.springjpatutorial.manytomany.lazywithjointable.jpa.Company;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CompanyMapper {

    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    Company dtoToCompany(CompanyDTO companyDTO);
}
