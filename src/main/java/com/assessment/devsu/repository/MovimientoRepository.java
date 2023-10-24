package com.assessment.devsu.repository;

import com.assessment.devsu.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {

    @Query(value="SELECT m.id_movimiento, m.fecha, m.saldo, m.tipo, m.valor, m.id_cuenta " +
            "FROM movimiento m, cuenta c " +
            "where m.id_cuenta = c.id_cuenta " +
            "      and c.id_cuenta = :idCuenta " +
            "ORDER BY fecha DESC " +
            "LIMIT 1", nativeQuery = true)
    Movimiento getLastMovimiento(@Param("idCuenta") Integer idCuenta);

    @Query(value="SELECT m.id_movimiento, m.fecha, m.saldo, m.tipo, m.valor, m.id_cuenta " +
            "FROM movimiento m, cuenta c " +
            "where m.id_cuenta = c.id_cuenta " +
            "      and c.id_cuenta = :idCuenta " +
            "ORDER BY fecha DESC ", nativeQuery = true)
    List<Movimiento> getAll(@Param("idCuenta") Integer idCuenta);


}
