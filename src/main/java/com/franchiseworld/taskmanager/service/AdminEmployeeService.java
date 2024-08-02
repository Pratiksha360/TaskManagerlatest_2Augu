package com.franchiseworld.taskmanager.service;


import com.franchiseworld.taskmanager.model.Employees;
import com.franchiseworld.taskmanager.modeldto.EmployeeDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AdminEmployeeService {


//    Create Employee
    public Employees saveEmployee(Employees emp);


    public Employees updateEmployee(EmployeeDto emp, int id);


    public List<Employees> getAllEmployees();

    public Employees getEmployee(int id);


    public void deleteEmployee(int id);


}
