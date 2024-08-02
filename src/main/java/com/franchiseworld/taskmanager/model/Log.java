package com.franchiseworld.taskmanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "logs")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LogID")
    private Long logID;

    @ManyToOne
    @JoinColumn(name = "EmployeeID")
    @NotNull(message = "Employee must not be null")
    private Employees employee;

    @Column(name = "LogDate")
    @NotNull(message = "LogDate must not be null")
    private LocalDate logDate;

    @Column(name = "LogInTime")
    @NotNull(message = "LogInTime must not be null")
    private LocalDateTime logInTime;

    @Column(name = "LogOutTime")
    @NotNull(message = "LogOutTime must not be null")
    private LocalDateTime logOutTime;

    // Getters and setters
    public Long getLogID() {
        return logID;
    }

    public void setLogID(Long logID) {
        this.logID = logID;
    }

    public Employees getEmployee() {
        return employee;
    }

    public void setEmployee(Employees employee) {
        this.employee = employee;
    }

    public LocalDate getLogDate() {
        return logDate;
    }

    public void setLogDate(LocalDate logDate) {
        this.logDate = logDate;
    }

    public LocalDateTime getLogInTime() {
        return logInTime;
    }

    public void setLogInTime(LocalDateTime logInTime) {
        this.logInTime = logInTime;
    }

    public LocalDateTime getLogOutTime() {
        return logOutTime;
    }

    public void setLogOutTime(LocalDateTime logOutTime) {
        this.logOutTime = logOutTime;
    }

    public Log() {
    }

    public Log(Long logID, Employees employee, LocalDate logDate, LocalDateTime logInTime, LocalDateTime logOutTime) {
        this.logID = logID;
        this.employee = employee;
        this.logDate = logDate;
        this.logInTime = logInTime;
        this.logOutTime = logOutTime;
    }
}
