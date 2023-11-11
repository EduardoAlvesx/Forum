package com.eduardoalves.forum.domain.topico;

import com.eduardoalves.forum.domain.usuario.DadosCadastroUsuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.Year;

public interface TopicoRepository extends JpaRepository<Topico, BigInteger> {
    Page<Topico> findByCurso(String curso, Pageable pageable);
    Page<Topico> findByDataCriacao(LocalDateTime ano, Pageable pageable);

}
