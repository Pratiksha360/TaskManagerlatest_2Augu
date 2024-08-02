package com.franchiseworld.taskmanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.sql.Date;
import java.time.LocalDateTime;


@Entity
public class TaskUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long updateID;

    @NotBlank
    private String updateDescription;

    @NotBlank
    private String status;
    @NotBlank
    private LocalDateTime startedAt;

    @NotBlank
    private LocalDateTime endedAt;

    @NotBlank
    private Date updateDate;

    @ManyToOne
    @NotBlank
    private Tasks task;

    @ManyToOne
    @NotBlank
    private Employees updatedBy;

    @ManyToOne
    @NotBlank
    private Projects project;

    public TaskUpdate(Long updateID, String updateDescription, String status, LocalDateTime startedAt, LocalDateTime endedAt, java.sql.Date updateDate, Tasks task, Employees updatedBy, Projects project) {
        this.updateID = updateID;
        this.updateDescription = updateDescription;
        this.status = status;
        this.startedAt = startedAt;
        this.endedAt = endedAt;
        this.updateDate = updateDate;
        this.task = task;
        this.updatedBy = updatedBy;
        this.project = project;
    }

    public Long getUpdateID() {
        return updateID;
    }

    public void setUpdateID(Long updateID) {
        this.updateID = updateID;
    }

    public String getUpdateDescription() {
        return updateDescription;
    }

    public void setUpdateDescription(String updateDescription) {
        this.updateDescription = updateDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public LocalDateTime getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(LocalDateTime endedAt) {
        this.endedAt = endedAt;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Tasks getTask() {
        return task;
    }

    public void setTask(Tasks task) {
        this.task = task;
    }

    public Employees getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Employees updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Projects getProject() {
        return project;
    }

    public void setProject(Projects project) {
        this.project = project;
    }
}