package org.jsp.controller;

import java.util.List;

import org.jsp.dto.Employee;
import org.jsp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/getEmployeeById/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee employee = employeeService.getEmployeeById(id);
		return ResponseEntity.ok(employee);
	}

	@PostMapping("/createEmployee")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		Employee createdEmployee = employeeService.createEmployee(employee);
		return ResponseEntity.ok(createdEmployee);
	}

	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
		Employee employee = employeeService.updateEmployee(id, updatedEmployee);
		return ResponseEntity.ok(employee);
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
		return ResponseEntity.noContent().build();
	}
}
