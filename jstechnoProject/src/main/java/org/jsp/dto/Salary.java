package org.jsp.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Salary {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "position_id")
	private Position position;
	private BigDecimal basic_salary;
	private BigDecimal hra;
	private BigDecimal da;
	private BigDecimal other_allowances;
	private BigDecimal gross_salary;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
}
