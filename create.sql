create table perfil (id integer not null, nome varchar(255), primary key (id))
create table cargo (id integer not null, nome varchar(255), primary key (id))
create table pessoa (id bigint not null, nome varchar(255), sexo varchar(2), cpf varchar(50), aniversario timestamp, primary key (id));