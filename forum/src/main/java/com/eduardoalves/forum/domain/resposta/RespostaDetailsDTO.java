package com.eduardoalves.forum.domain.resposta;

import java.math.BigInteger;

public record RespostaDetailsDTO(BigInteger usuario, BigInteger topico, String resolucao) {
    public RespostaDetailsDTO(Resposta resposta) {
        this(resposta.getAutor().getId(), resposta.getTopico().getId(), resposta.getResolucoes());
    }
}
