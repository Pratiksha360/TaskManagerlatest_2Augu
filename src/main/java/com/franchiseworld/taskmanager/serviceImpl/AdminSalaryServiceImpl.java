package com.franchiseworld.taskmanager.serviceImpl;

import com.franchiseworld.taskmanager.model.Employees;
import com.franchiseworld.taskmanager.model.Salary;
import com.franchiseworld.taskmanager.repos.EmployeesRepo;
import com.franchiseworld.taskmanager.repos.SalaryRepo;
import com.franchiseworld.taskmanager.service.AdminEmployeeService;
import com.franchiseworld.taskmanager.service.AdminSalaryService;
import com.franchiseworld.taskmanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminSalaryServiceImpl implements AdminSalaryService {



    @Autowired
    private SalaryRepo salaryRepo;


    @Autowired
    private AdminEmployeeService employeeService;


    @Autowired
    private EmployeesRepo employeesRepo;

    @Override
    public Salary saveSalary(Salary salary,int empid) {
        Employees employeeById = this.employeeService.getEmployee(empid);
        salary.setEmployees(employeeById);
       return this.salaryRepo.save(salary);
    }

    @Override
    public Salary updateSalary(Salary salary,int salaryid) {
        return this.salaryRepo.findById(salaryid).map(
                salary1 -> {
                    salary1.setSalaryID(salary1.getSalaryID());
                   return this.salaryRepo.save(salary);
                }
        ).orElseThrow(() -> new RuntimeException("Id Not Found!!!"));

    }

    @Override
    public Salary getSalary(int id) {
        return this.salaryRepo.findById(id).orElseThrow(() -> new RuntimeException("Id ot Found !!!"));
    }

    @Override
    public List<Salary> getAllSalary() {
        return this.salaryRepo.findAll();
    }
}
