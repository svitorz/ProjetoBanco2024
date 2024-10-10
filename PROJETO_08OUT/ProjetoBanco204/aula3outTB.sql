create table marcas(
	codigom int,
	nomem varchar(20),
	paisorigem varchar(30),
	constraint pk_marcas 
	  primary key(codigom)
);

--vamos inserir alguns registros
insert into marcas values
 	(1012,'VolksWagen','Brasil'),
	(1013,'Fiat','Brasil'),
	(1014,'Audi','Alemanha'),
	(1015,'Chevrolet','Brasil'),
	(1016,'Chevrolet','USA');
	
	--verificar se foram inseridas
	select * from marcas;
	
--vamos criar a tabela modelo
create table modelo(
	codigomo int,
	nomemo varchar(20),
	tipomo varchar(5),
	cormo varchar(20),
	codigom int,
	--chave primária
	constraint pk_modelo 
	  primary key (codigomo),
	--chave estrangeira
	constraint fk_marca_modelo
	  foreign key(codigom)
	  references marcas
);

--vamos inserir registros
insert into modelo values
  (101,'Gol','GT','Cinza',1012),
  (102,'Pálio','XS','Preto',1013),
  (103,'Zafira','GLS','Verde',1015),
  (104,'Linea','GL','Cinza',1013),
  (105,'A2','GT','Preto',1014),
  (106,'Polo','GL','Cinza',1012),
  (107,'Taurus','XLS','Preto',1016);
  
  --Qual a cor do carro Zafira?
  select modelo.cormo, modelo.nomemo
   from modelo inner join marcas on 
   marcas.codigom=modelo.codigom
   where modelo.nomemo='Zafira';
   
  --Qual o país de origem da VolksWagen?
  
  --Qual o país de origem do carro Taurus?
  select marcas.paisorigem,modelo.nomemo
   from marcas inner join modelo on
   marcas.codigom=modelo.codigom
   where modelo.nomemo='Taurus';
   
 --Qual o nome dos modelos de carros
 --que são produzidos no Brasil?
 select modelo.nomemo,marcas.paisorigem
  from modelo inner join marcas on
  modelo.codigom=marcas.codigom
  where marcas.paisorigem='Brasil';
  
  
  
  