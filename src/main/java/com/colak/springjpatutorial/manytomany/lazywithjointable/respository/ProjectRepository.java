package com.colak.springjpatutorial.manytomany.lazywithjointable.respository;

import com.colak.springjpatutorial.manytomany.lazywithjointable.jpa.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
