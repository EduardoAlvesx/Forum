package com.eduardoalves.forum.domain.topico;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        boolean status,
        String autorUsuario,
        String curso) {
    public DadosDetalhamentoTopico(Topico topico) {
        this(topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.isStatusTopico(), topico.getAutorUsuario(),
                topico.getCurso());
    }
}
