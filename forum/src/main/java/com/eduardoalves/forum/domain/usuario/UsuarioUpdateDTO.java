package com.eduardoalves.forum.domain.usuario;

import jakarta.validation.constraints.NotBlank;

import java.math.BigInteger;

public record UsuarioUpdateDTO(
        BigInteger id,
        String userName,
        String userPassword) {
}
