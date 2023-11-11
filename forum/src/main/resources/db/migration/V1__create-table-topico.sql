create table topico (
    id bigint not null auto_increment,
    titulo varchar(150) not null unique,
    mensagem varchar(500) not null unique,
    data_criacao timestamp default current_timestamp not null,
    status_topico bit(1) default 0,
    autor varchar(100) not null,
    curso varchar(100) not null,

    primary key(id)
);