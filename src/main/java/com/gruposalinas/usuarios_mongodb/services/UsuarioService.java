package com.gruposalinas.usuarios_mongodb.services;

import com.gruposalinas.usuarios_mongodb.dto.ApiResponseDTO;
import com.gruposalinas.usuarios_mongodb.dto.UsuarioRequestDTO;
import com.gruposalinas.usuarios_mongodb.entities.Usuario;
import org.springframework.stereotype.Service;

@Service
public interface UsuarioService {

    ApiResponseDTO guardarUsuario(UsuarioRequestDTO usuarioRequestDTO);

    public ApiResponseDTO obtenerTodosLosUsuarios();

}
