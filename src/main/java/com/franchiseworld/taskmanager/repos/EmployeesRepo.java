package com.franchiseworld.taskmanager.repos;

import com.franchiseworld.taskmanager.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeesRepo extends JpaRepository<Employees,Integer> {


    @Query("SELECT e FROM employees e WHERE e.email = :usernameOrEmail OR e.userName = :usernameOrEmail AND e.password = :password")
    public  Optional<Employees> findEmployeesByUsernameOrEmail(@Param("usernameOrEmail") String usernameOrEmail,@Param("password") String password);
    public Employees findByEmailOrUserName(String email,String username);
}
