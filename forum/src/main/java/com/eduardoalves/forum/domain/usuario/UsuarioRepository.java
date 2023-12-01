package com.eduardoalves.forum.domain.usuario;

import com.eduardoalves.forum.domain.topico.Topico;
import com.eduardoalves.forum.domain.topico.TopicoResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigInteger;

public interface UsuarioRepository extends JpaRepository<Usuario, BigInteger> {
    UserDetails findByUserName(String username);

}
