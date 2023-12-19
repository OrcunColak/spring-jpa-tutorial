package com.colak.springjpatutorial.manytomany.lazywithjointable.controller;

import com.colak.springjpatutorial.manytomany.lazywithjointable.dto.ProjectDTO;
import com.colak.springjpatutorial.manytomany.lazywithjointable.jpa.Project;
import com.colak.springjpatutorial.manytomany.lazywithjointable.mapstruct.ProjectMapper;
import com.colak.springjpatutorial.manytomany.lazywithjointable.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping("/createProject")
    public Project createCompany(@RequestBody ProjectDTO projectDTO) {
        Project project = ProjectMapper.INSTANCE.dtoToProject(projectDTO);

        return projectService.save(project);
    }
}
