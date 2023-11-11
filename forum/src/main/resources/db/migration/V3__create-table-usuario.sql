create table usuario (
    id bigint not null auto_increment,
    user_name varchar(300) not null unique,
    user_password varchar(300) not null,

    primary key (id)
);