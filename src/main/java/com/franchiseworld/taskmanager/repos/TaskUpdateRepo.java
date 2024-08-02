package com.franchiseworld.taskmanager.repos;

import com.franchiseworld.taskmanager.model.TaskUpdate;
import com.franchiseworld.taskmanager.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskUpdateRepo  extends JpaRepository<TaskUpdate, Long> {

    List<TaskUpdate> findByTask(Tasks task);
}
