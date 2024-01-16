package com.eduardoalves.forum.domain.topico;

import java.math.BigInteger;
import java.time.LocalDateTime;

public record TopicoDetailsDTO(
        BigInteger usuarioId,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        boolean status,
        String curso) {
    public TopicoDetailsDTO(Topico topico) {
        this(
                topico.getAutor().getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.isStatusTopico(),
                topico.getCurso()
        );
    }
}
