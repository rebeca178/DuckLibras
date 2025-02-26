create database DuckLibras
DEFAULT CHARACTER SET utf8mb4
DEFAULT COLLATE utf8mb4_general_ci;
use DuckLibras;

CREATE TABLE FLASHCARD(
     id_flashcard INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
     ponto INT,
     quest VARCHAR(255) NOT NULL,
     sinais VARCHAR(255) 
     
);

CREATE TABLE Anotacoes (
    id_anotacao INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    conteudo TEXT NOT NULL,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    sinais VARCHAR(255) ,
    explicacao TEXT NOT NULL
);

CREATE TABLE Traducao_Libras (
    id_tradu INT PRIMARY KEY AUTO_INCREMENT, 
    palavra VARCHAR(255) NOT NULL, 
    sinal VARCHAR(255) NOT NULL, 
    imagem BLOB NULL, 
    explicacao TEXT NOT NULL, 
    status BOOLEAN NOT NULL DEFAULT FALSE, 
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

create table aulas(
    id_aula INT PRIMARY KEY AUTO_INCREMENT,
    id_usuario int(10) unique not null,
    idsinal varchar(20),
    explicaçao text(255),
    id_videos int(4) not null,
    atividades  text(500),
    resumo text(500),
    nivel_id int(5) not null,
    resultado int(10),
    id_pergunta int,
    id_quiz int,
    pergunta varchar(255),
     respostacorreta varchar(20)
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
