package com.assessment.devsu.service;

import com.assessment.devsu.dto.CuentaDTO;

public interface CuentaService {

    CuentaDTO create(CuentaDTO objDTO);
    CuentaDTO update(CuentaDTO objDTO);
    CuentaDTO findById(int id);
    void delete(int id);

}
