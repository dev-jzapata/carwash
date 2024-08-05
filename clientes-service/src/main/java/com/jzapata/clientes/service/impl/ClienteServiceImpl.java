package com.jzapata.clientes.service.impl;

import com.jzapata.clientes.entity.Cliente;
import com.jzapata.clientes.repository.ClienteRepository;
import com.jzapata.clientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findByEliminadoFalse();
    }

    @Override
    public Cliente getCliente(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteCliente(Long id) {

        try {
            clienteRepository.deleteById(id);

        } catch (Exception e) {

            Cliente cliente = clienteRepository.findById(id).orElse(null);
            if (cliente != null) {
                cliente.setEliminado(true);
                clienteRepository.save(cliente);

            }
        }
    }
}
