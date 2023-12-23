package org.jsp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.dto.Employee;
import org.jsp.repository.EmployeeRepository;
import org.jsp.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	private final EmployeeRepository employeeRepository;
	private final PositionRepository positionRepository;

	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository, PositionRepository positionRepository) {
		this.employeeRepository = employeeRepository;
		this.positionRepository = positionRepository;
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).orElse(null);
	}

	public Employee createEmployee(Employee employee) {
		// Check if the employee has a position
		if (employee.getPosition() != null) {
			// Save the position if it's not saved yet
			if (employee.getPosition().getId() == null) {
				employee.setPosition(positionRepository.save(employee.getPosition()));
			}
		}

		// Now, save the employee
		return employeeRepository.save(employee);
	}

	public Employee updateEmployee(Long id, Employee updatedEmployee) {
		Optional<Employee> employeeOptional = employeeRepository.findById(id);
		if (employeeOptional.isPresent()) {
			Employee existingEmployee = employeeOptional.get();
			existingEmployee.setName(updatedEmployee.getName());
			existingEmployee.setEmail(updatedEmployee.getEmail());
			existingEmployee.setPhone_number(updatedEmployee.getPhone_number());
			existingEmployee.setAddress(updatedEmployee.getAddress());

			return employeeRepository.save(existingEmployee);
		} else {
			return null; 
		}
	}

	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}
}
