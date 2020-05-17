create table ordem_servico(
 id bigint not null auto_increment,
 cliente_id bigint not null,
 descricao varchar(20) not null,
 preco decimal(10,2) not null,
 status varchar(20) not null,
 data_abertura datetime not null,
 data_fechamento datetime ,
 constraint pk_order primary key (id),
 constraint fk_cli foreign key (cliente_id) references cliente(id)
)