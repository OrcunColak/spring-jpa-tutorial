package com.colak.springjpatutorial.manytomany.lazywithjointable.mapstruct;

import com.colak.springjpatutorial.manytomany.lazywithjointable.dto.ProjectDTO;
import com.colak.springjpatutorial.manytomany.lazywithjointable.jpa.Project;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjectMapper {

    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    Project dtoToProject(ProjectDTO projectDTO);
}
