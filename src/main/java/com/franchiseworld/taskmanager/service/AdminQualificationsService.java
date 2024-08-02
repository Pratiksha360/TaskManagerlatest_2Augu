package com.franchiseworld.taskmanager.service;

import com.franchiseworld.taskmanager.model.Qualifications;
import com.franchiseworld.taskmanager.model.Salary;

import java.util.List;

public interface AdminQualificationsService {


    public Qualifications saveQualifications(Qualifications qualifications,int empid);

    public Qualifications updateQualifications(Qualifications qualifications,int empid);

    public Qualifications getQualifications(int id);

    public List<Qualifications> getAllQualifications();

    public void deleteQualifications(int id);

}
