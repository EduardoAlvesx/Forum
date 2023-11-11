package com.eduardoalves.forum.controller;

import com.eduardoalves.forum.domain.topico.*;
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
import java.time.LocalDateTime;

@RestController
@RequestMapping("/topico")
public class TopicoController {
    @Autowired
    private TopicoRepository repository;
    @Autowired
    private PostagemTopico postagemTopico;

    @PostMapping
    @Transactional
    public ResponseEntity postar(@RequestBody @Valid DadosPostagemTopico dadosTopico, UriComponentsBuilder builder) {
       var dto = postagemTopico.postar(dadosTopico);
       Topico topico = new Topico();;

       var uri = builder.path("topico/{id}").buildAndExpand(topico.getId()).toUri();
       return ResponseEntity.created(uri).body(dto);

    }
    @GetMapping
    public Page<DadosListagemTopico> listagem(Pageable pageable) {
        return repository.findAll(pageable).map(DadosListagemTopico::new);
    }
    @GetMapping("/cursos/{curso}")
    public Page<DadosListagemTopico> burscarPorCurso(@PathVariable String curso,  Pageable pageable) {
        return repository.findByCurso(curso, pageable).map(DadosListagemTopico::new);
    }
    @GetMapping("/ano/{ano}")
    public Page<DadosListagemTopico> burcarPorAno(@PathVariable LocalDateTime ano, Pageable pageable) {
        return repository.findByDataCriacao(ano, pageable).map(DadosListagemTopico::new);
    }
    @GetMapping("/{id}")
    public ResponseEntity detalhamento(@PathVariable BigInteger id) {
        var topico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoTopico dados) {
        Topico topico = repository.getReferenceById(dados.id());
        topico.atualizarInformacoes(dados);
        repository.save(topico);

        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable BigInteger id) {
        Topico topico = repository.getReferenceById(id);
        repository.delete(topico);

        return ResponseEntity.notFound().build();
    }
}
