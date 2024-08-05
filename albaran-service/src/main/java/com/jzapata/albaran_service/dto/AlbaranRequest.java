package com.jzapata.albaran_service.dto;


import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlbaranRequest {

    private Long id;

    private LocalDate fecha;

    private List<Long> lavados;

    private String mensaje;

    private ClienteDto clienteDto;

}
