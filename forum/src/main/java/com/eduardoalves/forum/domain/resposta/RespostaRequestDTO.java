package com.eduardoalves.forum.domain.resposta;

import java.math.BigInteger;

public record RespostaRequestDTO(BigInteger topicoId, String resolucao) {
}
