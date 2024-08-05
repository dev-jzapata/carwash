package com.jzapata.clientes.service;

import com.jzapata.clientes.entity.Cliente;

import java.util.List;

public interface KafkaClienteService {

    public List<Cliente> loadClientes(String receivedString);

    public void sendClientes(String topic, List<Cliente> clientes);

}
