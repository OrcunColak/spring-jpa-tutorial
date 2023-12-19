package com.colak.springjpatutorial.manytomany.lazywithjointable.mapstruct;

import com.colak.springjpatutorial.manytomany.lazywithjointable.dto.CompanyDTO;
import com.colak.springjpatutorial.manytomany.lazywithjointable.jpa.Company;
import com.colak.springjpatutorial.manytomany.lazywithjointable.jpa.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CompanyMapper {

    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    @Mapping(source = "projects", target = "projectIds", qualifiedByName = "projectToId")
    CompanyDTO companyToDTO(Company company);

    Company dtoToCompany(CompanyDTO companyDTO);

    @Named("projectToId")
    public static Integer projectToId(Project project) {
        return project.getId();
    }
}
