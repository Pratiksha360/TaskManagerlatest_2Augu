package com.franchiseworld.taskmanager.service;

import com.franchiseworld.taskmanager.model.Employees;
import com.franchiseworld.taskmanager.modeldto.EmploeeFormDto;



public interface AdminEmployeeFormService {


    public Employees getEmployee(EmploeeFormDto user);
}
