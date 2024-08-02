package com.franchiseworld.taskmanager.serviceImpl;

import com.franchiseworld.taskmanager.customexception.UserNameNotFoundException;
import com.franchiseworld.taskmanager.model.Employees;
import com.franchiseworld.taskmanager.modeldto.EmploeeFormDto;
import com.franchiseworld.taskmanager.repos.EmployeesRepo;
import com.franchiseworld.taskmanager.service.AdminEmployeeFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminEmployeeFormServiceImpl implements AdminEmployeeFormService {

    @Autowired
    private EmployeesRepo employeesRepo;
    @Override
    public Employees getEmployee(EmploeeFormDto user) {
        return employeesRepo.findEmployeesByUsernameOrEmail(user.getUsernameEmail(), user.getPassword()).orElseThrow(() -> new UserNameNotFoundException("User Not Found !!!!"));
    }
}
