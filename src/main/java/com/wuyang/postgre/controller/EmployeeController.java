package com.wuyang.postgre.controller;

import org.springframework.web.bind.annotation.RestController;

import com.wuyang.postgre.entity.Employee;
import com.wuyang.postgre.repository.EmployeeRepository;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/")
public class EmployeeController {
	
		@Autowired
		private EmployeeRepository employeeRepository;
		
		@RequestMapping("bulkcreate")
		public String bulkcreate(){
		// save a single User
			employeeRepository.save(new Employee("Rajesh", "Bhojwani"));
			// save a list of Customers
			employeeRepository.saveAll(Arrays.asList(new Employee("Salim", "Khan")
			                       , new Employee("Rajesh", "Parihar")
			                       , new Employee("Rahul", "Dravid")
			                       , new Employee("Dharmendra", "Bhojwani")));
			return "Employees are created";
		}
		
		@RequestMapping("/search/{id}")
		public String search(@PathVariable long id){
		String employee = "";
		employee = employeeRepository.findById(id).toString();
		return employee;
		}
		
		@PostMapping("/create")
		public String create(@RequestBody Employee employee){
		// save a single Employee
			employeeRepository.save(new Employee(employee.getFirstName(), employee.getLastName()));
		return "Customer is created";
		}
}