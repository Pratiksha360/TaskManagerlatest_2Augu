package com.franchiseworld.taskmanager.serviceImpl;

import com.franchiseworld.taskmanager.customexception.TaskNotFoundException;
import com.franchiseworld.taskmanager.model.Employees;
import com.franchiseworld.taskmanager.model.Projects;
import com.franchiseworld.taskmanager.model.Tasks;
import com.franchiseworld.taskmanager.repos.EmployeesRepo;
import com.franchiseworld.taskmanager.repos.ProjectsRepo;
import com.franchiseworld.taskmanager.repos.TaskRepo;
import com.franchiseworld.taskmanager.service.AdminEmployeeService;
import com.franchiseworld.taskmanager.service.AdminProjectService;
import com.franchiseworld.taskmanager.service.AdminTasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminTasksServiceImpl implements AdminTasksService {



    @Autowired
    private TaskRepo taskRepo;

    @Autowired
    private AdminProjectService projectService;

    @Autowired
    private AdminEmployeeService adminEmployeeService;

    @Override
    public Tasks saveTasks(Tasks task,int projectid,int empid) {

        Projects projects = this.projectService.getProjects(projectid);
        Employees employee = this.adminEmployeeService.getEmployee(empid);
        task.setProjects(projects);
        task.setEmployees(employee);
        task.setFlag(1);
        return this.taskRepo.save(task);
    }

    @Override
    public Tasks updateTasks(Tasks tasks, int id,int projectId,int employeeId) {
        Tasks tasks1 = this.taskRepo.findById(id).map(
                t -> {
                    Projects projects = projectService.getProjects(projectId);
                    Employees employee = adminEmployeeService.getEmployee(employeeId);
                    tasks.setUpdatedAt(LocalDateTime.now());
                    tasks.setTaskID(t.getTaskID());
                    tasks.setProjects(projects);
                    tasks.setEmployees(employee);
                    return taskRepo.save(tasks);
                }
        ).orElseThrow(() -> new TaskNotFoundException("Task Not Found !!!"));
        return this.taskRepo.findById(tasks1.getTaskID()).get();
    }

    @Override
    public Tasks getTask(int id) {
        return  this.taskRepo.findById(id).filter(e->e.getFlag()==1).orElseThrow(() -> new TaskNotFoundException("Task Not Found !!"))
;
    }

    @Override
    public List<Tasks> getAllTasks() {
        return this.taskRepo.findAll().stream().filter(tasks -> tasks.getFlag()==1).collect(Collectors.toList());
    }

    @Override
    public void deleteTaskById(int id) {
       this.taskRepo.findById(id).map(
                tasks1 -> {
                    tasks1.setFlag(0);
                    this.taskRepo.save(tasks1);
                    return tasks1 ;
                }
        ).orElseThrow(() -> new TaskNotFoundException("Task Not Found !!"));

    }


}
