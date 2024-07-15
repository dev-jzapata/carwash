package com.jzapata.clientes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequest {

    private Long id;
    private String empresa;
    private String cif;
    private Long telefono;
    private String email;
    private int cp;
    private String direccion;
    private String ciudad;
    private String provincia;
    private String pais;
}
