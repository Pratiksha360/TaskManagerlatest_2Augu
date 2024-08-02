package com.franchiseworld.taskmanager.service;

import com.franchiseworld.taskmanager.model.Salary;
import com.franchiseworld.taskmanager.model.Tasks;

import java.util.List;

public interface AdminSalaryService {


    public Salary saveSalary(Salary salary,int employeeid);

    public Salary updateSalary(Salary salary,int salaryid);

    public Salary getSalary(int id);

    public List<Salary> getAllSalary();


}
