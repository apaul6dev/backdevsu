package com.assessment.devsu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    private CuentaController cuentaController;

    public CuentaController(CuentaController cuentaController) {
        this.cuentaController = cuentaController;
    }
}
