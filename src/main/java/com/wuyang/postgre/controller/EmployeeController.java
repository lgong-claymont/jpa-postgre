package com.wuyang.postgre.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.wuyang.postgre.entity.Employee;
import com.wuyang.postgre.service.EmployeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/")
public class EmployeeController {
		
		@Autowired
		EmployeeService employeeService;
		
		@RequestMapping("bulkcreate")
		public String bulkcreate(){
			return employeeService.bulkcreate();
		}
		
		@RequestMapping("totalEmployees")
		public Long getTotalEmployees() {
			return Long.valueOf(employeeService.showEmpolyees().size());
		}		
		
		@RequestMapping("showEmployees")
		public List<Employee> showEmpolyees(Model model) {
			return employeeService.showEmpolyees();
		}
		
		@RequestMapping("showEmployeeById")
		public String showEmpolyeesById() {
			Long id = Long.valueOf(20);
			return "Last Name for Employee Id (20) : " + employeeService.showEmpolyeesById(id).getLastName();
		}
		
		@RequestMapping("search/{id}")
		public String search(@PathVariable int id){
			Employee employee = employeeService.showEmpolyeesById(Long.valueOf(id)); 
			String employeeName = "Employee (Id: " + id + ") : " 
					+ employee.getFirstName() + " "
					+ employee.getLastName();
			return employeeName;
		}
}