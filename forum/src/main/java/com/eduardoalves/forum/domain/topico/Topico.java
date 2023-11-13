package com.eduardoalves.forum.domain.topico;

import com.eduardoalves.forum.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Table(name = "topico")
@Entity(name = "Topico")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private boolean statusTopico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario autor;
    private String autorUsuario;
    private String curso;

    public void atualizarInformacoes(DadosAtualizacaoTopico dados) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.curso = dados.curso();
    }
}
