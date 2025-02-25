

--aluno


Create table aluno(
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(320) NOT NULL, 
    photo  BLOB,
    senha VARCHAR(255) NOT NULL,
    nivel int,
    ponto int,

FOREIGN KEY (id_bs) REFERENCES BS(id_bs),
FOREIGN KEY (id_flascard) REFERENCES FLASHCARD(id_flascard),
FOREIGN KEY (id_anotaccao) REFERENCES ANOTACOES(id_anotaccao),
);



--boardSquare
--FlashCards
--Anotacoes 
--Aulas 


CREATE TABLE FLASHCARD(
     id_flashcard INT NOT NULL AUTO_INCREMENT,
     ponto INT,
     quest VARCHAR(255) NOT NULL,
     sinais string (255),
     
);


create table aulas
(
id_aulas int(10) unique not null,
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
    id_anotacao INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    conteudo TEXT NOT NULL,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
 
--boardSquare(BS):rebeca

--FlashCards:Guilherme
--Anotacoes:Ana Clara
--Aulas:Manu 

--Tradução
CREATE TABLE Traducao_Libras (
    id INT PRIMARY KEY AUTO_INCREMENT, 
    palavra VARCHAR(255) NOT NULL, 
    sinal VARCHAR(255) NOT NULL, 
    imagem BLOB NULL, 
    explicacao TEXT NOT NULL, 
    status BOOLEAN NOT NULL DEFAULT FALSE, 
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB;

Create table BS(
    id_bs INT(10) NOT NULL AUTO INCREMENT,
    STATUS BOOLEAN NOT NULL,
    FOREIGN KEY (id_aulas) REFERENCES AULAS(id_aulas),
    FOREIGN KEY (id_flashcard) REFERENCES FLASHCARD(id_flashcard),
);
 





