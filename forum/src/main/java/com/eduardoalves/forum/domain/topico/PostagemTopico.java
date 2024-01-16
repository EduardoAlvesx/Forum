package com.eduardoalves.forum.domain.topico;

import com.eduardoalves.forum.domain.usuario.UsuarioRepository;
import com.eduardoalves.forum.infra.security.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class PostagemTopico {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private CurrentUser currentUser;

    public TopicoDetailsDTO postar(TopicoRequestDTO dataTopico) {
        var currentUser = this.currentUser.getAuthentication().getName();
        var id = usuarioRepository.getIdByUserName(currentUser);
        var usuario = usuarioRepository.getReferenceById(id);
        var topico = new Topico(
                null,
                dataTopico.titulo(),
                dataTopico.mensagem(),
                LocalDateTime.now(),
                false,
                usuario,
                dataTopico.curso(),
                0L);

        this.topicoRepository.save(topico);
        return new TopicoDetailsDTO(topico);
    }
}
