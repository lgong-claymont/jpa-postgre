package com.wuyang.postgre.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wuyang.postgre.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{
	List<Employee> findByFirstName(String FirstName);
	List<Employee> findAll();
}
