package org.jsp.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.jsp.dto.Department;
import org.jsp.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

	public Department getDepartmentById(Long id) {
		return departmentRepository.findById(id).orElse(null);
	}

	public Department createDepartment(Department department) {
		department.setCreated_at(department.getCreated_at());

		department.setUpdated_at(department.getUpdated_at());
		return departmentRepository.save(department);
	}

	public Department updateDepartment(Long id, Department department) {
		Optional<Department> existingDepartmentOptional = departmentRepository.findById(id);

		if (existingDepartmentOptional.isPresent()) {
			Department existingDepartment = existingDepartmentOptional.get();
			existingDepartment.setName(department.getName());
			existingDepartment.setUpdated_at(LocalDateTime.now());
			return departmentRepository.save(existingDepartment);
		} else {
			return null; // Department not found
		}
	}

	public void deleteDepartment(Long id) {
		departmentRepository.deleteById(id);
	}
}
