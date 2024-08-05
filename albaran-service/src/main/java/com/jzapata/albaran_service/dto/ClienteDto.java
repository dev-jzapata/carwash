package com.jzapata.albaran_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {

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
    private boolean eliminado;
}
