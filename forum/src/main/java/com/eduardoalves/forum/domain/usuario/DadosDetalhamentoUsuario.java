package com.eduardoalves.forum.domain.usuario;

import java.math.BigInteger;

public record DadosDetalhamentoUsuario(BigInteger id, String userName, String password) {
    public DadosDetalhamentoUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getUserName(), usuario.getUserPassword());
    }
}
