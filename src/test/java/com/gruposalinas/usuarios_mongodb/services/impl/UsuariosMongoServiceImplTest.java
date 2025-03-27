package com.gruposalinas.usuarios_mongodb.services.impl;

import com.gruposalinas.usuarios_mongodb.dto.ApiResponseDTO;
import com.gruposalinas.usuarios_mongodb.dto.UsuarioGuardadoResponseDTO;
import com.gruposalinas.usuarios_mongodb.dto.UsuarioRequestDTO;
import com.gruposalinas.usuarios_mongodb.entities.Usuario;
import com.gruposalinas.usuarios_mongodb.repositories.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UsuariosMongoServiceImplTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioServiceImpl usuarioService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void guardarUsuario_RetornarUsuarioGuardado() {
        // Arrange
        UsuarioRequestDTO request = new UsuarioRequestDTO(
                "Luz", "Soriano", "luz@gmail.com", LocalDate.of(1999, 5, 18), true);

        Usuario usuarioEntity = new Usuario(null, "Luz", "Soriano", "luz@gmail.com", LocalDate.of(1999, 5, 18));
        Usuario usuarioGuardado = new Usuario("1", "Luz", "Soriano", "luz@gmail.com", LocalDate.of(1999, 5, 18));

        when(usuarioRepository.existsByCorreoElectronico("luz@gmail.com")).thenReturn(false);
        when(usuarioRepository.save(usuarioEntity)).thenReturn(usuarioGuardado);

        // Act
        ApiResponseDTO response = usuarioService.guardarUsuario(request);

        // Assert
        assertNotNull(response);
        assertNotNull(response.getMeta());
        assertEquals(200, response.getMeta().getStatusCode());
        assertEquals("OK", response.getMeta().getStatus());

        assertInstanceOf(UsuarioGuardadoResponseDTO.class, response.getData());

        UsuarioGuardadoResponseDTO data = (UsuarioGuardadoResponseDTO) response.getData();
        assertEquals("Luz", data.getNombre());
        assertEquals("luz@gmail.com", data.getCorreoElectronico());

        verify(usuarioRepository, times(1)).existsByCorreoElectronico("luz@gmail.com");
        verify(usuarioRepository, times(1)).save(usuarioEntity);
    }


    @Test
    void obtenerTodosLosUsuarios_RetornarLista() {
        /// Arrange
        List<Usuario> lista = Arrays.asList(
                new Usuario("1", "Luz", "Soriano", "luz@gmail.com", LocalDate.of(1999, 5, 18)),
                new Usuario("2", "Carlos", "Mendoza", "carlos@example.com", LocalDate.of(1985, 12, 1))
        );

        when(usuarioRepository.findAll()).thenReturn(lista);

        // Act
        ApiResponseDTO response = usuarioService.obtenerTodosLosUsuarios();

        // Assert
        assertNotNull(response);
        assertNotNull(response.getMeta());
        assertEquals(200, response.getMeta().getStatusCode());
        assertEquals("OK", response.getMeta().getStatus());
        assertInstanceOf(List.class, response.getData());

        List<?> data = (List<?>) response.getData();
        assertEquals(2, data.size());

        verify(usuarioRepository, times(1)).findAll();
    }
}
