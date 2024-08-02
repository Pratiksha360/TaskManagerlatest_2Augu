package com.franchiseworld.taskmanager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int salaryID;


    @NotBlank
    private String salary;

    @OneToOne
    @JsonBackReference(value = "emp-salary")
    private Employees employees;

    
    public Salary() {
    }

    public Salary(int salaryID, String salary, Employees employees) {
        this.salaryID = salaryID;
        this.salary = salary;
        this.employees = employees;
    }

    public int getSalaryID() {
        return salaryID;
    }

    public void setSalaryID(int salaryID) {
        this.salaryID = salaryID;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }
}
