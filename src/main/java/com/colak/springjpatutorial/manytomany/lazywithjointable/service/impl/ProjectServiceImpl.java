package com.colak.springjpatutorial.manytomany.lazywithjointable.service.impl;

import com.colak.springjpatutorial.manytomany.lazywithjointable.jpa.Project;
import com.colak.springjpatutorial.manytomany.lazywithjointable.respository.ProjectRepository;
import com.colak.springjpatutorial.manytomany.lazywithjointable.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Transactional
    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }
}
