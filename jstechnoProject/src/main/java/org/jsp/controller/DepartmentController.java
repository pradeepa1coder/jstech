package org.jsp.controller;

import java.util.List;

import org.jsp.dto.Department;
import org.jsp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/savedepartment")
	public Department saveDepartment(@RequestBody Department department) {
		return departmentService.createDepartment(department);
	}

	@PutMapping("/updateDepartment/{id}")
	public Department updateDepartment(@PathVariable Long id, @RequestBody Department department) {
		return departmentService.updateDepartment(id, department);
	}

	@DeleteMapping("/deleteDepartment/{id}")
	public void deleteDepartment(@PathVariable Long id) {
		departmentService.deleteDepartment(id);
	}

	@GetMapping("/getAllDepartments")
	public List<Department> getAllDepartments() {
		return departmentService.getAllDepartments();
	}

	@GetMapping("/getDepartmentById/{id}")
	public Department getDepartmentById(@PathVariable Long id) {
		return departmentService.getDepartmentById(id);
	}

}
