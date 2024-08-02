package com.franchiseworld.taskmanager.serviceImpl;

import com.franchiseworld.taskmanager.service.HRService;
import com.franchiseworld.taskmanager.model.Employees;
import com.franchiseworld.taskmanager.model.Projects;
import com.franchiseworld.taskmanager.model.Salary;
import com.franchiseworld.taskmanager.model.Tasks;
import com.franchiseworld.taskmanager.repos.EmployeesRepo;
import com.franchiseworld.taskmanager.repos.HRRepository;
import com.franchiseworld.taskmanager.repos.ProjectsRepo;
import com.franchiseworld.taskmanager.repos.TaskRepo;
import com.franchiseworld.taskmanager.service.HRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HRServiceImpl implements HRService {
	@Autowired
	private HRRepository hrRepository;

	@Autowired
	private EmployeesRepo employeeRepo;

	@Autowired
	private ProjectsRepo projectRepository;

	@Autowired
	private TaskRepo taskRepository;

	@Override
	public List<Employees> getAllEmployees() {
		return employeeRepo.findAll();
	}

	@Override
	public Employees updateEmployee(int id, Employees employeeDetails) {
		return hrRepository.findById(id).map(employee -> {
			employee.setFirstName(employeeDetails.getFirstName());
			employee.setMiddleName(employeeDetails.getMiddleName());
			employee.setLastName(employeeDetails.getLastName());
			employee.setEmail(employeeDetails.getEmail());
			employee.setUserName(employeeDetails.getUserName());
			employee.setPassword(employeeDetails.getPassword());
			employee.setProfilePicture(employeeDetails.getProfilePicture());
			employee.setContactNo(employeeDetails.getContactNo());
			employee.setAddress(employeeDetails.getAddress());
			employee.setGender(employeeDetails.getGender());
			employee.setBirthDate(employeeDetails.getBirthDate());
			employee.setUpdatedAt(LocalDateTime.now());
			return hrRepository.save(employee);
		}).orElse(null);
	}

	@Override
	public void redFlagEmployee(int id) {
		hrRepository.findById(id).ifPresent(employee -> {
			employee.setFlag(false); // Red-flagging employee
			hrRepository.save(employee);
		});
	}

//    @Override
//    public Employees addEmployee(Employees employees) {
//        return employeeRepo.save(employees);
//    }

//    @Override
//    public Employees updateEmployee(int employeeId, Employees employees) {
//        Employees existingEmployee = employeeRepo.findById(Math.toIntExact(employeeId))
//                .orElseThrow(() -> new RuntimeException("Employee not found"));
//
//        // Update fields
//        existingEmployee.setPosition(employees.getPosition());
//        existingEmployee.setEmail(employees.getEmail());
//        existingEmployee.setContactNo(employees.getContactNo());
//
//        // Save and return updated employee
//        return employeeRepo.save(existingEmployee);
//    }

	// didi
//    @Transactional
//    public void updateEmployeeDetails(int employeeId, String position, String email, String contactNo) {
//        hrRepository.updateEmployeeDetails(employeeId, position, email, contactNo);
//    }

//    @Override
//    public List<String> getDailyEmployeeLogins(LocalDate date) {
//        List<Employees> employees= hrRepository.findDailyEmployeeLoginByDate(date);
//        return null;
//    }

	@Override
	public List<Object[]> getMonthlyEmployeeLogins(int month, Integer employeeId) {
		return hrRepository.findMonthlyEmployeeLogins(month, employeeId);
	}

	@Override
	public List<Object[]> getMonthlyEmployeeLogouts(int month, Integer employeeId) {
		return hrRepository.findMonthlyEmployeeLogouts(month, employeeId);
	}

	@Override
	public List<Object[]> getEmployeeLoginsBetweenDatesAndEmployeeId(LocalDate startDate, LocalDate endDate,
			Integer employeeId) {
		return hrRepository.findEmployeeLoginsBetweenDatesAndEmployeeId(startDate, endDate, employeeId);
	}

	@Override
	public List<Object[]> getEmployeeLogoutsBetweenDatesAndEmployeeId(LocalDate startDate, LocalDate endDate,
			Integer employeeId) {
		return hrRepository.findEmployeeLogoutsBetweenDatesAndEmployeeId(startDate, endDate, employeeId);
	}

	@Override
	public List<Object[]> getWeeklyEmployeeLogins(LocalDate startDate, LocalDate endDate, Integer employeeId) {
	    return hrRepository.findWeeklyEmployeeLogins(startDate, endDate, employeeId);
	}

	@Override
	public List<Object[]> getWeeklyEmployeeLogouts(LocalDate startDate, LocalDate endDate, Integer employeeId) {
	    return hrRepository.findWeeklyEmployeeLogouts(startDate, endDate, employeeId);
	}


//    @Override
//    public List<Object[]> getWeeklyEmployeeLoginsByDatesAndEmployeeId(LocalDate startDate, LocalDate endDate,
//                                                                      Integer employeeId) {
//        return hrRepository.findWeeklyEmployeeLogins(startDate, endDate, employeeId);
//    }
//
//    @Override
//    public List<Object[]> getWeeklyEmployeeLogoutsByDatesAndEmployeeId(LocalDate startDate, LocalDate endDate,
//                                                                       Integer employeeId) {
//        return hrRepository.findWeeklyEmployeeLogoutsByDatesAndEmployeeId(startDate, endDate, employeeId);
//    }

	@Override
	public Projects getProjectById(int projectId) {
		return projectRepository.findById(projectId).orElseThrow(() -> new RuntimeException("Project not found"));
	}

	@Override
	public Tasks getTaskById(int taskId) {
		return taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));
	}

	@Override
	public Employees getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return hrRepository.findById(id).orElseThrow(() -> new RuntimeException("id not found!!!"));
	}
	


	@Override
    public List<Object[]> getTasksByEmployeeId(int employeeID) {
        return hrRepository.findByemployeeID(employeeID);
    }
    
    public boolean updateEmployeeSalary(int employeeId, String salary) {
        // Retrieve employee from repository (assuming implementation)
        Employees employee = hrRepository.findById(employeeId).orElseThrow( );
        

        if (employee == null) {
            return false; // Employee not found
        }

        // Calculate new salary
//        String salaryUpdate = employee.getSalary();
        
        // Update employee's salary
//        employee.setSalary(salary);

        // Save updated employee back to repository (assuming implementation)
        hrRepository.save(employee);

        return true; 
    }
}


