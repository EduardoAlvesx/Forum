package com.eduardoalves.forum.domain.usuario;

import java.math.BigInteger;

public record UsuarioDetailsDTO(BigInteger id, String userName, String password) {
    public UsuarioDetailsDTO(Usuario usuario) {
        this(usuario.getId(), usuario.getUserName(), usuario.getUserPassword());
    }
}
