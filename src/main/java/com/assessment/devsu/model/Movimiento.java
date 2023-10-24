package com.assessment.devsu.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "movimiento")
@Getter
@Setter
@NoArgsConstructor
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMovimiento;

    @Column(name = "fecha", nullable = true)
    private Date fecha;

    @Column(name = "tipo", nullable = true)
    private String tipo;

    @Column(name = "valor", nullable = true)
    private Double valor;

    @Column(name = "saldo", nullable = true)
    private Double saldo;

    @ManyToOne
    @JoinColumn(name = "id_cuenta", nullable = false)
    private Cuenta cuenta;

}
