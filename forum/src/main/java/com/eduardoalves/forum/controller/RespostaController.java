package com.eduardoalves.forum.controller;

import com.eduardoalves.forum.domain.resposta.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/resposta")
public class RespostaController {
    @Autowired
    RespostaRepository repository;
    @Autowired
    PostagemResposta postagemResposta;
    @PostMapping
    @Transactional
    public ResponseEntity<RespostaDetailsDTO> postar(@RequestBody RespostaRequestDTO dados, UriComponentsBuilder builder) {
        var dto = postagemResposta.postar(dados);
        var resposta = new Resposta();
        var uri = builder.path("/resposta").buildAndExpand(resposta.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }
    @GetMapping
    public Page<RespostaResponseDTO> listar(Pageable pageable) {
        return repository.findAll(pageable).map(RespostaResponseDTO::new);
    }
}
