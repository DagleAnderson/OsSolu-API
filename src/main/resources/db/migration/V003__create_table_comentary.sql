create table comentario (
id bigint not null auto_increment,
ordem_servico_id bigint not null,
descricao Text not null ,
data_env datetime not null,

constraint pk_coment primary key (id),
constraint fk_ord foreign key (ordem_servico_id) references ordem_servico(id) 
)

