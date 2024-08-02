package com.franchiseworld.taskmanager.controller;

import com.franchiseworld.taskmanager.model.Employees;
import com.franchiseworld.taskmanager.model.Projects;
import com.franchiseworld.taskmanager.model.Tasks;
import com.franchiseworld.taskmanager.service.EmployeeService;
import com.franchiseworld.taskmanager.service.HRService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/hr")
public class HRController {

	@Autowired
	private HRService hrService;

	@GetMapping("/getallemployees")
	public ResponseEntity<List<Employees>> getAllEmployees() {
		List<Employees> employees = hrService.getAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employees> getEmployeeById(@PathVariable int id) {
		Employees employee = hrService.getEmployeeById(id);
		if (employee != null) {
			return ResponseEntity.ok(employee);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employees> updateEmployee(@PathVariable int id, @RequestBody Employees employeeDetails) {
		Employees updatedEmployee = hrService.updateEmployee(id, employeeDetails);
		return updatedEmployee != null ? ResponseEntity.ok(updatedEmployee) : ResponseEntity.notFound().build();
	}

	@GetMapping("/projects/{projectId}")
	public ResponseEntity<Projects> getProjectById(@PathVariable int projectId) {
		Projects project = hrService.getProjectById(projectId);
		return new ResponseEntity<>(project, HttpStatus.OK);
	}

	@PatchMapping("/employees/{id}/redflag")
	public ResponseEntity<Void> redFlagEmployee(@PathVariable int id) {
		hrService.redFlagEmployee(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/tasks/{taskId}")
	public ResponseEntity<Tasks> getTaskById(@PathVariable int taskId) {
		Tasks tasks = hrService.getTaskById(taskId);
		return new ResponseEntity<>(tasks, HttpStatus.OK);
	}

	@GetMapping("/employee/{employeeID}")
	public ResponseEntity<List<Object[]>> getTasksByEmployeeId(@PathVariable int employeeID) {
		List<Object[]> tasks = hrService.getTasksByEmployeeId(employeeID);
		return ResponseEntity.ok(tasks);
	}

//	@PatchMapping("/employee/{employeeID")
//	public ResponseEntity<Employees> patchSalary(@PathVariable int employeeID,String salary) {
//		Employees employees = hrService.updateSalary(employeeID,salary);
//		return employees != null ? ResponseEntity.ok(employees) : ResponseEntity.notFound().build();
//	}

//    @PatchMapping("/employees/{id}")
//    public ResponseEntity<Employees> patchEmployee(@PathVariable int id, @RequestBody Employees employeeDetails) {
//        Employees updatedEmployee = hrService.updateEmployee(id, employeeDetails);
//        return updatedEmployee != null ? ResponseEntity.ok(updatedEmployee) : ResponseEntity.notFound().build();
//    }

	@GetMapping("/employee/monthlylogins")
	public List<Object[]> getMonthlyEmployeeLogins(@RequestParam("month") int month,
			@RequestParam("employeeId") Integer employeeId) {
		return hrService.getMonthlyEmployeeLogins(month, employeeId);
	}

	@GetMapping("/employee/monthlylogouts")
	public List<Object[]> getMonthlyEmployeeLogouts(@RequestParam("month") int month,
			@RequestParam("employeeId") Integer employeeId) {
		return hrService.getMonthlyEmployeeLogouts(month, employeeId);
	}

	@GetMapping("/employee/employeelogins")
	public List<Object[]> getEmployeeLoginsBetweenDatesAndEmployeeId(
			@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
			@RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
			@RequestParam("employeeId") Integer employeeId) {
		return hrService.getEmployeeLoginsBetweenDatesAndEmployeeId(startDate, endDate, employeeId);
	}

	@GetMapping("/employee/employeelogouts")
	public List<Object[]> getEmployeeLogoutsBetweenDatesAndEmployeeId(
			@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
			@RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
			@RequestParam("employeeId") Integer employeeId) {
		return hrService.getEmployeeLogoutsBetweenDatesAndEmployeeId(startDate, endDate, employeeId);
	}

	@GetMapping("/employee/weeklylogins")
	public List<Object[]> getWeeklyEmployeeLogins(
			@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
			@RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
			@RequestParam("employeeId") Integer employeeId) {
		return hrService.getWeeklyEmployeeLogins(startDate, endDate, employeeId);
	}

	@GetMapping("/employee/weeklylogouts")
	public List<Object[]> getWeeklyEmployeeLogouts(
			@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
			@RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
			@RequestParam("employeeId") Integer employeeId) {
		return hrService.getWeeklyEmployeeLogouts(startDate, endDate, employeeId);
	}

}