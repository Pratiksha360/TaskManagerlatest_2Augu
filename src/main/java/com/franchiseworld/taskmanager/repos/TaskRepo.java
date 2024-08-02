package com.franchiseworld.taskmanager.repos;

import com.franchiseworld.taskmanager.model.Employees;
import com.franchiseworld.taskmanager.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TaskRepo extends JpaRepository<Tasks, Integer> {

	@Query(value = "SELECT e.* FROM tasks t " + "INNER JOIN employees e ON t.employee_id = e.EmployeeID "
			+ "WHERE t.TaskID = :taskId", nativeQuery = true)
	Employees findAssignedEmployeeByTaskId(@Param("taskId") int taskId);

}
