package com.example.comprehensive;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.comprehensive.exceptionhandler.EmployeeAlreadyExist;
import com.example.comprehensive.exceptionhandler.UserNotFoundException;

@RestController
public class EmployeeController {

	@Autowired
	private Employeeservice es;

	@PostMapping("/employees")
	public ResponseEntity<Employee> saveEmployee(@RequestBody @Valid Employee e) throws EmployeeAlreadyExist {
		return new ResponseEntity<>(es.addEmployee(e),HttpStatus.CREATED);
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getById(@PathVariable int id) throws UserNotFoundException {
		return ResponseEntity.ok(es.getById(id));
	}

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		return ResponseEntity.ok(es.getAllEmployee());
	}
	
	@GetMapping("/employees/des")
	public ResponseEntity<List<Employee>> getEmployeeBydes(){
		return ResponseEntity.ok(es.getEmployeeByDesOrderOfSalary());
	}
	
	
	
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return es.deleteEmployee(id);
	}

	@PutMapping("/employees")
	public Employee editEmployee(@RequestBody @Valid Employee e) {
		return es.editEmployee(e);
	}
	
	@PutMapping("/employees/{id}/{salary}")
	public Employee edityEmployeeBySalary(@PathVariable int id,@PathVariable int salary) {
		return es.editEmployeeBySalary(id, salary);	
	}

}
