package com.franchiseworld.taskmanager.service;


import com.franchiseworld.taskmanager.model.Projects;

import java.util.List;

public interface ProjectService {
    Projects saveProject(Projects project);
    List<Projects> getAllProjects();
    Projects getProjectById(int id);
    Projects updateProject(int id, Projects projectDetails);
    void deleteProject(int id);
}
