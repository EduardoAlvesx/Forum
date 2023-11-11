package com.eduardoalves.forum.domain.usuario;

import jakarta.validation.constraints.NotBlank;

import java.math.BigInteger;

public record DadosAtualizacaoUsuario(
        BigInteger id,
        @NotBlank
        String userName,
        @NotBlank
        String userPassword) {
}
