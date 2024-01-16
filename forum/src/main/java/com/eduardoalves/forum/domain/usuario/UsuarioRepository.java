package com.eduardoalves.forum.domain.usuario;

import io.micrometer.observation.ObservationFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigInteger;

public interface UsuarioRepository extends JpaRepository<Usuario, BigInteger> {
    UserDetails findByUserName(String username);
    @Query(value = "SELECT u.id FROM Usuario u where u.userName = :userName")
    BigInteger getIdByUserName(String userName);
    Page<Usuario> findUsuarioByUserName(String userName, Pageable pageable);
}
