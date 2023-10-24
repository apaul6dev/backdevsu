package com.assessment.devsu.service;

import com.assessment.devsu.dto.ClienteDTO;
import com.assessment.devsu.dto.CuentaDTO;

public interface ClienteService {

    ClienteDTO create(ClienteDTO objDTO);
    ClienteDTO update(ClienteDTO objDTO);
    ClienteDTO findById(Integer id);
    void delete(Integer id);

}
