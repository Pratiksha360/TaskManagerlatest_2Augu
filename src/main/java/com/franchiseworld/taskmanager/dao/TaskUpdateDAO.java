package com.franchiseworld.taskmanager.dao;

import com.franchiseworld.taskmanager.model.TaskUpdate;
import com.franchiseworld.taskmanager.repos.TaskUpdateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TaskUpdateDAO {

    @Autowired
    private TaskUpdateRepo updateRepository;

    public TaskUpdate saveTaskUpdate(TaskUpdate task) {
        return updateRepository.save(task);

    }

    public TaskUpdate findTaskUpdateId(Long id) {

//		to avoid no suchelementException
        Optional<TaskUpdate> optional = updateRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();

        } else {
            return null;

        }
    }

    public List<TaskUpdate> findAllTaskUpdate() {
        return updateRepository.findAll();
    }

    public TaskUpdate deleteTaskUpdate(TaskUpdate task) {

        updateRepository.delete(task);
        return task;

    }

}