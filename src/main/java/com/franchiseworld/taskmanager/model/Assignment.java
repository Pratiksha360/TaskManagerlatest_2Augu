package com.franchiseworld.taskmanager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Assignment {
    private String assignedAt;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int assignmentID;

    @ManyToOne
    @JsonBackReference(value = "employess-assignment")
    @NotBlank
    private Employees employeeID;
    @ManyToOne
    @JsonBackReference(value = "projects-assignment")
    @NotBlank
    private Projects projectID;

    @NotBlank
    private String remark;

    @NotBlank
    private String remarkDescription;

    @NotBlank
    private int taskID;

    @NotBlank
    private String workStatus;


    @NotBlank
    private boolean assignflag;

    // Constructor


    public Assignment() {
    }

    public Assignment(String assignedAt, int assignmentID, Employees employeeID, Projects projectID, String remark, String remarkDescription, int taskID, String workStatus, boolean assignflag) {
        this.assignedAt = assignedAt;
        this.assignmentID = assignmentID;
        this.employeeID = employeeID;
        this.projectID = projectID;
        this.remark = remark;
        this.remarkDescription = remarkDescription;
        this.taskID = taskID;
        this.workStatus = workStatus;
        this.assignflag = assignflag;
    }

    // Getters and Setters
    public String getAssignedAt() {
        return assignedAt;
    }

    public void setAssignedAt(String assignedAt) {
        this.assignedAt = assignedAt;
    }

    public int getAssignmentID() {
        return assignmentID;
    }

    public void setAssignmentID(int assignmentID) {
        this.assignmentID = assignmentID;
    }

    public boolean isAssignflag() {
        return assignflag;
    }

    public void setAssignflag(boolean assignflag) {
        this.assignflag = assignflag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemarkDescription() {
        return remarkDescription;
    }

    public void setRemarkDescription(String remarkDescription) {
        this.remarkDescription = remarkDescription;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    public Employees getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Employees employeeID) {
        this.employeeID = employeeID;
    }

    public Projects getProjectID() {
        return projectID;
    }

    public void setProjectID(Projects projectID) {
        this.projectID = projectID;
    }
}