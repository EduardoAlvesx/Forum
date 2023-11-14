package com.eduardoalves.forum.domain.resposta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;

public interface RespostaRepository extends JpaRepository<Resposta, BigInteger> {
    @Query("update Topico set statusTopico = true where id = :topicoId")
    void atualizarColunaStatusTopico(BigInteger topicoId);
}
