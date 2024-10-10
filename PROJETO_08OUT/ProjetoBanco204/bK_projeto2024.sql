--VAMOS CRIAR A TABELA CLIENTE
CREATE TABLE cliente(
	cod serial,
	nome varchar(50),
	CPF varchar(16),
	rua varchar(100),
	numero int,
	bairro varchar(80),
	estado char(2),
	telefone varchar(15),
	genero varchar(50),
	constraint pk_cliente primary key(cod)

);

insert into cliente (cod,nome,cpf,
  rua,numero,bairro, estado,
  telefone,genero) values ();