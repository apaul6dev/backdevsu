package com.assessment.devsu.service;

import com.assessment.devsu.dto.MovimientoDTO;

import java.util.List;

public interface MovimientoService {

    MovimientoDTO create(MovimientoDTO objDTO);
    MovimientoDTO update(MovimientoDTO objDTO);
    MovimientoDTO findById(int id);
    List<MovimientoDTO> getAllByCuenta(int idCuenta);
    void delete(int id);

}
