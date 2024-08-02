package com.franchiseworld.taskmanager.serviceImpl;


import com.franchiseworld.taskmanager.model.Projects;
import com.franchiseworld.taskmanager.repos.ProjectsRepo;
import com.franchiseworld.taskmanager.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectsRepo projectRepository;

    @Override
    public Projects saveProject(Projects project) {


        return projectRepository.save(project);
    }

    @Override
    public List<Projects> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Projects getProjectById(int id) {
        Optional<Projects> optionalProject = projectRepository.findById(id);
        return optionalProject.orElse(null);
    }

    @Override
    public Projects updateProject(int id, Projects projectDetails) {
        Optional<Projects> optionalProject = projectRepository.findById(id);
        if (optionalProject.isPresent()) {
            Projects project = optionalProject.get();
            project.setProjectName(projectDetails.getProjectName());
            project.setDescription(projectDetails.getDescription());
            project.setStartDate(projectDetails.getStartDate());
            project.setEndDate(projectDetails.getEndDate());
            project.setStatus(projectDetails.getStatus());
            return projectRepository.save(project);
        }
        return null;
    }

    @Override
    public void deleteProject(int id) {
        projectRepository.deleteById(id);
    }
}

