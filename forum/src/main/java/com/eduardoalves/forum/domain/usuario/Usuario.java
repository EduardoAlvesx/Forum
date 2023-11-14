package com.eduardoalves.forum.domain.usuario;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
@Table(name = "usuario")
@Entity(name = "Usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private String userName;
    private String userPassword;

    public Usuario(UsuarioRequestDTO dados) {
        this.userName = dados.userName();
        this.userPassword = dados.userPassword();
    }

    public void atualizarInformacoes(UsuarioUpdateDTO dados) {
        this.userName = dados.userName();
        this.userPassword = dados.userPassword();
    }
}
