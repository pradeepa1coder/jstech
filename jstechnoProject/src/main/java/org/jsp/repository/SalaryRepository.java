package org.jsp.repository;

import org.jsp.dto.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary, Long> {
}

