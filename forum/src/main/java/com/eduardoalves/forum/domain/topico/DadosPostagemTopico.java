package com.eduardoalves.forum.domain.topico;

import jakarta.validation.constraints.NotBlank;

import java.math.BigInteger;

public record DadosPostagemTopico(
        @NotBlank(message = "Titulo nao pode estar vázio")
        String titulo,
        @NotBlank
        String mensagem,
        BigInteger usuarioId,
        @NotBlank
        String curso) {
}
