package com.jzapata.albaran_service.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlbaranResponse {
    private Long id;
    private List<LavadoDto> allLavados;
    private List<ClienteDto> allClientes;
    private LocalDate fecha;
    private Long cliente;
    private List<Long> lavados;
    private String mensaje;

}
