package com.franchiseworld.taskmanager.repos;

import com.franchiseworld.taskmanager.model.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectsRepo extends JpaRepository<Projects,Integer> {
}
