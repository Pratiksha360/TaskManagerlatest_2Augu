package com.franchiseworld.taskmanager.service;



import com.franchiseworld.taskmanager.model.Log;
import com.franchiseworld.taskmanager.modeldto.LogModel;

import java.util.List;

public interface LogService {
    List<Log> getAllLogs();
    Log getLogById(Long logId);
    Log createLog(LogModel log);
    Log updateLog(Long logId, LogModel log);
    void deleteLog(Long logId);
}
