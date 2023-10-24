package com.assessment.devsu.controller;

import com.assessment.devsu.dto.CuentaDTO;
import com.assessment.devsu.dto.MovimientoDTO;
import com.assessment.devsu.service.CuentaService;
import com.assessment.devsu.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {
    @Autowired
    private MovimientoService movimientoService;
    @Autowired
    private CuentaService cuentaService;

    @GetMapping("/{id}")
    public MovimientoDTO getMovimientoById(@PathVariable("id") int idMovimiento) {
        return movimientoService.findById(idMovimiento);
    }

    @PostMapping
    public MovimientoDTO create(@RequestBody MovimientoDTO movimientoDTO) {
        CuentaDTO cuentaDTO = cuentaService.findById(movimientoDTO.getCuenta().getIdCuenta());
        movimientoDTO.setCuenta(cuentaDTO);
        return movimientoService.create(movimientoDTO);
    }

    @GetMapping("getAllByCuenta/{id}")
    public List<MovimientoDTO> getAllByCuenta(@PathVariable("id") int idCuenta) {
        cuentaService.findById(idCuenta);
        return movimientoService.getAllByCuenta(idCuenta);
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
