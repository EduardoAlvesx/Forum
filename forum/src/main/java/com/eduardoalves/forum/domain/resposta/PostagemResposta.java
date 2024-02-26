package com.eduardoalves.forum.domain.resposta;

import com.eduardoalves.forum.domain.topico.Topico;
import com.eduardoalves.forum.domain.topico.TopicoRepository;
import com.eduardoalves.forum.domain.usuario.UsuarioRepository;
import com.eduardoalves.forum.infra.security.AuthenticatedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostagemResposta {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private RespostaRepository respostaRepository;
    @Autowired
    private AuthenticatedUser authenticatedUser;
    public RespostaDetailsDTO postar(RespostaRequestDTO dados) {
        var authenticatedUser = this.authenticatedUser.getAuthentication().getName();
        var id = usuarioRepository.getIdByUserName(authenticatedUser);
        var usuario = usuarioRepository.getReferenceById(id);
        var topico = topicoRepository.getReferenceById(dados.topicoId());
        var resposta = new Resposta(null, topico, usuario, dados.resolucao());

        respostaRepository.save(resposta);
        setStausTopico(topico);
        setTotalRespostas(topico);
        return new RespostaDetailsDTO(resposta);
    }

    private void setTotalRespostas(Topico topico) {
        var totalRespostas = respostaRepository.countByTopicoId(topico.getId());
        topico.setTotalRespostas(totalRespostas);
    }

    // a cada resposta de um usuario referente a um topico, o status daquele topico passa a ser true
    private void setStausTopico(Topico topico) {
        topico.setStatusTopico(true);
    }
}
