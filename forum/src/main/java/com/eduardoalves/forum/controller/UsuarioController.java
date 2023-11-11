package com.eduardoalves.forum.controller;

import com.eduardoalves.forum.domain.usuario.*;
import jakarta.validation.Valid;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigInteger;

@RestController
@RequestMapping("usuario")
@Log
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroUsuario dados, UriComponentsBuilder builder) {
        Usuario usuario = new Usuario(dados);
        log.severe(dados.userName());
        repository.save(usuario);
        var uri = builder.path("usuario/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoUsuario(usuario));
    }
    @GetMapping
    public Page<DadosListagemUsuario> listar(Pageable pageable) {
        return repository.findAll(pageable).map(DadosListagemUsuario::new);
    }
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoUsuario dados) {
        Usuario usuario = repository.getReferenceById(dados.id());
        usuario.atualizarInformacoes(dados);

        repository.save(usuario);
        //repository.updateTopicoColumnUserNameById(dados.userName(), dados.id());


        return ResponseEntity.ok(new DadosDetalhamentoUsuario(usuario));

    }
    @DeleteMapping(path = "/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable BigInteger id) {
        repository.deleteById(id);

        return ResponseEntity.notFound().build();
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity detalhar(@PathVariable BigInteger id) {
        Usuario usuario = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoUsuario(usuario));
    }
}
