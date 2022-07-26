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

	@Min(18)
	@Max(60)
	private int age;

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public Employee(int id, String name, int age, String email, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
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
