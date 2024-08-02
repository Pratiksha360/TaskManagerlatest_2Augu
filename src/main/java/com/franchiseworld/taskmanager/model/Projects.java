package com.franchiseworld.taskmanager.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Projects {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ProjectID")
	private int projectId;

	@Column(name = "ProjectName")
	@NotBlank
	private String projectName;

	@Column(name = "Description")
	@NotBlank
	private String description;

	@Column(name = "StartDate")
	@NotNull
	private LocalDateTime startDate;

	@Column(name = "EndDate")
	@NotNull
	private LocalDateTime endDate;

	@Column(name = "Status")
	@NotBlank
	@Pattern(regexp = "Active|InActive|Pending|In Progress|Completed", message = "Status must be one of the following: Active , InActive , Pending, In Progress, Completed")
	private String status;

	@Column(name = "CreatedAt")
	@NotNull(message = "createdAt ")
	private LocalDateTime createdAt;

	@Column(name = "UpdatedAt")
	@NotNull(message = "UpdateAt Field Value Blank")
	private LocalDateTime updatedAt;

	private boolean flag;

	private boolean projectblock;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "projects")
	@JsonManagedReference(value = "tasks-projects")
	private List<Tasks> tasks;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "project_head_key")
	private Employees emp;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "projectID")
	@JsonManagedReference(value = "projects-assignment")
	private List<Assignment> assignments;

	public Projects() {
	}

	public Projects(int projectId, String projectName, String description, LocalDateTime startDate,
			LocalDateTime endDate, String status, LocalDateTime createdAt, LocalDateTime updatedAt, boolean flag,
			boolean projectblock, List<Tasks> tasks, Employees emp, List<Assignment> assignments) {
		this.projectId = projectId;
		this.projectName = projectName;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.flag = flag;
		this.projectblock = projectblock;
		this.tasks = tasks;
		this.emp = emp;
		this.assignments = assignments;
	}

	// Getters and Setters

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Tasks> getTasks() {
		return tasks;
	}

	public void setTasks(List<Tasks> tasks) {
		this.tasks = tasks;
	}

	public Employees getEmp() {
		return emp;
	}

	public void setEmp(Employees emp) {
		this.emp = emp;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public boolean isProjectblock() {
		return projectblock;
	}

	public void setProjectblock(boolean projectblock) {
		this.projectblock = projectblock;
	}

	public List<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<Assignment> assignments) {
		this.assignments = assignments;
	}
}
