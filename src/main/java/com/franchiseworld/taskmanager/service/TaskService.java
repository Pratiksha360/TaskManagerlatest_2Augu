package com.franchiseworld.taskmanager.service;


import com.franchiseworld.taskmanager.model.Employees;
import com.franchiseworld.taskmanager.model.Tasks;

import java.util.List;

public interface TaskService {
	Tasks saveTask(Tasks task);
    List<Tasks> getAllTasks();
    Tasks getTaskById(int id);
    Tasks updateTask(int id, Tasks taskDetails);

    Employees getEmployeeByTaskId(int taskId);
}
