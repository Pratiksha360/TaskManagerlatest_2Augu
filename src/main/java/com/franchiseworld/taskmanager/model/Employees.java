package com.franchiseworld.taskmanager.model;     

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "employees")
@Table(name = "employees")
public class Employees {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EmployeeID")
	private int employeeID;

	@Column(name = "FirstName", nullable = false)
	@NotBlank(message = "First name is required")
	private String firstName;

	@Column(name = "MiddleName", nullable = false)
	@NotBlank(message = "Middle name is required")
	private String middleName;

	@Column(name = "LastName", nullable = false)
	@NotBlank(message = "Last name is required")
	private String lastName;

	@Column(name = "Email", unique = true, nullable = false)
	@NotBlank(message = "Email is required")
	@Email(regexp = "^[a-zA-Z0-9._%+-]+@gmail\\.com$", message = "Email should be a valid gmail address")
	private String email;

	@Column(name = "UserName", unique = true, nullable = false)
	@NotBlank(message = "Username is required")
	private String userName;

	@Column(name = "Password", nullable = false)
	@NotBlank(message = "Password is required")
	@Size(min = 5, message = "Password must be at least 5 characters long" , max = 40)
	private String password;

	@Column(name = "Position", nullable = false)
	@NotBlank(message = "Position is Required")
	@Pattern(regexp = "^(Admin|HR|Project Head|Developer|Employee)$", message = "Gender must be either 'Admin', 'HR', 'Employee' , 'Project Head', or 'Developer'")
	private String position;

	@Column(name = "ProfilePicture", nullable = false)
	@NotBlank(message = "profle picture is required")
	private String profilePicture;

	@Column(name = "Contact_No", unique = true, nullable = false)
	@NotBlank
	@Size(min = 10)
	private String contactNo;

	@Column(name = "Address", nullable = false)
	@NotBlank
	@Size(max = 210)
	private String address;

	@Column(name = "Gender", nullable = false)
	@NotBlank
	@Pattern(regexp = "^(male|female|other)$", message = "Gender must be either 'male', 'female', or 'other'")
	private String gender;

	@Column(name = "BirthDate")
	@NotNull
	private LocalDateTime birthDate;

	@Column(name = "CreatedAt", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@NotNull
	private LocalDateTime createdAt;

	@Column(name = "UpdatedAt", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	@NotNull
	private LocalDateTime updatedAt;

	private boolean flag;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "employees")
	@JsonManagedReference(value = "employees-tasks")
	private List<Tasks> tasks;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "employeeID")
	@JsonManagedReference(value = "employess-assignment")
	private List<Assignment> assignments;

	@OneToOne(mappedBy = "employees")
	@JsonManagedReference(value = "emp-salary")
	private Salary salary;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "employees", orphanRemoval = true)
	@JsonManagedReference(value = "emp-qualifications")
	private List<Qualifications> qualifications;

	// Default constructor
	public Employees() {
	}

	// Constructor with all fields

	public Employees(int employeeID, String firstName, String middleName, String lastName, String email,
			String userName, String password, String position, String profilePicture, String contactNo, String address,
			String gender, LocalDateTime birthDate, LocalDateTime createdAt, LocalDateTime updatedAt, boolean flag,
			List<Tasks> tasks, List<Assignment> assignments, Salary salary, List<Qualifications> qualifications) {
		this.employeeID = employeeID;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.position = position;
		this.profilePicture = profilePicture;
		this.contactNo = contactNo;
		this.address = address;
		this.gender = gender;
		this.birthDate = birthDate;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.flag = flag;
		this.tasks = tasks;
		this.assignments = assignments;
		this.salary = salary;
		this.qualifications = qualifications;
	}

	// Getters and Setters
	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDateTime getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDateTime birthDate) {
		this.birthDate = birthDate;
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

	public boolean getFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public List<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<Assignment> assignments) {
		this.assignments = assignments;
	}

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	public List<Qualifications> getQualifications() {
		return qualifications;
	}

	public void setQualifications(List<Qualifications> qualifications) {
		this.qualifications = qualifications;
	}
}
