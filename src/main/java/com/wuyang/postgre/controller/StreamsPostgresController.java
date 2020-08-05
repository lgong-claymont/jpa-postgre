package com.wuyang.postgre.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wuyang.postgre.entity.Employee;
import com.wuyang.postgre.repository.EmployeeRepository;
import com.wuyang.postgre.service.EmployeeService;

@RestController
@RequestMapping("/streams")
public class StreamsPostgresController {
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("getEmployees") 
	public List<Employee> getEmployees() {
		return employeeService.showEmpolyees();
	}
	
	@GetMapping("/creation")
	public String createStreamsFromCollections () {
		List<Employee> listOfEmployee = employeeService.showEmpolyees();
		return "Stream creation : + " + Stream.of(listOfEmployee).collect(Collectors.toList());
	}
	
	@GetMapping("/filter")
	public String streamsMapOperation () {	 
		List<Employee> listOfEmployee = employeeService.showEmpolyees();
		String output = listOfEmployee.stream()
				.filter(e -> e.getId() == 1)
				.collect(Collectors.toList())
				.get(0)
				.getLastName();
	    
		return output;
		
	}
}
