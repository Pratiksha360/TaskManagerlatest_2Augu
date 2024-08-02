package com.franchiseworld.taskmanager.controller;

import com.franchiseworld.taskmanager.model.Log;
import com.franchiseworld.taskmanager.modeldto.LogModel;
import com.franchiseworld.taskmanager.service.LogService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogController {
    @Autowired
    private LogService logService;

    @PostMapping("/createlog")
    @ResponseStatus(HttpStatus.CREATED)
    public Log createLog(@Valid @RequestBody LogModel log) {
        return logService.createLog(log);
    }

    @GetMapping("/getalllogs")
    public List<Log> getAllLogs() {
        return logService.getAllLogs();
    }

    @GetMapping("getlogbyid/{Id}")
    public Log getLogById(@PathVariable Long Id) {
    	
        return logService.getLogById(Id);
    }

// change logid to employeeid
    @PutMapping("/updatelog/{logId}")
    public Log updateLog(@PathVariable("logId") Long logId, @Valid @RequestBody LogModel log) {
        return logService.updateLog(logId, log);
    }

    @DeleteMapping("/deletelog")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLog(@PathVariable Long logId) {
        logService.deleteLog(logId);
    }


}
