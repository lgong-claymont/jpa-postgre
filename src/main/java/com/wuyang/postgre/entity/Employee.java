package com.wuyang.postgre.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {
	private static final long serialVersionUID = -2343243243242432341L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "firstname")
	private String firstName;	
	@Column(name = "lastname")
	private String lastName;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Employee(String first_name, String last_name) {
		this.firstName = first_name;
		this.lastName = last_name;
	}
}
