package com.gruposalinas.usuarios_mongodb.controllers;

import com.gruposalinas.usuarios_mongodb.dto.ApiResponseDTO;
import com.gruposalinas.usuarios_mongodb.dto.UsuarioRequestDTO;
import com.gruposalinas.usuarios_mongodb.entities.Usuario;
import com.gruposalinas.usuarios_mongodb.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/grupo-salinas-usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ApiResponseDTO crearUsuario(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        return usuarioService.guardarUsuario(usuarioRequestDTO);
    }

    @GetMapping
    public ApiResponseDTO obtenerTodosLosUsuarios(){
        return usuarioService.obtenerTodosLosUsuarios();
    }


}
