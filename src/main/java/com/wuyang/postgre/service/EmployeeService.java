package com.wuyang.postgre.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.wuyang.postgre.entity.Employee;
import com.wuyang.postgre.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public String bulkcreate() {
		// save a single User
		((EmployeeRepository)employeeRepository).save(new Employee("Rajesh", "Bhojwani"));
		// save a list of Customers
		employeeRepository.saveAll(Arrays.asList(new Employee("Salim", "Khan")
		                       , new Employee("Rajesh", "Parihar")
		                       , new Employee("Rahul", "Dravid")
		                       , new Employee("Dharmendra", "Bhojwani")));
		return "Employees are created";
	}
	
	public List<Employee> showEmpolyees() {
		
		List<Employee> employees = (List<Employee>) employeeRepository.findAll();

		System.out.println("# of employees found: " + employees.size());

		return employees;
	}
	
	public Employee showEmpolyeesById(Long id) {
		return employeeRepository.findById(id).get();
	}

	
	/*	
	@PostMapping("create")
	public String create(@RequestBody Employee employee){
	// save a single Employee
		employeeRepository.save(new Employee(employee.getFirstName(), employee.getLastName()));
	return "Customer is created";
	}
	*/
}
