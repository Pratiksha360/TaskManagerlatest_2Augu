package com.franchiseworld.taskmanager.serviceImpl;

import com.franchiseworld.taskmanager.model.Assignment;
import com.franchiseworld.taskmanager.repos.AssignmentRepo;
import com.franchiseworld.taskmanager.service.AdminAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminAssignmentServiceImpl implements AdminAssignmentService {


    @Autowired
    private AssignmentRepo assignmentRepo;



    @Override
    public Assignment ReviewTaskAssigment(Assignment assignment, int id) {
       return this.assignmentRepo.findById(id).map(
                assignment1 -> {
                    assignment.setAssignflag(false);
                    this.assignmentRepo.save(assignment);
                    return  assignment1;
                }
        ).orElseThrow(
                () -> new RuntimeException("Assignment Not Found !!!")
        );
    }

    @Override
    public Assignment saveAssignment(Assignment assignment) {
        assignment.setAssignflag(false);
        return this.assignmentRepo.save(assignment);

    }

    @Override
    public void approveAssignment(int id) {

        this.assignmentRepo.findById(id).map(
                assignment -> {
                    assignment.setAssignflag(true);
                    return assignment;
                }
        ).orElseThrow(() -> new RuntimeException("Assignment Not Found !!!"));

    }

    @Override
    public Assignment getAssgnment(int id) {
        return this.assignmentRepo.findById(id).orElseThrow(() -> new RuntimeException("Assignment Not Found !!!"));
    }

    @Override
    public List<Assignment> getAllAssignments() {
        return this.assignmentRepo.findAll();
    }
}
