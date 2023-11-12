package com.eduardoalves.forum.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;

public interface UsuarioRepository extends JpaRepository<Usuario, BigInteger> {

}
