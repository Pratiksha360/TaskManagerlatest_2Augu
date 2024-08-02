package com.franchiseworld.taskmanager.serviceImpl;


import com.franchiseworld.taskmanager.model.Employees;
import com.franchiseworld.taskmanager.model.Tasks;
import com.franchiseworld.taskmanager.repos.TaskRepo;
import com.franchiseworld.taskmanager.service.TaskService;

import jakarta.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepo taskRepository;

    @Override
    public Tasks saveTask(Tasks task) {
        return taskRepository.save(task);
    }
    
    @Override
    public List<Tasks> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Tasks getTaskById(int id) {
        Optional<Tasks> optionalTask = taskRepository.findById(id);
        return optionalTask.orElse(null);
    }

    @Override
    public Tasks updateTask(int id, Tasks taskDetails) {
        Optional<Tasks> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Tasks task = optionalTask.get();
            task.setTaskName(taskDetails.getTaskName());
            task.setDescription(taskDetails.getDescription());
            task.setProjects(taskDetails.getProjects());
            task.setStatus(taskDetails.getStatus());
            task.setStartDate(taskDetails.getStartDate());
            task.setEndDate(taskDetails.getEndDate());
            task.setEmployees(taskDetails.getEmployees());
            task.setEstimatedTime(taskDetails.getEstimatedTime());
            return taskRepository.save(task);
        }
        return null;
    }
    
    



    @Override
    public Employees getEmployeeByTaskId(int taskId) {
        return taskRepository.findAssignedEmployeeByTaskId(taskId);
    }


}
