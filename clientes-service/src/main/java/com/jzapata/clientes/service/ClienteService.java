package com.jzapata.clientes.service;

import com.jzapata.clientes.entity.Cliente;

import java.util.List;

public interface ClienteService {

    public List<Cliente>  getAllClientes();

    public Cliente getCliente(Long id);

    public Cliente saveCliente(Cliente cliente);

    public void deleteCliente(Long id);

}
