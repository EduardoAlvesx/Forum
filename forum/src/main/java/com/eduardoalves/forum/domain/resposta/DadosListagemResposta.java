package com.eduardoalves.forum.domain.resposta;

import java.math.BigInteger;

public record DadosListagemResposta(BigInteger usario, BigInteger topico, String resolucao) {
    public DadosListagemResposta(Resposta resposta) {
        this(resposta.getAutor().getId(), resposta.getTopico().getId(), resposta.getResolucoes());
    }
}
