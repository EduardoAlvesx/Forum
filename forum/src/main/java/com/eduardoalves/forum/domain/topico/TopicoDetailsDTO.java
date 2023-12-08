package com.eduardoalves.forum.domain.topico;

import java.time.LocalDateTime;

public record TopicoDetailsDTO(
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        boolean status,
        String curso) {
    public TopicoDetailsDTO(Topico topico) {
        this(topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.isStatusTopico(), topico.getCurso());
    }
}
