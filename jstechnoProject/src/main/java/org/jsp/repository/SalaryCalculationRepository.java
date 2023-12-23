package org.jsp.repository;

import org.jsp.dto.SalaryCalculation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryCalculationRepository extends JpaRepository<SalaryCalculation, Long> {
}
