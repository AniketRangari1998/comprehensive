package com.example.comprehensive;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Employee {

	@Id
	private int id;

	@NotNull(message = "username should'nt be null")
	private String name;

	@NotNull
	private String designation;

	@Email(message = "invalid email address")
	private String email;

	@NotNull
	private int salary;


	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDesignation() {
		return designation;
	}



	public void setDesignation(String designation) {
		this.designation = designation;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public int getSalary() {
		return salary;
	}



	public void setSalary(int salary) {
		this.salary = salary;
	}

	

	public Employee(int id, @NotNull(message = "username should'nt be null") String name, @NotNull String designation,
			@Email(message = "invalid email address") String email, @NotNull int salary) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.email = email;
		this.salary = salary;
	}
	
	


	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int compare(Employee o1 , Employee o2) {
		return (int) (o2.getSalary()-o1.getSalary());
	}
		

}
