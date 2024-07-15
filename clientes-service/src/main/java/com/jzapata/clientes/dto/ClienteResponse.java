package com.jzapata.clientes.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteResponse {

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
    private String mensaje;
    private boolean eliminado;
}
