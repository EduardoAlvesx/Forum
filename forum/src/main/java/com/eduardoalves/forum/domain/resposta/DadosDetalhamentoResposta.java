package com.eduardoalves.forum.domain.resposta;

import java.math.BigInteger;

public record DadosDetalhamentoResposta(BigInteger usuario, BigInteger topico, String resolucao) {
    public DadosDetalhamentoResposta(Resposta resposta) {
        this(resposta.getAutor().getId(), resposta.getTopico().getId(), resposta.getResolucoes());
    }
}
