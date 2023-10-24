package com.assessment.devsu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    private MovimientoController movimientoController;

    public MovimientoController(MovimientoController movimientoController) {
        this.movimientoController = movimientoController;
    }

}
