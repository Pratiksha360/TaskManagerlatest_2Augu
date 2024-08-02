package com.franchiseworld.taskmanager.service;

import com.franchiseworld.taskmanager.model.Assignment;

import java.util.List;

public interface AdminAssignmentService {



    public Assignment ReviewTaskAssigment(Assignment assignment,int id);

    public Assignment  saveAssignment(Assignment assignment);

    public void approveAssignment(int id);

    public Assignment getAssgnment(int id);

    public List<Assignment> getAllAssignments();


}
