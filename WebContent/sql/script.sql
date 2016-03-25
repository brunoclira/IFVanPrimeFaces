CREATE DATABASE IFVan;
use IFVan;
drop table van;
drop table cliente;     

CREATE TABLE cliente(
	nome VARCHAR(50),
	sobrenome VARCHAR(50),
	cpf VARCHAR(50),
	sexo VARCHAR(50),
	telefone VARCHAR(50),
	cidade VARCHAR(50),
	estado VARCHAR(50),
	PRIMARY KEY (cpf)
);

create table van(
	cadeira INT PRIMARY KEY,
	cpf_id VARCHAR(50),
	estado VARCHAR(50),
	tipo_passagem VARCHAR(50),
	valor VARCHAR(50)
);

create table fatura(
	nome_cliente VARCHAR(60),
    cpf_cliente VARCHAR(15),
    valor INT,
    cadeira INT PRIMARY KEY
);

create table usuarios(
	nome VARCHAR(50),
	usuario VARCHAR(50),
	email VARCHAR(50),
	senha VARCHAR(50)
);



insert into van (cadeira,cpf_id,estado,tipo_passagem,valor) values(1, " ", "free","","");
insert into van (cadeira,cpf_id,estado,tipo_passagem,valor) values(2, " ", "free","","");
insert into van (cadeira,cpf_id,estado,tipo_passagem,valor) values(3, " ", "free","","");
insert into van (cadeira,cpf_id,estado,tipo_passagem,valor) values(4, " ", "free","","");
insert into van (cadeira,cpf_id,estado,tipo_passagem,valor) values(5, " ", "free","","");
insert into van (cadeira,cpf_id,estado,tipo_passagem,valor) values(6, " ", "free","","");
insert into van (cadeira,cpf_id,estado,tipo_passagem,valor) values(7, " ", "free","","");
insert into van (cadeira,cpf_id,estado,tipo_passagem,valor) values(8, " ", "free","","");
insert into van (cadeira,cpf_id,estado,tipo_passagem,valor) values(9, " ", "free","","");
insert into van (cadeira,cpf_id,estado,tipo_passagem,valor) values(10, "", "free","","");

SELECT * FROM cliente;
SELECT * FROM van;
DELETE FROM cliente WHERE cpf = '222.222.222-22';
DELETE FROM van WHERE cadeira = '1';
/* NAO APAGAR,,....
>>>>>>> origin/master

UPDATE van SET cpf_id= "1212",estado='false' WHERE cadeira=1;


INSERT INTO cliente(nome,sobrenome,cpf,sexo,telefone,cidade,estado)values('leo','silva','108755','M','87417540','campina','paraiba');
SELECT * FROM cliente;
SELECT V.estado FROM van V WHERE V.cadeira=1; 


DELETE FROM cliente WHERE cpf = '108755';


UPDATE van SET cpf_id='',cadeira='false' WHERE id=;



FOREIGN KEY (cpf_id) references cliente (cpf)




ALTER TABLE van ADD CONSTRAINT FK_cpf_cliente 
FOREIGN KEY (cpf_id) references cliente (cpf);
*/
