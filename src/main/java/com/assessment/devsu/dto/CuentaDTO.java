package com.assessment.devsu.dto;

import com.univocity.parsers.annotations.Parsed;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CuentaDTO {

    private Integer idCuenta;
    @Parsed
    private Integer numeroCuenta;
    @Parsed
    private String tipoCuenta;
    @Parsed
    private Double saldoInicial;
    @Parsed
    private Integer estado;

    private ClienteDTO cliente;
}
