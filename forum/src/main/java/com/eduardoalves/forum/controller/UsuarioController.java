package com.eduardoalves.forum.controller;

import com.eduardoalves.forum.domain.topico.TopicoRepository;
import com.eduardoalves.forum.domain.usuario.*;
import jakarta.validation.Valid;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigInteger;

@RestController
@RequestMapping("usuario")
@Log
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TopicoRepository topicoRepository;
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid UsuarioRequestDTO dados, UriComponentsBuilder builder) {
        if (this.usuarioRepository.findByUserName(dados.userName()) != null) return ResponseEntity.badRequest().build();
        Usuario usuario = new Usuario(dados);
        usuarioRepository.save(usuario);
        var uri = builder.path("usuario/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(new UsuarioDetailsDTO(usuario));
    }
    @GetMapping
    public Page<UsuarioResponseDTO> listar(Pageable pageable) {
        return usuarioRepository.findAll(pageable).map(UsuarioResponseDTO::new);
    }
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid UsuarioUpdateDTO dados) {
        var usuario = usuarioRepository.getReferenceById(dados.id());
        usuario.atualizarInformacoes(dados);

        usuarioRepository.save(usuario);
        return ResponseEntity.ok(new UsuarioDetailsDTO(usuario));
    }
    @DeleteMapping(path = "/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable BigInteger id) {
        usuarioRepository.deleteById(id);

        return ResponseEntity.notFound().build();
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity detalhar(@PathVariable BigInteger id) {
        Usuario usuario = usuarioRepository.getReferenceById(id);

        return ResponseEntity.ok(new UsuarioDetailsDTO(usuario));
    }
}
