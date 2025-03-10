create database DuckLibras
DEFAULT CHARACTER SET utf8mb4
DEFAULT COLLATE utf8mb4_general_ci;
use DuckLibras;


create table aulas (
id_aulas int(10) PRIMARY KEY unique not null AUTO_INCREMENT,
sinal varchar(500) not null,
explicaçao text(255) not null,
videos text(255) not null,
nivel  int(255) not null,
status BOOLEAN,
id_traduçao int not null
FOREIGN KEY (id_traduçao) REFERENCES traduçao(id_traduçao)
);