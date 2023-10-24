package com.assessment.devsu.service.impl;

import com.assessment.devsu.dto.ClienteDTO;
import com.assessment.devsu.dto.CuentaDTO;
import com.assessment.devsu.exceptions.ResourceNotFoundException;
import com.assessment.devsu.model.Cliente;
import com.assessment.devsu.model.Cuenta;
import com.assessment.devsu.repository.ClienteRepository;
import com.assessment.devsu.service.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository repository;
    private ModelMapper modelMapper;

    @Autowired
    public ClienteServiceImpl(ClienteRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ClienteDTO create(ClienteDTO objDTO) {
        Cliente cliente = modelMapper.map(objDTO, Cliente.class);
        cliente = repository.save(cliente);
        return modelMapper.map(cliente, ClienteDTO.class);
    }

    @Override
    public ClienteDTO update(ClienteDTO objDTO) {
        Cliente cliente = findObjectById(objDTO.getIdPersona());
        cliente = modelMapper.map(objDTO, Cliente.class);
        repository.save(cliente);
        return modelMapper.map(cliente, ClienteDTO.class);
    }

    @Override
    public ClienteDTO findById(Integer id) {
        Cliente cliente = findObjectById(id);
        return modelMapper.map(cliente, ClienteDTO.class);
    }

    @Override
    public void delete(Integer id) {
        Cliente cliente = findObjectById(id);
        repository.delete(cliente);
    }

    private Cliente findObjectById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente not found"));
    }

}
