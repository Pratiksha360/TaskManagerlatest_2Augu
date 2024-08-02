package com.franchiseworld.taskmanager.serviceImpl;

import com.franchiseworld.taskmanager.customexception.TaskNotFoundException;
import com.franchiseworld.taskmanager.dao.TaskUpdateDAO;
import com.franchiseworld.taskmanager.message.ApiSuccess;
import com.franchiseworld.taskmanager.message.ResponseStructure;
import com.franchiseworld.taskmanager.model.TaskUpdate;
import com.franchiseworld.taskmanager.repos.TaskUpdateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class TaskUpdateServiceImpl {

        @Autowired
        private TaskUpdateDAO dao;

        public ResponseEntity<ResponseStructure<TaskUpdate>> saveTaskUpdate(TaskUpdate taskUpdate) {

            ResponseStructure<TaskUpdate> structure = new ResponseStructure<TaskUpdate>();
            structure.setMessage("TaskUpdate saved successfully");
            structure.setStatus(HttpStatus.CREATED.value());

            structure.setData(dao.saveTaskUpdate(taskUpdate));

            return new ResponseEntity<ResponseStructure<TaskUpdate>>(structure, HttpStatus.CREATED);

        }

        public ResponseEntity<ResponseStructure<TaskUpdate>> findTaskUpdate(Long id) {
            TaskUpdate taskUpdate = dao.findTaskUpdateId(id);

            ResponseStructure<TaskUpdate> structure = new ResponseStructure<TaskUpdate>();
            if (taskUpdate != null) {
                structure.setMessage("TaskUpdate Found successfully");
                structure.setStatus(HttpStatus.FOUND.value());
                structure.setData(taskUpdate);

                return new ResponseEntity<ResponseStructure<TaskUpdate>>(structure, HttpStatus.FOUND);
            } else {
                throw new TaskNotFoundException("TaskUpdate Not Found With Given Id.");

            }
        }

        public ResponseEntity<ResponseStructure<List<TaskUpdate>>> findAllTaskUpdate() {
            List<TaskUpdate> list = dao.findAllTaskUpdate();
            ResponseStructure<List<TaskUpdate>> structure = new ResponseStructure<List<TaskUpdate>>();
            if (list.isEmpty()) {

                throw new TaskNotFoundException("No Data Available");

            } else {
                structure.setMessage("TaskUPdate   Found");
                structure.setStatus(HttpStatus.FOUND.value());
                structure.setData(list);
                return new ResponseEntity<ResponseStructure<List<TaskUpdate>>>(structure, HttpStatus.FOUND);
            }
        }

        public ResponseEntity<ResponseStructure<TaskUpdate>> deleteTaskUpdate(Long id) {
            ResponseStructure<TaskUpdate> structure = new ResponseStructure<TaskUpdate>();
            TaskUpdate taskUpdate = dao.findTaskUpdateId(id);
            if (taskUpdate != null) {
                dao.deleteTaskUpdate(taskUpdate);
                structure.setMessage("TaskUpdate  Deleted successfully");
                structure.setStatus(HttpStatus.OK.value());
                structure.setData(taskUpdate);

                return new ResponseEntity<ResponseStructure<TaskUpdate>>(structure, HttpStatus.OK);
            } else {
                throw new TaskNotFoundException("No TaskUpdate found with given id.");

            }

        }

        public ResponseEntity<ResponseStructure<TaskUpdate>> updateTaskUpdate(@RequestBody TaskUpdate taskUpdate, Long id) {
            ResponseStructure<TaskUpdate> structure = new ResponseStructure<TaskUpdate>();
            TaskUpdate employee2 = dao.findTaskUpdateId(id);
            if (employee2 != null) {
                taskUpdate.setUpdateID(id);

                dao.saveTaskUpdate(taskUpdate);
                structure.setMessage("TaskUpdate  Updated successfully");
                structure.setStatus(HttpStatus.OK.value());
                structure.setData(taskUpdate);
//			return structure;

                return new ResponseEntity<ResponseStructure<TaskUpdate>>(structure, HttpStatus.OK);
            } else {
                throw new TaskNotFoundException("TaskUpdate not found with given id");
            }

        }




}