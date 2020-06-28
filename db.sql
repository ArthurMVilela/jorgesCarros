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
