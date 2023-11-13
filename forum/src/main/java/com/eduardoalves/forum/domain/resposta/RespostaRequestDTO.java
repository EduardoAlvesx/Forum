package com.eduardoalves.forum.domain.resposta;

import java.math.BigInteger;

public record RespostaRequestDTO(BigInteger topicoId, BigInteger usuarioId, String resolucao) {
}
