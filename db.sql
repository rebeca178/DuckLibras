--aluno
CREATE DATABASE aluno;
USE aluno;

Create table aluno(
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(320) NOT NULL, 
    photo  BLOB,
    senha VARCHAR(255) NOT NULL,
    nivel int,
    ponto int,

);

--boardSquare
--FlashCards
--Anotacoes 
--Aulas 