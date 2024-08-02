package com.franchiseworld.taskmanager.repos;

import com.franchiseworld.taskmanager.model.Employees;
import com.franchiseworld.taskmanager.model.Projects;
import com.franchiseworld.taskmanager.model.Tasks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;        

public interface HRRepository extends JpaRepository<Employees, Integer> {

	@Query(value = "SELECT e.userName, l.logDate, l.logInTime "
			+ "FROM employees e JOIN logs l ON e.employeeID = l.employeeID "
			+ "WHERE l.logDate BETWEEN :startDate AND :endDate " + "AND e.employeeID = :employeeId", nativeQuery = true)
	List<Object[]> findWeeklyEmployeeLogins(@Param("startDate") LocalDate startDate,
			@Param("endDate") LocalDate endDate, @Param("employeeId") Integer employeeId);

	@Query(value = "SELECT e.userName, l.logDate, l.logOutTime "
			+ "FROM employees e JOIN logs l ON e.employeeID = l.employeeID "
			+ "WHERE l.logDate BETWEEN :startDate AND :endDate " + "AND e.employeeID = :employeeId", nativeQuery = true)
	List<Object[]> findWeeklyEmployeeLogouts(@Param("startDate") LocalDate startDate,
			@Param("endDate") LocalDate endDate, @Param("employeeId") Integer employeeId);

	@Query(value = "SELECT e.userName, l.logDate, l.logInTime "
			+ "FROM employees e JOIN logs l ON e.employeeID = l.employeeID "
			+ "WHERE MONTH(l.logDate) = :month AND e.employeeID = :employeeId", nativeQuery = true)
	List<Object[]> findMonthlyEmployeeLogins(@Param("month") int month, @Param("employeeId") Integer employeeId);

	@Query(value = "SELECT e.userName, l.logDate, l.logOutTime "
			+ "FROM employees e JOIN logs l ON e.employeeID = l.employeeID "
			+ "WHERE MONTH(l.logDate) = :month AND e.employeeID = :employeeId", nativeQuery = true)
	List<Object[]> findMonthlyEmployeeLogouts(@Param("month") int month, @Param("employeeId") Integer employeeId);

	@Query(value = "SELECT e.userName, l.logDate, l.logInTime FROM employees e JOIN logs l ON e.employeeID = l.employeeID WHERE l.logDate BETWEEN :startDate AND :endDate AND e.employeeID = :employeeId", nativeQuery = true)
	List<Object[]> findEmployeeLoginsBetweenDatesAndEmployeeId(@Param("startDate") LocalDate startDate,
			@Param("endDate") LocalDate endDate, @Param("employeeId") Integer employeeId);

	@Query(value = "SELECT e.userName, l.logDate, l.logOutTime FROM employees e JOIN logs l ON e.employeeID = l.employeeID WHERE l.logDate BETWEEN :startDate AND :endDate AND e.employeeID = :employeeId", nativeQuery = true)
	List<Object[]> findEmployeeLogoutsBetweenDatesAndEmployeeId(@Param("startDate") LocalDate startDate,
			@Param("endDate") LocalDate endDate, @Param("employeeId") Integer employeeId);



	List<Object[]> findByemployeeID(int employeeID);  
	 
	

}
