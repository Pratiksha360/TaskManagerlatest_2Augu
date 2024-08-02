package com.franchiseworld.taskmanager.serviceImpl;

import com.franchiseworld.taskmanager.model.Employees;
import com.franchiseworld.taskmanager.model.Qualifications;
import com.franchiseworld.taskmanager.repos.EmployeesRepo;
import com.franchiseworld.taskmanager.repos.QualificationsRepo;
import com.franchiseworld.taskmanager.service.AdminEmployeeService;
import com.franchiseworld.taskmanager.service.AdminQualificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminQualificationServiceImpl implements AdminQualificationsService {


    @Autowired
    private QualificationsRepo qualificationsRepo;

    @Autowired
    private AdminEmployeeService employeeService;

    @Autowired
    private EmployeesRepo employeesRepos;


    @Override
    public Qualifications saveQualifications(Qualifications qualifications,int empid) {

        Employees employeeById = this.employeeService.getEmployee(empid);
        qualifications.setEmployees(employeeById);

        return  this.qualificationsRepo.save(qualifications);
    }

    @Override
    public Qualifications updateQualifications(Qualifications qualifications,int qid) {

        return   this.qualificationsRepo.findById(qid).map(
               qualifications1 -> {qualifications.setQualificationID(qualifications1.getQualificationID());
               return this.qualificationsRepo.save(qualifications);
               }
       ).orElseThrow(() -> new RuntimeException("Qualifications Not Found"));

    }

    @Override
    public Qualifications getQualifications(int id) {
        return this.qualificationsRepo.findById(id).orElseThrow(() -> new RuntimeException("Qualifications Not Found !!"));
    }

    @Override
    public List<Qualifications> getAllQualifications() {
        return this.qualificationsRepo.findAll();
    }

    @Override
    public void deleteQualifications(int id) {
        this.qualificationsRepo.findById(id).map(
                q -> {


                    this.qualificationsRepo.deleteById(q.getQualificationID());
                    return q;
                }
        ).orElseThrow(() -> new RuntimeException("ID Not Found !!!"));
    }
    }

