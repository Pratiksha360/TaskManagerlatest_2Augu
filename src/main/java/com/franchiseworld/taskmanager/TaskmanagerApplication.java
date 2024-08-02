 package com.franchiseworld.taskmanager;

import com.franchiseworld.taskmanager.exceptionhandler.GlobalExceptionHandler;
import com.franchiseworld.taskmanager.model.Employees;
import com.franchiseworld.taskmanager.repos.EmployeesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.List;

@SpringBootApplication
public class TaskmanagerApplication implements CommandLineRunner {


	

	public static void main(String[] args) {
		SpringApplication.run(TaskmanagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		System.out.println("App is Running...............");
	}
}
