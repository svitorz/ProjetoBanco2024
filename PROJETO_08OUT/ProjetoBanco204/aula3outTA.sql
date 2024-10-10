--Hoje vamos ver como criar relacionamento
--entre duas tabelas utilizando o conceito
--de chaves estrangeiras.
--As chaves estrangeiras permitem que 
--haja integridade entre as tabelas.

--vamos criar a primeira tabela

create table marcas(
	codigom int,
	nomem varchar(20),
	paisorigem varchar(30),
	constraint pk_marcas 
	 primary key(codigom)
);

--vamos inserir registros
insert into marcas values
 (1012,'VolksWagen','Brasil'),
 (1013,'Fiat','Brasil'),
 (1014,'Audi','Alemanha'),
 (1015,'Chevrolet','Brasil'),
 (1016,'Chevrolet','USA');
 
 --vamos criar a tabela de modelos
 create table modelos(
 	 codigomo int,
	 nomemo varchar(20),
	 tipomo varchar(5),
	 cormo varchar(20),
	 codigom int,
	 --chave primária
	 constraint pk_modelo
	  primary key(codigomo),
	 --chave estrangeira
	 constraint fk_modelo_marca
	  foreign key(codigom)
	  references marcas
 );
 
 --vamos inserir os registros
 insert into modelos values
  (101,'Gol','GT','Cinza',1012),
  (102,'Pálio','XS','Preto',1013),
  (103,'Zafira','GLS','Verde',1015),
  (104,'Linea','GL','Cinza',1013),
  (105,'A3','GT','Preto',1014),
  (106,'Polo','GL','Cinza',1012),
  (107,'Taurus','XLS','Preto',1016);
  
--vamos fazer uma pergunta que envolva
--as duas tabelas
--1)Quais são os modelos de carros
--produzidos na Alemanha?
select modelos.nomemo,marcas.paisorigem
 from modelos inner join marcas on
 marcas.codigom=modelos.codigom
 where marcas.paisorigem='Alemanha';
 

