package org.jsp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.dto.Salary;
import org.jsp.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryService {

	@Autowired
	private SalaryRepository salaryRepository;

	public List<Salary> getAllSalaries() {
		return salaryRepository.findAll();
	}

	public Salary getSalaryById(Long id) {
		return salaryRepository.findById(id).orElse(null);
	}

	public Salary createSalary(Salary salary) {
		return salaryRepository.save(salary);
	}

	public Salary updateSalary(Long id, Salary updatedSalary) {
		Optional<Salary> salaryOptional = salaryRepository.findById(id);
		if (salaryOptional.isPresent()) {
			Salary existingSalary = salaryOptional.get();
			existingSalary.setBasic_salary(updatedSalary.getBasic_salary());
			existingSalary.setHra(updatedSalary.getHra());
			existingSalary.setDa(updatedSalary.getDa());
			existingSalary.setOther_allowances(updatedSalary.getOther_allowances());

			return salaryRepository.save(existingSalary);
		} else {
			return null;
		}
	}

	public void deleteSalary(Long id) {
		salaryRepository.deleteById(id);
	}
}
