package com.eduardoalves.forum.domain.resposta;

import java.math.BigInteger;

public record RespostaResponseDTO(BigInteger id, BigInteger usario, BigInteger topico, String resolucao) {
    public RespostaResponseDTO(Resposta resposta) {
        this(resposta.getId(), resposta.getAutor().getId(), resposta.getTopico().getId(), resposta.getResolucoes());
    }
}
