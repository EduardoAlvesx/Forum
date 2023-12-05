package com.eduardoalves.forum.domain.topico;

import com.eduardoalves.forum.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class PostagemTopico {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    TopicoRepository topicoRepository;


    public TopicoDetailsDTO postar(TopicoRequestDTO dadosTopico) {
        var usuario = usuarioRepository.getReferenceById(dadosTopico.usuarioId());
        var topico = new Topico(
                null,
                dadosTopico.titulo(),
                dadosTopico.mensagem(),
                LocalDateTime.now(),
                false,
                usuario,
                usuario.getUsername(),
                dadosTopico.curso(),
                0L);

        topicoRepository.save(topico);
        return new TopicoDetailsDTO(topico);
    }
}
