package com.wuyang.postgre.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wuyang.postgre.entity.Employee;
import com.wuyang.postgre.repository.EmployeeRepository;

@RestController
public class StreamsPostgresController {
	@Autowired
	EmployeeRepository employeeRepository;
	
	@GetMapping("/streams")
	public String postgresDemoStart () {
		return "Streams Postgres demo start...";
	}
	
	@GetMapping("/streams-creation")
	public String createStreamsFromCollections () {
		//creation A
		List<Employee> listOfEmployee = Arrays.asList(new Employee("Salim", "Khan")
			                       , new Employee("Rajesh", "Parihar")
			                       , new Employee("Rahul", "Dravid")
			                       , new Employee("Dharmendra", "Bhojwani")); 
		System.out.println("Stream creation A : " + listOfEmployee.stream().collect(Collectors.toList()));
		
		Stream.Builder<Employee> empStreamBuilder = Stream.builder();

		empStreamBuilder.accept(new Employee("Salim", "Khan"));
		empStreamBuilder.accept(new Employee("Rajesh", "Parihar"));
		empStreamBuilder.accept(new Employee("Dharmendra", "Bhojwani"));

		Stream<Employee> empStream = empStreamBuilder.build();
		System.out.println("Stream creation B : " + empStream.collect(Collectors.toList()));
		
		return "Stream creation C : + " + Stream.of(listOfEmployee).collect(Collectors.toList());
	}
	
	@GetMapping("/streams-operation")
	public String streamsOperation () {
		List<Employee> listOfEmployee = Arrays.asList(new Employee("Salim", "Khan")
                , new Employee("Rajesh", "Parihar")
                , new Employee("Rahul", "Dravid")
                , new Employee("Dharmendra", "Bhojwani"));
		// forEach()
		Stream.of(listOfEmployee).forEach(e -> {
			System.out.println(e.get(0).getLastName());
			System.out.println(e.get(1).getLastName());
			System.out.println(e.get(2).getLastName());
			System.out.println(e.get(3).getLastName());
		});
		
		// map
		Integer[] empIds = { 1, 2, 3 };
	    /*
	    List<Employee> employees = Stream.of(empIds)
	      .map(employeeRepository::findById)
	      .collect(Collectors.toList());
	    */
		return "Stream operations demo ...";
		
	}
}
