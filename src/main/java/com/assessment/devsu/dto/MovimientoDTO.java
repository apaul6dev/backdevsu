package com.assessment.devsu.dto;

import com.univocity.parsers.annotations.Parsed;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MovimientoDTO {

    private Integer idMovimiento;
    @Parsed
    private Date fecha;
    @Parsed
    private String tipo;
    @Parsed
    private Double valor;
    @Parsed
    private Double saldo;

    private CuentaDTO cuenta;
}
