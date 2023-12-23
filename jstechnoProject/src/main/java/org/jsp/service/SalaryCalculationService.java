package org.jsp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.dto.SalaryCalculation;
import org.jsp.repository.SalaryCalculationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryCalculationService {

	@Autowired
	private SalaryCalculationRepository salaryCalculationRepository;

	@Autowired
	private EmployeeService employeeService;

	public List<SalaryCalculation> getAllSalaryCalculations() {
		return salaryCalculationRepository.findAll();
	}

	public SalaryCalculation getSalaryCalculationById(Long id) {
		Optional<SalaryCalculation> optionalSalaryCalculation = salaryCalculationRepository.findById(id);
		return optionalSalaryCalculation.orElse(null);
	}

	public SalaryCalculation createSalaryCalculation(SalaryCalculation salaryCalculation) {
		return salaryCalculationRepository.save(salaryCalculation);
	}

	public SalaryCalculation updateSalaryCalculation(Long id, SalaryCalculation updatedSalaryCalculation) {
		SalaryCalculation existingCalculation = getSalaryCalculationById(id);
		if (existingCalculation != null) {
			existingCalculation.setStatus(updatedSalaryCalculation.getStatus());
			existingCalculation.setCalculation_date(updatedSalaryCalculation.getCalculation_date());
			return salaryCalculationRepository.save(existingCalculation);
		}
		return null;
	}

	public void deleteSalaryCalculation(Long id) {
		salaryCalculationRepository.deleteById(id);
	}
}
