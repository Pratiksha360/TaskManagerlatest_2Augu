package com.franchiseworld.taskmanager.service;

import com.franchiseworld.taskmanager.model.Tasks;

import java.util.List;

public interface AdminTasksService {



    public Tasks saveTasks(Tasks task,int projectid,int empid);

    public Tasks updateTasks(Tasks tasks, int id,int projectId,int employeeId);

    public Tasks getTask(int id);

    public List<Tasks> getAllTasks();

    public void  deleteTaskById(int id);

}
