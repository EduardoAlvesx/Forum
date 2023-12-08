package com.eduardoalves.forum.controller;

import com.eduardoalves.forum.domain.usuario.Usuario;
import com.eduardoalves.forum.domain.usuario.UsuarioRequestDTO;
import com.eduardoalves.forum.infra.security.TokenResponseDTO;
import com.eduardoalves.forum.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private TokenService tokenService;
    @PostMapping
    public ResponseEntity login (@RequestBody UsuarioRequestDTO dto) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dto.userName(), dto.userPassword());
        var authentication = manager.authenticate(authenticationToken);

        var token = tokenService.generateToken((Usuario) authentication.getPrincipal());
        if (token != null) {
            System.out.println("Voce esta loggado, aqui esta o seu token");
            System.out.println(token);
        }


        return ResponseEntity.ok(new TokenResponseDTO(token));
    }
}
