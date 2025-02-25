

CREATE TABLE FLASHCARD(
     id INT NOT NULL AUTO_INCREMENT,
     ponto INT,
     quest VARCHAR(255) NOT NULL,
     sinais string (255),
     
);


create table aulas
(
id_usuario int(10) unique not null,
sinal varchar(20),
explicaçao text(255),
id_videos int(4) not null,
atividades  text(500),
resumo text(500),
nivel_id int(5) not null,
resultado number ,
);



--id_usuario é a identificação do usuário.
--id_videos é a identificação dos vídeos nas aulas.
--id_nivel é a identificação dos squareboard e seus níveis.
--explicação é o texto que vai ter em cada atividade.
--resumo vai ter em todas em squaresboard e dicas.
--resultado é das atividades e provas para passar para o próximo nível.

--Tabela Anotações 
CREATE TABLE Anotacoes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    conteudo TEXT NOT NULL,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
 
--boardSquare(BS):rebeca
Create table BS(
    id INT(10) NOT NULL AUTO INCREMENT,
    STATUS BOOLEAN NOT NULL,
    FOREIGN KEY (id) REFERENCES aulas(id),
    FOREIGN KEY (id) REFERENCES FLASHCARD(id),
);
 



