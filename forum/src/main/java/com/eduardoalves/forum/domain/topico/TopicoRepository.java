package com.eduardoalves.forum.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.time.LocalDateTime;

public interface TopicoRepository extends JpaRepository<Topico, BigInteger> {
    Page<Topico> findByCurso(String curso, Pageable pageable);
    Page<Topico> findByDataCriacao(LocalDateTime ano, Pageable pageable);

}
