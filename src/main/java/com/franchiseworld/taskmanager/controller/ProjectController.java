package com.franchiseworld.taskmanager.controller;


import com.franchiseworld.taskmanager.model.Projects;
import com.franchiseworld.taskmanager.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping("/createproject")
    public ResponseEntity<Projects> createProject(@Valid @RequestBody Projects project) {
        Projects createdProject = projectService.saveProject(project);
        return ResponseEntity.ok(createdProject);
    }

    @GetMapping("/getallproject")
    public List<Projects> getAllProjects() {
        return projectService.getAllProjects();
    }


    @GetMapping("/getprojectbyid/{id}")
    public ResponseEntity<Projects> getTaskById(@PathVariable int id) {
        Optional<Projects> project= Optional.ofNullable(projectService.getProjectById(id));
        return project.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/updateprojectbyid/{id}")
    public ResponseEntity<Projects> updateProject(@PathVariable Long id, @Valid @RequestBody Projects projectDetails) {
        Projects updatedProject = projectService.updateProject(Integer.parseInt(id.toString()), projectDetails);
        if (updatedProject == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedProject);
    }
// Delete acces by Admin only or hr pannel 
    @DeleteMapping("/deleteprojectbyid/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable int id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}

