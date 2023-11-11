package com.eduardoalves.forum.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;

public interface UsuarioRepository extends JpaRepository<Usuario, BigInteger> {
    @Query(value = "update Topico a set a.autorUsuario = :autorUsuario where autor = :id", nativeQuery = true)
    void updateTopicoColumnUserNameById(String autorUsuario, BigInteger id);
}
