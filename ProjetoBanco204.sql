CREATE TABLE cliente(
	cod serial,
	nome varchar(50),
	cpf varchar(16),
	rua varchar(100),
	numero int,
	bairro varchar(80),
	estado char(2),
	telefone varchar(15),
	genero varchar(50),
	constraint pk_clientes primary key(cod)
);
