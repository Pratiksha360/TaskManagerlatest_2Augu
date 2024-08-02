package com.franchiseworld.taskmanager.controller;


import com.franchiseworld.taskmanager.customexception.UserNameNotFoundException;
import com.franchiseworld.taskmanager.model.Employees;
import com.franchiseworld.taskmanager.modeldto.EmploeeFormDto;
import com.franchiseworld.taskmanager.repos.EmployeesRepo;
import com.franchiseworld.taskmanager.service.AdminEmployeeFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FormController {

    @Autowired
   private AdminEmployeeFormService formService;

    @PostMapping("/login")
    public ResponseEntity<Employees> LoginForm(@RequestBody EmploeeFormDto emp){
        Employees employees = this.formService.getEmployee(emp);
        return ResponseEntity.ok(employees);
    }

}
