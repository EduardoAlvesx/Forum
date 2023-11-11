package com.eduardoalves.forum.controller;

import com.eduardoalves.forum.domain.resposta.DadosPostagemResposta;
import com.eduardoalves.forum.domain.resposta.PostagemResposta;
import com.eduardoalves.forum.domain.resposta.Resposta;
import com.eduardoalves.forum.domain.resposta.RespostaRepository;
import com.eduardoalves.forum.domain.topico.Topico;
import com.eduardoalves.forum.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resposta")
public class RespostaController {
    @Autowired
    RespostaRepository repository;
    @Autowired
    PostagemResposta postagemResposta;
    @PostMapping
    @Transactional
    public void postar(@RequestBody DadosPostagemResposta dados) {
        postagemResposta.postar(dados);
//        repository.atualizarColunaStatusTopico(dados.topicoId());
    }
}
