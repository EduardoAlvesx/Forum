package com.eduardoalves.forum.domain.topico;

import com.eduardoalves.forum.domain.usuario.UsuarioRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
@Log
public class PostagemTopico {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    TopicoRepository topicoRepository;


    public DadosDetalhamentoTopico postar(DadosPostagemTopico dadosTopico) {

        var usuario = usuarioRepository.getReferenceById(dadosTopico.usuarioId());
        Topico topico = new Topico(
                null,
                dadosTopico.titulo(),
                dadosTopico.mensagem(),
                LocalDateTime.now(),
                false,
                usuario,
                usuario.getUserName(),
                dadosTopico.curso());

        topicoRepository.save(topico);
        return new DadosDetalhamentoTopico(topico);
    }

}
