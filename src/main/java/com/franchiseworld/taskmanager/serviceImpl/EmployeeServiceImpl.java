package com.franchiseworld.taskmanager.serviceImpl;


import com.franchiseworld.taskmanager.model.Employees;
import com.franchiseworld.taskmanager.repos.EmployeesRepo;
import com.franchiseworld.taskmanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeesRepo employeeRepository;

    @Override
    public Employees saveEmployee(Employees employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employees> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employees getEmployeeById(int id) {
        Optional<Employees> optionalEmployee = employeeRepository.findById(id);
        return optionalEmployee.orElse(null);    }

    @Override
    public Employees updateEmployee(int id, Employees employeeDetails) {
        Optional<Employees> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employees employee = optionalEmployee.get();
            employee.setFirstName(employeeDetails.getFirstName());
            employee.setMiddleName(employeeDetails.getMiddleName());
            employee.setLastName(employeeDetails.getLastName());
            employee.setEmail(employeeDetails.getEmail());
            employee.setUserName(employeeDetails.getUserName());
            employee.setPassword(employeeDetails.getPassword());
            employee.setProfilePicture(employeeDetails.getProfilePicture());
            employee.setContactNo(employeeDetails.getContactNo());
            employee.setAddress(employeeDetails.getAddress());
            employee.setGender(employeeDetails.getGender());
            employee.setBirthDate(employeeDetails.getBirthDate());
            return employeeRepository.save(employee);
        }
        return null;
    }







    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }


}
