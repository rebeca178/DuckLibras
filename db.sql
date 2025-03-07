create database DuckLibras
DEFAULT CHARACTER SET utf8mb4
DEFAULT COLLATE utf8mb4_general_ci;
use DuckLibras;


create table aulas (
id_aulas int(10) PRIMARY KEY unique not null AUTO_INCREMENT,
sinal varchar(500),
explicaçao text(255),
videos text(255),
nivel  int(255) not null,
status BOOLEAN
FOREIGN KEY (id_traduçao) REFERENCES traduçao(id_traduçao)
);


Create table BS(

    id_bs INT(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    STATUS BOOLEAN NOT NULL,
    id_aula int, 
    id_flashcard int,
    FOREIGN KEY (id_aula) REFERENCES aulas(id_aula),
    FOREIGN KEY (id_flashcard) REFERENCES FLASHCARD(id_flashcard)
);

Create table aluno(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(320) NOT NULL, 
    photo  BLOB,
    senha VARCHAR(255) NOT NULL,
    nivel int,
    ponto int,
	id_bs INT,
    id_flashcard INT,
    id_anotacao INT,

FOREIGN KEY (id_bs) REFERENCES BS(id_bs),
FOREIGN KEY (id_flashcard) REFERENCES FLASHCARD(id_flashcard),
FOREIGN KEY (id_anotacao) REFERENCES Anotacoes(id_anotacao)
);
