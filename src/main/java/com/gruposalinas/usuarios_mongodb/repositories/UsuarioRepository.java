package com.gruposalinas.usuarios_mongodb.repositories;

import com.gruposalinas.usuarios_mongodb.entities.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {

    boolean existsByCorreoElectronico(String correoElectronico);

}
