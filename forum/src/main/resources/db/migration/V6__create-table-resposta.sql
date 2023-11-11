create table resposta (
    id bigint not null auto_increment,
    usuario_id bigint not null,
    topico_id bigint not null,
    resolucoes varchar(1000) not null,

    primary key(id),

    constraint fk_topico_resposta_id foreign key(topico_id) references topico (id),
    constraint fk_usuario_resposta_id foreign key(usuario_id) references usuario (id)
);