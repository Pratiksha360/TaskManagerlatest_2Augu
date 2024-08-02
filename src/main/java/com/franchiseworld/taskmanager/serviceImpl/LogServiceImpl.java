package com.franchiseworld.taskmanager.serviceImpl;

import com.franchiseworld.taskmanager.model.Employees;
import com.franchiseworld.taskmanager.model.Log;
import com.franchiseworld.taskmanager.modeldto.LogModel;
import com.franchiseworld.taskmanager.repos.EmployeesRepo;
import com.franchiseworld.taskmanager.repos.LogRepository;
import com.franchiseworld.taskmanager.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class LogServiceImpl implements LogService {
    @Autowired
    private LogRepository logRepository;

    @Autowired
    EmployeesRepo employeeRepository;
    @Override
    public List<Log> getAllLogs() {
        return logRepository.findAll();
    }

    @Override
    public Log getLogById(Long logId) {
        return logRepository.findById(logId)
                .orElseThrow(() -> new RuntimeException("Log not found"));
    }

    @Override
    public Log createLog(LogModel logModel) {
        Long employeeId = logModel.getEmployeeID();
        Employees employee = employeeRepository.findById(Integer.parseInt(employeeId.toString()))
                .orElseThrow(() -> new IllegalArgumentException("Employee not found with id: " + employeeId));

        Log log = new Log();
        log.setEmployee(employee);
        log.setLogDate(logModel.getLogDate());
        log.setLogInTime(logModel.getLogInTime());
        log.setLogOutTime(logModel.getLogOutTime());

        return logRepository.save(log);

    }

    @Override
    public Log updateLog(Long logId, LogModel updatedLog) {
        Log existingLog = logRepository.findById(logId)
                .orElseThrow(() -> new RuntimeException("Log not found"));


        Long employeeId = updatedLog.getEmployeeID();
        Employees employee = employeeRepository.findById(Integer.parseInt(employeeId.toString()))
                .orElseThrow(() -> new IllegalArgumentException("Employee not found with id: " + employeeId));

        existingLog.setEmployee(employee);
        existingLog.setLogDate(updatedLog.getLogDate());
        existingLog.setLogInTime(updatedLog.getLogInTime());
//        existingLog.setLogOutTime(updatedLog.getLogOutTime());
            existingLog.setLogOutTime(LocalDateTime.now());
        return logRepository.save(existingLog);
    }

    @Override
    public void deleteLog(Long logId) {
        logRepository.deleteById(logId);
    }
}
