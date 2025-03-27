package com.gruposalinas.usuarios_mongodb.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioGuardadoResponseDTO {
    private String mensaje;
    private String nombre;
    private String correoElectronico;
}
