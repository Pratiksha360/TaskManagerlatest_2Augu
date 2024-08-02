package com.franchiseworld.taskmanager.service;

import com.franchiseworld.taskmanager.model.Projects;

import java.util.List;

public interface AdminProjectService {

    public Projects saveProjects(Projects projects,int id);

    public Projects updateProjects(Projects projects,int id);

    public Projects getProjects(int id);

    public List<Projects> getAllProject();

    public void  deleteProjectById(int id);

    public void blockProject(int id);

    public void unblockProject(int id);



}
