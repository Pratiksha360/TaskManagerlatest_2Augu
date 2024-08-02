package com.franchiseworld.taskmanager.serviceImpl;

import com.franchiseworld.taskmanager.customexception.ProjectNotFoundException;
import com.franchiseworld.taskmanager.customexception.TaskNotFoundException;
import com.franchiseworld.taskmanager.model.Employees;
import com.franchiseworld.taskmanager.model.Projects;
import com.franchiseworld.taskmanager.repos.ProjectsRepo;
import com.franchiseworld.taskmanager.service.AdminEmployeeService;
import com.franchiseworld.taskmanager.service.AdminProjectService;
import com.franchiseworld.taskmanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class AdminProjectServiceImpl implements AdminProjectService {


    @Autowired
    private ProjectsRepo projectsRepo;

    @Autowired
    private AdminEmployeeService employeeService;

    @Override
    public Projects saveProjects(Projects projects,int id) {

        Employees employeeById = this.employeeService.getEmployee(id);

        projects.setStartDate(LocalDateTime.now());
        projects.setUpdatedAt(LocalDateTime.now());
        projects.setCreatedAt(LocalDateTime.now());
        projects.setEndDate(LocalDateTime.now());
        projects.setEmp(employeeById);
        projects.setFlag(true);
        projects.setProjectblock(false);
        return this.projectsRepo.save(projects);
    }

    @Override
    public Projects updateProjects(Projects projects, int id) {

        return this.projectsRepo.findById(id).map(p ->{
            projects.setProjectId(p.getProjectId());
            projects.setStartDate(p.getStartDate());
            projects.setUpdatedAt(LocalDateTime.now());
            projects.setCreatedAt(p.getCreatedAt());
            projects.setEndDate(LocalDateTime.now());
            return this.projectsRepo.save(projects);
        }).orElseThrow(() -> new ProjectNotFoundException("Project Not Found Exception!!!"));

    }

    @Override
    public Projects getProjects(int id) {
       return this.projectsRepo.findById(id).filter(e->e.isFlag()==true).orElseThrow(() -> new ProjectNotFoundException("Project Not Found Exception!!!"));

    }

    @Override
    public List<Projects> getAllProject() {
        return this.projectsRepo.findAll().stream().filter(project -> project.isFlag()==true).collect(Collectors.toList());
    }

    @Override
    public void deleteProjectById(int id) {
        this.projectsRepo.findById(id).map(
                projects -> {
                    projects.setFlag(false);
                    this.projectsRepo.save(projects);
                    return projects ;
                }
        ).orElseThrow(() -> new TaskNotFoundException("Project Not Found !!"));


    }

    @Override
    public void blockProject(int id) {
        Projects projects = this.projectsRepo.findById(id).map(p -> {
            p.setProjectId(p.getProjectId());
            p.setProjectblock(true);
            return p;
        }).orElseThrow(() -> new ProjectNotFoundException("Project Not Found Exception!!!"));

        this.projectsRepo.save(projects);
    }

    @Override
    public void unblockProject(int id) {
        Projects projects = this.projectsRepo.findById(id).map(p -> {
            p.setProjectId(p.getProjectId());
            p.setProjectblock(false);
            return p;
        }).orElseThrow(() -> new ProjectNotFoundException("Project Not Found Exception!!!"));

        this.projectsRepo.save(projects);
    }


}
