package com.eduardoalves.forum.domain.resposta;

import java.math.BigInteger;

public record DadosPostagemResposta(BigInteger topicoId, BigInteger usuarioId, String resolucao) {
}
