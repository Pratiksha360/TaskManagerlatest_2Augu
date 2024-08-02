package com.franchiseworld.taskmanager.repos;

import com.franchiseworld.taskmanager.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepo extends JpaRepository<Assignment,Integer> {
}
