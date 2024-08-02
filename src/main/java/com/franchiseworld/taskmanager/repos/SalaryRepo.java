package com.franchiseworld.taskmanager.repos;

import com.franchiseworld.taskmanager.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepo extends JpaRepository<Salary,Integer> {
}
