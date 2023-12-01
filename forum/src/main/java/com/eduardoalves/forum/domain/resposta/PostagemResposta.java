package com.eduardoalves.forum.domain.resposta;

import com.eduardoalves.forum.domain.topico.Topico;
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
    public RespostaDetailsDTO postar(RespostaRequestDTO dados) {
       var usuario = usuarioRepository.getReferenceById(dados.usuarioId());
       var topico = topicoRepository.getReferenceById(dados.topicoId());
       var resposta = new Resposta(null, topico, usuario, dados.resolucao());
       respostaRepository.save(resposta);

       setStausTopico(topico);
       return new RespostaDetailsDTO(resposta);
    }

    // a cada resposta de um usuario referente a um topico, o status daquele topico passa a ser true
    private void setStausTopico(Topico topico) {
        topico.setStatusTopico(true);
    }
}
