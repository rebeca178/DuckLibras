

create table aulas
(
id_aulas int(10) PRIMARY KEY unique not null AUTO_INCREMENT,
sinal varchar(20),
explicaçao text(255),
videos text(255),
nivel  int(5) not null,
status BOOLEAN
);



