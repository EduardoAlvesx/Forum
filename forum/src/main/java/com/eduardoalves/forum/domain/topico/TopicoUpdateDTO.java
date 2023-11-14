package com.eduardoalves.forum.domain.topico;

import jakarta.validation.constraints.NotBlank;

import java.math.BigInteger;

public record TopicoUpdateDTO(
        BigInteger id,
        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotBlank
        String curso) {
}
