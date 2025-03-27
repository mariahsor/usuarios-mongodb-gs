package com.gruposalinas.usuarios_mongodb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor @NoArgsConstructor
public class UsuarioRequestDTO {
    private String nombre;
    private String apellidoPaterno;
    private String correoElectronico;
    private LocalDate fechaNacimiento;
    private Boolean aceptaTerminos;

}
