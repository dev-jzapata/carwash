package com.jzapata.lavado_service.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LavadoResponse {
    private Long id;
    private String nombre;
    private String mensaje;
}
