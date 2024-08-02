package com.franchiseworld.taskmanager.controller;


import com.franchiseworld.taskmanager.model.Employees;
import com.franchiseworld.taskmanager.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/createemployee")
    public ResponseEntity<?> createEmployee(@Valid @RequestBody  Employees employee) {
        try {
            Employees createdEmployee = employeeService.saveEmployee(employee);
            return ResponseEntity.ok(createdEmployee);
        } catch (DataIntegrityViolationException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Duplicate field value: " + ex.getMostSpecificCause().getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @GetMapping("/getallemployee")
    public List<Employees> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/getemployeebyid/{id}")
    public ResponseEntity<Employees> getEmployeeById(@PathVariable int id) {
        Optional<Employees> employee = Optional.ofNullable(employeeService.getEmployeeById(id));
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/updateemployeebyid/{id}")
    public ResponseEntity<Employees> updateEmployee(@PathVariable int id, @Valid @RequestBody Employees employeeDetails) {
        Employees updatedEmployee = employeeService.updateEmployee(id, employeeDetails);
        if (updatedEmployee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedEmployee);
    }

   /*  @DeleteMapping("/deleteemployeebyid/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();*/
    }

