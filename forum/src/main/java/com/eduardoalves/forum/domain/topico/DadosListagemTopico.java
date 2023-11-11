package com.eduardoalves.forum.domain.topico;

import java.time.LocalDateTime;

public record DadosListagemTopico(
        String titulo,
        String mensagem,
        LocalDateTime data_criacao,
        boolean status,
        String autorUsuario,
        String curso) {
    public DadosListagemTopico(Topico topico) {
        this(topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.isStatusTopico(),
                topico.getAutorUsuario(), topico.getCurso());
    }
}
