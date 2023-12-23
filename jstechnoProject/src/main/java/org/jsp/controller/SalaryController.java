package org.jsp.controller;

import java.util.List;

import org.jsp.dto.Salary;
import org.jsp.service.SalaryService;
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
public class SalaryController {

	@Autowired
	private SalaryService salaryService;

	@GetMapping("/getAllSalaries")
	public List<Salary> getAllSalaries() {
		return salaryService.getAllSalaries();
	}

	@GetMapping("/getSalaryById/{id}")
	public ResponseEntity<Salary> getSalaryById(@PathVariable Long id) {
		Salary salary = salaryService.getSalaryById(id);
		return ResponseEntity.ok(salary);
	}

	@PostMapping("/createSalary")
	public ResponseEntity<Salary> createSalary(@RequestBody Salary salary) {
		Salary createdSalary = salaryService.createSalary(salary);
		return ResponseEntity.ok(createdSalary);
	}

	@PutMapping("/updateSalary/{id}")
	public ResponseEntity<Salary> updateSalary(@PathVariable Long id, @RequestBody Salary updatedSalary) {
		Salary salary = salaryService.updateSalary(id, updatedSalary);
		return ResponseEntity.ok(salary);
	}

	@DeleteMapping("/deleteSalary/{id}")
	public ResponseEntity<Void> deleteSalary(@PathVariable Long id) {
		salaryService.deleteSalary(id);
		return ResponseEntity.noContent().build();
	}
}
