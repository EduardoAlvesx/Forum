package com.eduardoalves.forum.domain.usuario;

import java.math.BigInteger;

public record UsuarioResponseDTO(BigInteger id, String userName, String userPassword) {
    public UsuarioResponseDTO(Usuario usuario) {
        this(usuario.getId(), usuario.getUserName(), usuario.getUserPassword());
    }
}
