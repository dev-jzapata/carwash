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

    private LocalDate fecha;

    private List<LavadoDto> lavados;

    private String mensaje;
}
