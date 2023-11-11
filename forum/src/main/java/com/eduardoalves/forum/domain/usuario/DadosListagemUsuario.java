package com.eduardoalves.forum.domain.usuario;

import java.math.BigInteger;

public record DadosListagemUsuario(BigInteger id, String userName, String userPassword) {
    public DadosListagemUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getUserName(), usuario.getUserPassword());
    }
}
