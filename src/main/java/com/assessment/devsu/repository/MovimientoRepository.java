package com.assessment.devsu.repository;

import com.assessment.devsu.model.Cliente;
import com.assessment.devsu.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {
}
