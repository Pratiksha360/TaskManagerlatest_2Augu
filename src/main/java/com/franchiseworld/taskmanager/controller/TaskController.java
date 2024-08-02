package com.franchiseworld.taskmanager.controller;


import com.franchiseworld.taskmanager.model.Employees;
import com.franchiseworld.taskmanager.model.Tasks;
import com.franchiseworld.taskmanager.service.EmployeeService;
import com.franchiseworld.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/createtask")
    public ResponseEntity<Tasks> createTask(@RequestBody Tasks task) {
        Tasks createdTask = taskService.saveTask(task);
        return ResponseEntity.status(201).body(createdTask);
    }

    @GetMapping("/getalltask")
    public List<Tasks> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/gettaskbyid/{id}")
    public ResponseEntity<Tasks> getTaskById(@PathVariable int id) {
        Optional<Tasks> task = Optional.ofNullable(taskService.getTaskById(id));
        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/updatetask/{id}")
    public ResponseEntity<Tasks> updateTask(@PathVariable int id, @Valid @RequestBody Tasks taskDetails) {
        Tasks updatedTask = taskService.updateTask(id, taskDetails);
        if (updatedTask == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedTask);
    }

    //to assign task acc to id
    @GetMapping("/getemployeebytaskid/{taskId}")
    public ResponseEntity<Employees> assignTaskToEmployee(
            @PathVariable int taskId) {
        Optional<Tasks> task = Optional.ofNullable(taskService.getTaskById(taskId));

        Employees employee = taskService.getEmployeeByTaskId(taskId);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }


}

