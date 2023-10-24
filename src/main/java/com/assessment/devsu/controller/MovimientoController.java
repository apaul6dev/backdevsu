package com.assessment.devsu.controller;

import com.assessment.devsu.dto.MovimientoDTO;
import com.assessment.devsu.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    private MovimientoService movimientoService;
    @Autowired
    public MovimientoController(MovimientoService movimientoService) {
        this.movimientoService = movimientoService;
    }

    @GetMapping("/{id}")
    public MovimientoDTO getMovimientoById(@PathVariable("id") int idMovimiento) {
        return movimientoService.findById(idMovimiento);
    }

    @PostMapping
    public MovimientoDTO create(@RequestBody MovimientoDTO movimientoDTO) {
        return movimientoService.create(movimientoDTO);
    }

    @PutMapping
    public MovimientoDTO update(@RequestBody MovimientoDTO movimientoDTO) {
        return movimientoService.update(movimientoDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int idMovimiento) {
        movimientoService.delete(idMovimiento);
    }
}
