package com.eduardoalves.forum.domain.resposta;

import com.eduardoalves.forum.domain.topico.DadosPostagemTopico;
import com.eduardoalves.forum.domain.topico.TopicoRepository;
import com.eduardoalves.forum.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostagemResposta {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    TopicoRepository topicoRepository;
    @Autowired
    RespostaRepository respostaRepository;
    public void postar(DadosPostagemResposta dados) {
       var usuario = usuarioRepository.getReferenceById(dados.usuarioId());
       var topico = topicoRepository.getReferenceById(dados.topicoId());

       Resposta resposta = new Resposta(null, topico, usuario, dados.resolucao());
       respostaRepository.save(resposta);

       topico.setStatusTopico(true);
    }
}
