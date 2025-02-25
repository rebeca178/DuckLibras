--aluno:Dhermeson 
--boardSquare(BS):rebeca
Create table BS(
    id INT(10) NOT NULL AUTO INCREMENT,
    STATUS BOOLEAN NOT NULL,
    FOREIGN KEY (id) REFERENCES aulas(id),
    FOREIGN KEY (id) REFERENCES FLASHCARD(id),
);
--FlashCards:Guilherme
--Anotacoes:Ana Clara
--Aulas:Manu 
