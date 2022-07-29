package com.example.comprehensive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.util.PropertySource.Comparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.comprehensive.exceptionhandler.EmployeeAlreadyExist;
import com.example.comprehensive.exceptionhandler.UserNotFoundException;

@Service
public class Employeeservice {

	private static final int List = 0;
	@Autowired
	private repo repository;

	public Employee addEmployee(Employee e) throws EmployeeAlreadyExist {
		Employee existingEmp = repository.findById(e.getId()).orElse(null);
		if (existingEmp != null) {
			throw new EmployeeAlreadyExist("Employee already exist");
		} else {
			return repository.save(e);
		}

	}

	public List<Employee> getAllEmployee() {
		return repository.findAll();
	}
	
	public List<Employee> getEmployeeInDes(){
		List<Employee> list = repository.findAll();
		return list;
	}
	
	public List<Employee> getEmployeeByDesOrderOfSalary(){
		List<Employee> s = repository.findAll();
		
		Collections.sort( s , (o1,o2) -> (o2.getSalary()==o1.getSalary()) ? ( o1.getName().compareTo(o2.getName()) )  :  (o2.getSalary()-o1.getSalary()) );
		
		return s;	
	}

	public Employee getById(int id) throws UserNotFoundException {
		Employee emp = repository.findById(id).orElse(null);
		if (emp != null) {
			return emp;
		} else {
			throw new UserNotFoundException("user not found with id ");
		}

	}
	

	public String deleteEmployee(int id) {
		repository.deleteById(id);
		return "Employee with employee id " + id + " has been deleted.";
	}

	public Employee editEmployee(Employee e) {
		Employee existingEmployee = repository.findById(e.getId()).orElse(null);
		existingEmployee.setName(e.getName());
		existingEmployee.setSalary(e.getSalary());
		return repository.save(existingEmployee);
	}
	
	public Employee editEmployeeBySalary(int id, int salary) {
		Employee emp = repository.findById(id).orElse(null);
		emp.setSalary(salary);
		return repository.save(emp);	
	}
}


