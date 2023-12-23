package org.jsp.controller;

import java.util.List;

import org.jsp.dto.SalaryCalculation;
import org.jsp.service.SalaryCalculationService;
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
public class SalaryCalculationController {

	@Autowired
	private SalaryCalculationService salaryCalculationService;

	@GetMapping("/getAllSalaryCalculations")
	public List<SalaryCalculation> getAllSalaryCalculations() {
		return salaryCalculationService.getAllSalaryCalculations();
	}

	@GetMapping("/getSalaryCalculationById/{id}")
	public ResponseEntity<SalaryCalculation> getSalaryCalculationById(@PathVariable Long id) {
		SalaryCalculation salaryCalculation = salaryCalculationService.getSalaryCalculationById(id);
		return ResponseEntity.ok(salaryCalculation);
	}

	@PostMapping("/createSalaryCalculation")
	public ResponseEntity<SalaryCalculation> createSalaryCalculation(@RequestBody SalaryCalculation salaryCalculation) {
		SalaryCalculation createdSalaryCalculation = salaryCalculationService
				.createSalaryCalculation(salaryCalculation);
		return ResponseEntity.ok(createdSalaryCalculation);
	}

	@PutMapping("/updateSalaryCalculation/{id}")
	public ResponseEntity<SalaryCalculation> updateSalaryCalculation(@PathVariable Long id,
			@RequestBody SalaryCalculation updatedSalaryCalculation) {
		SalaryCalculation salaryCalculation = salaryCalculationService.updateSalaryCalculation(id,
				updatedSalaryCalculation);
		return ResponseEntity.ok(salaryCalculation);
	}

	@DeleteMapping("/deleteSalaryCalculation/{id}")
	public ResponseEntity<Void> deleteSalaryCalculation(@PathVariable Long id) {
		salaryCalculationService.deleteSalaryCalculation(id);
		return ResponseEntity.noContent().build();
	}
}
