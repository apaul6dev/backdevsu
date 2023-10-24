package com.assessment.devsu.service;

import com.assessment.devsu.dto.MovimientoDTO;

public interface MovimientoService {

    MovimientoDTO create(MovimientoDTO objDTO);
    MovimientoDTO update(MovimientoDTO objDTO);
    MovimientoDTO findById(Integer id);
    void delete(Integer battleId);

}
