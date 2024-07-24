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

    private LocalDate fecha;

    private List<LavadoDto> lavados;

}
