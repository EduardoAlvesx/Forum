package com.eduardoalves.forum.controller;

import com.eduardoalves.forum.domain.resposta.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigInteger;

@RestController
@RequestMapping("/resposta")
public class RespostaController {
    @Autowired
    RespostaRepository repository;
    @Autowired
    PostagemResposta postagemResposta;
    @PostMapping
    @Transactional
    public ResponseEntity<RespostaDetailsDTO> postar(@RequestBody RespostaRequestDTO dados, UriComponentsBuilder uriBuilder) {
        var dto = postagemResposta.postar(dados);
        var resposta = new Resposta();
        var uri = uriBuilder.path("/resposta").buildAndExpand(resposta.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    @GetMapping
    public Page<RespostaResponseDTO> listar(Pageable pageable) {
        return repository.findAll(pageable).map(RespostaResponseDTO::new);
    }
    @PatchMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody RespostaUpdateDTO dados) {
        var resposta = repository.getReferenceById(dados.id());
        resposta.atualizarInformacoes(dados);
        repository.save(resposta);

        return ResponseEntity.ok().build();
    }
    @DeleteMapping(path = "/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable BigInteger id) {
        repository.deleteById(id);

        return ResponseEntity.notFound().build();
    }
}
