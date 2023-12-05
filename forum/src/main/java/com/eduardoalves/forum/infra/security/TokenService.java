package com.eduardoalves.forum.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.eduardoalves.forum.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(Usuario usuario) {
        try {
            var alogoritimo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("forum.api")
                    .withSubject(usuario.getUsername())
                    .withExpiresAt(expireDate())
                    .sign(alogoritimo);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar o token", exception);
        }
    }
    public String getSubject(String token) {
        try {
            var alogoritimo = Algorithm.HMAC256(secret);
            return JWT.require(alogoritimo)
                    .withIssuer("forum.api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token expirado ou inválido", exception);
        }
    }

    private Instant expireDate() {
        return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-03:00"));
    }
}
