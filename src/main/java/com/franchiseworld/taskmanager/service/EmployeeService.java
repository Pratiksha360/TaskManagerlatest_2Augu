package com.franchiseworld.taskmanager.service;

import com.franchiseworld.taskmanager.model.Employees;

import java.util.List;

public interface EmployeeService {
    Employees saveEmployee(Employees employee);
    List<Employees> getAllEmployees();
    Employees getEmployeeById(int id);
    Employees updateEmployee(int id, Employees employeeDetails);
    void deleteEmployee(int id);

}
