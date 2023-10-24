package com.assessment.devsu.service.impl;

import com.assessment.devsu.dto.MovimientoDTO;
import com.assessment.devsu.exceptions.ResourceNotFoundException;
import com.assessment.devsu.exceptions.UnprocessableMovimiento;
import com.assessment.devsu.model.Movimiento;
import com.assessment.devsu.repository.MovimientoRepository;
import com.assessment.devsu.service.MovimientoService;
import com.assessment.devsu.util.MovimientoStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.modelmapper.ModelMapper;

import java.util.List;

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
        Movimiento lastMovimiento = getLastMovimiento(movimiento.getCuenta().getIdCuenta());
        Double saldoTmp = null;

        if (lastMovimiento != null) {
            saldoTmp = lastMovimiento.getSaldo();
        } else {
            saldoTmp = movimiento.getCuenta().getSaldoInicial();
        }

        if (objDTO.getTipo().equals("deposito")) {
            movimiento.setSaldo(saldoTmp + movimiento.getValor());
        } else if (objDTO.getTipo().equals("retiro")) {
            Double debito = saldoTmp - movimiento.getValor();
            if (debito < 0) {
                throw new UnprocessableMovimiento(MovimientoStatus.SALDO_NO_DISPONIBLE.getStatus());
            }
            movimiento.setSaldo(debito);
        }

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


    private Movimiento getLastMovimiento(int idCuenta) {
        return repository.getLastMovimiento(idCuenta);
    }

    private List<Movimiento> getAllMovimientos(int idCuenta) {
        return repository.getAll(idCuenta);
    }

    @Override
    public MovimientoDTO findById(int id) {
        Movimiento movimiento = findObjectById(id);
        return modelMapper.map(movimiento, MovimientoDTO.class);
    }

    @Override
    public void delete(int id) {
        Movimiento movimiento = findObjectById(id);
        repository.delete(movimiento);
    }

    private Movimiento findObjectById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movimiento not found"));
    }
}
