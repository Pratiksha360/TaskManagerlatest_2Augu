package com.franchiseworld.taskmanager.serviceImpl;

import com.franchiseworld.taskmanager.customexception.UserNameNotFoundException;
import com.franchiseworld.taskmanager.model.Employees;
import com.franchiseworld.taskmanager.modeldto.EmployeeDto;
import com.franchiseworld.taskmanager.repos.EmployeesRepo;
import com.franchiseworld.taskmanager.service.AdminEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminEmployeeServiceImpl implements AdminEmployeeService {


    @Autowired
    private EmployeesRepo employeesRepo;

    @Override
    public Employees saveEmployee(Employees emp) {
        emp.setFlag(true);
        return this.employeesRepo.save(emp);
    }

    @Override
    public Employees updateEmployee(EmployeeDto emp, int id) {

        Employees updateEmployee = this.employeesRepo.findById(id).map(
                employees -> {
                    employees.setFirstName(emp.getFirstName());
                    employees.setMiddleName(emp.getMiddleName());
                    employees.setLastName(emp.getLastName());
                    employees.setEmail(emp.getEmailId());
                    employees.setContactNo(emp.getContactNo());
                    return this.employeesRepo.save(employees);
                }
        ).orElseThrow(
                () -> new UserNameNotFoundException("User NOt Found !!!")
        );


        return updateEmployee;
    }

    @Override
    public List<Employees> getAllEmployees(  ) {
        return this.employeesRepo.findAll().stream().filter(employees -> employees.getFlag()==true).collect(Collectors.toList());
    }

    @Override
    public Employees getEmployee(int id) {
        return this.employeesRepo.findById(id).filter(employees -> employees.getFlag()==true).orElseThrow(() -> new UserNameNotFoundException("User Not Found !!"));
    }

    @Override
    public void deleteEmployee(int id) {
        this.employeesRepo.findById(id).map(
                employees -> {
                    employees.setFlag(false);
                    this.employeesRepo.save(employees);
                    return employees;
                }
        );
    }


}
