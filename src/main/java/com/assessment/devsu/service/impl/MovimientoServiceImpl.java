package com.assessment.devsu.service.impl;
import com.assessment.devsu.dto.MovimientoDTO;
import com.assessment.devsu.exceptions.ResourceNotFoundException;
import com.assessment.devsu.model.Movimiento;
import com.assessment.devsu.repository.MovimientoRepository;
import com.assessment.devsu.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.modelmapper.ModelMapper;

@Service
public class MovimientoServiceImpl implements MovimientoService {

    private MovimientoRepository repository;
    private ModelMapper modelMapper;

    @Autowired
    public MovimientoServiceImpl(MovimientoRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public MovimientoDTO create(MovimientoDTO objDTO) {
        Movimiento movimiento = modelMapper.map(objDTO, Movimiento.class);
        movimiento = repository.save(movimiento);
        return modelMapper.map(movimiento, MovimientoDTO.class);
    }

    @Override
    public MovimientoDTO update(MovimientoDTO objDTO) {
        Movimiento movimiento = findObjectById(objDTO.getIdMovimiento());
        movimiento = modelMapper.map(objDTO, Movimiento.class);
        repository.save(movimiento);
        return modelMapper.map(movimiento, MovimientoDTO.class);
    }

    @Override
    public MovimientoDTO findById(Integer id) {
        Movimiento movimiento = findObjectById(id);
        return modelMapper.map(movimiento, MovimientoDTO.class);
    }

    @Override
    public void delete(Integer id) {
        Movimiento movimiento = findObjectById(id);
        repository.delete(movimiento);
    }

    private Movimiento findObjectById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movimiento not found"));
    }
}
