create table cliente (
	id bigint not null auto_increment,
    nome varchar(255) not null,
    email varchar(255) not null,
    telefone varchar(20) not null,
    
    constraint pk_id primary key (id)
)