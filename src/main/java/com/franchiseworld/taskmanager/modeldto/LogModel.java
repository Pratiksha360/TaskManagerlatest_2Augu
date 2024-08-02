package com.franchiseworld.taskmanager.modeldto;


import java.time.LocalDate;
import java.time.LocalDateTime;

public class LogModel {
   private Long employeeID;
    private LocalDate logDate;

    private LocalDateTime logInTime;

    private LocalDateTime logOutTime;

    public LogModel() {
    }

    public LogModel(Long employeeID, LocalDate logDate, LocalDateTime logInTime, LocalDateTime logOutTime) {
        this.employeeID = employeeID;
        this.logDate = logDate;
        this.logInTime = logInTime;
        this.logOutTime = logOutTime;
    }

    public Long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Long employeeID) {
        this.employeeID = employeeID;
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
}
