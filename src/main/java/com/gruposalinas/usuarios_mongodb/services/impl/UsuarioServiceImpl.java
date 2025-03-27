package com.gruposalinas.usuarios_mongodb.services.impl;

import com.gruposalinas.usuarios_mongodb.dto.ApiResponseDTO;
import com.gruposalinas.usuarios_mongodb.dto.UsuarioGuardadoResponseDTO;
import com.gruposalinas.usuarios_mongodb.dto.UsuarioRequestDTO;
import com.gruposalinas.usuarios_mongodb.entities.Usuario;
import com.gruposalinas.usuarios_mongodb.exceptions.AppUsuarioMongoException;
import com.gruposalinas.usuarios_mongodb.mappers.MapperGenerico;
import com.gruposalinas.usuarios_mongodb.repositories.UsuarioRepository;
import com.gruposalinas.usuarios_mongodb.services.UsuarioService;
import com.gruposalinas.usuarios_mongodb.util.Meta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.gruposalinas.usuarios_mongodb.util.Constantes.CAMPOS_OBLIGATORIOS;
import static com.gruposalinas.usuarios_mongodb.util.Constantes.GUARDADO_EXITO;


@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private final Meta meta = new Meta(UUID.randomUUID().toString(), "OK", 200);

    @Override
    public ApiResponseDTO guardarUsuario(UsuarioRequestDTO usuarioRequestDTO) {

        if (usuarioRequestDTO.getNombre() == null || usuarioRequestDTO.getNombre().isBlank() ||
                usuarioRequestDTO.getApellidoPaterno() == null || usuarioRequestDTO.getApellidoPaterno().isBlank() ||
                usuarioRequestDTO.getCorreoElectronico() == null || usuarioRequestDTO.getCorreoElectronico().isBlank() ||
                usuarioRequestDTO.getFechaNacimiento() == null || usuarioRequestDTO.getAceptaTerminos() == null) {

            throw new AppUsuarioMongoException(
                    CAMPOS_OBLIGATORIOS,
                    HttpStatus.BAD_REQUEST.value(),
                    HttpStatus.BAD_REQUEST.name()
            );
        }

        if (usuarioRepository.existsByCorreoElectronico(usuarioRequestDTO.getCorreoElectronico())) {
            throw new AppUsuarioMongoException(
                    "Ya existe un usuario registrado con ese correo electrónico",
                    HttpStatus.UNPROCESSABLE_ENTITY.value(),
                    HttpStatus.UNPROCESSABLE_ENTITY.name()
            );
        }

        if(!usuarioRequestDTO.getAceptaTerminos()){
            throw new AppUsuarioMongoException(
                    "Se deben aceptar términos y condiciones",
                    HttpStatus.UNPROCESSABLE_ENTITY.value(),
                    HttpStatus.UNPROCESSABLE_ENTITY.name()
            );
        }

        Usuario usuario = MapperGenerico.mapEntity(usuarioRequestDTO, Usuario.class);
        usuarioRepository.save(usuario);

        UsuarioGuardadoResponseDTO responseDTO = new UsuarioGuardadoResponseDTO(
                GUARDADO_EXITO,
                usuario.getNombre(),
                usuario.getCorreoElectronico()
        );

        return new ApiResponseDTO(meta, responseDTO);
    }

    @Override
    public ApiResponseDTO obtenerTodosLosUsuarios() {

        List<Usuario> listaUsuarios;
        listaUsuarios = usuarioRepository.findAll();

        return new ApiResponseDTO(meta, listaUsuarios);
    }
}
