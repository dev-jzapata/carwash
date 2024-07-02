package com.jzapata.lavado_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lavados")
public class Lavado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Proporciona el nombre")
    @Size(min = 4, message = "Mínimo 4 caracteres")
    @Column(name = "firstname", nullable = false)
    private String nombre;

    private boolean eliminado;
}
