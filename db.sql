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
    
FOREIGN KEY (id) REFERENCES boardSquare(id),
FOREIGN KEY (id) REFERENCES FLASHCARD(id),
);

--boardSquare
--FlashCards
--Anotacoes 
--Aulas 