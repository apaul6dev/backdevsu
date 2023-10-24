package com.assessment.devsu.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cuenta")
@Getter
@Setter
@NoArgsConstructor
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCuenta;

    @Column(name = "numero_cuenta", nullable = true)
    private Integer numeroCuenta;

    @Column(name = "tipo_cuenta", nullable = true)
    private String tipoCuenta;

    @Column(name = "saldo_inicial", nullable = true)
    private Double saldoInicial;

    @Column(name = "estado", nullable = true)
    private Integer estado;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

}
