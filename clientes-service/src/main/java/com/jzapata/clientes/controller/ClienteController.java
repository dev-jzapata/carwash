package com.jzapata.clientes.controller;

import com.jzapata.clientes.dto.ClienteRequest;
import com.jzapata.clientes.dto.ClienteResponse;
import com.jzapata.clientes.entity.Cliente;
import com.jzapata.clientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    @PreAuthorize("hasRole('user_client_role') or hasRole('admin_client_role')")
    public ResponseEntity<List<Cliente>> getAllClientes(){
        return ResponseEntity.ok().body(clienteService.getAllClientes());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<Cliente> saveCliente(@RequestBody ClienteRequest clienteDto){
        Cliente cliente = new Cliente();
        cliente.setEmpresa(clienteDto.getEmpresa());
        cliente.setCif(clienteDto.getCif());
        cliente.setTelefono(clienteDto.getTelefono());
        cliente.setEmail(clienteDto.getEmail());
        cliente.setCp(clienteDto.getCp());
        cliente.setDireccion(clienteDto.getDireccion());
        cliente.setCiudad(clienteDto.getCiudad());
        cliente.setProvincia(clienteDto.getProvincia());
        cliente.setPais(clienteDto.getPais());
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> getCliente(@PathVariable Long id){

        ClienteResponse clienteResponse = new ClienteResponse();
        Cliente cliente = clienteService.getCliente(id);
        clienteResponse.setId(cliente.getId());
        clienteResponse.setEmpresa(cliente.getEmpresa());
        clienteResponse.setCif(cliente.getCif());
        clienteResponse.setTelefono(cliente.getTelefono());
        clienteResponse.setEmail(cliente.getEmail());
        clienteResponse.setCp(cliente.getCp());
        clienteResponse.setDireccion(cliente.getDireccion());
        clienteResponse.setCiudad(cliente.getCiudad());
        clienteResponse.setProvincia(cliente.getProvincia());
        clienteResponse.setPais(cliente.getPais());

        return ResponseEntity.ok().body(clienteResponse);

    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public ResponseEntity<ClienteResponse>deleteCliente(@PathVariable Long id){
        clienteService.deleteCliente(id);

        ClienteResponse clienteResponse = new ClienteResponse();

        clienteResponse.setMensaje("Cliente eliminado!");

        return ResponseEntity.ok().body(clienteResponse);
    }

}
