CREATE DATABASE jorgescarros;

USE jorgescarros;

CREATE TABLE carro (
	codigo int(6) auto_increment primary key,
	placa char(7),
	renavam char(9),
	status int(2),
	categoria int(2),
	tipo_motor int(2),
	cor int(2),
	modelo varchar(30),
	ano int,
	marca varchar(20),
	km_litro float(2,2),
	volume_tanque int,
	ar_condicionado int(1),
	gps int(1),
	direcao_automatica int(1),
	radio_bluetooth int(1)
);

CREATE TABLE entrada (
	codigo int(6) auto_increment primary key,
	motivo varchar(15),
	horario TIMESTAMP
	
);

CREATE TABLE saida (
	codigo int(6) auto_increment primary key,
	motivo varchar(15),
	horario TIMESTAMP
	
);

/*PACOTE CLIENTE*/
create table endereco (
	codendereco int auto_increment primary key,
	cep varchar(7),
	cidade varchar(20),
	estado varchar(2),
	bairro varchar(20),
	numero int, 
	complemento varchar(20),
	logradouro varchar(20)
);

create table cliente (
	cpf varchar(11) primary key,
	rg varchar(9),
	nome varchar(20),
	cnh varchar(11),
	datanasc DATE,
	codendereco int,
	FOREIGN KEY(codendereco) REFERENCES endereco(codendereco)
);
