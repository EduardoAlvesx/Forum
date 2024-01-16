package com.eduardoalves.forum.domain.usuario;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

@Table(name = "usuario")
@Entity(name = "Usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private String userName;
    private String userPassword;

    public Usuario(UsuarioRequestDTO dados) {
        this.userName = dados.userName();
        this.userPassword = hashPasswordCreate(dados);

    }

    public void atualizarInformacoes(UsuarioUpdateDTO dados) {
        if (dados.userName() != null) {
            this.userName = dados.userName();
        }
        if (dados.userPassword() != null) {
            this.userPassword = hashPasswordUpdate(dados);
        }

    }
    private String hashPasswordCreate(UsuarioRequestDTO dados) {
        return new BCryptPasswordEncoder().encode(dados.userPassword());
    }

    private String hashPasswordUpdate(UsuarioUpdateDTO dados) {
        return new BCryptPasswordEncoder().encode(dados.userPassword());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return userPassword;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
