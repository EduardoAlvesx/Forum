package com.eduardoalves.forum.domain.topico;

import java.math.BigInteger;
import java.time.LocalDateTime;

public record TopicoResponseDTO(
        BigInteger id,
        String titulo,
        String mensagem,
        LocalDateTime data_criacao,
        boolean status,
        BigInteger usarioId,
        String curso,
        Long total_respostas) {
    public TopicoResponseDTO(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.isStatusTopico(), topico.getAutor().getId(), topico.getCurso(), topico.getTotal_respostas());
    }
}
