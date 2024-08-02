package com.franchiseworld.taskmanager.service;

import com.franchiseworld.taskmanager.model.Employees;
import com.franchiseworld.taskmanager.model.Projects;
import com.franchiseworld.taskmanager.model.Tasks;

import java.time.LocalDate;
import java.util.List;

public interface HRService {
//	i comment this
    List<Employees> getAllEmployees();
    
    public Employees getEmployeeById(int id);
    
    Employees updateEmployee(int id, Employees employeeDetails);
    
    void redFlagEmployee(int id);
    
    List<Object[]> getTasksByEmployeeId(int employeeID);
    
//    public boolean updateSalary(int id,String salary);
    
    
    
    
    
    
    
//
//    Employees addEmployee(Employees employees);
//
//    Employees updateEmployee(int employeeId, Employees employees);


    //Employees updateEmployee(int employeeId, String position, String email, String contactNo);


    List<Object[]> getMonthlyEmployeeLogins(int month, Integer employeeId);

    List<Object[]> getMonthlyEmployeeLogouts(int month, Integer employeeId);

    List<Object[]> getEmployeeLoginsBetweenDatesAndEmployeeId(LocalDate startDate, LocalDate endDate,
                                                              Integer employeeId);

    List<Object[]> getEmployeeLogoutsBetweenDatesAndEmployeeId(LocalDate startDate, LocalDate endDate,
                                                               Integer employeeId);

    List<Object[]> getWeeklyEmployeeLogins(LocalDate startDate, LocalDate endDate, Integer employeeId);
    List<Object[]> getWeeklyEmployeeLogouts(LocalDate startDate, LocalDate endDate, Integer employeeId);

    

    Projects getProjectById(int projectId);

    Tasks getTaskById(int taskId);

}

