create database DuckLibras
DEFAULT CHARACTER SET utf8mb4
DEFAULT COLLATE utf8mb4_general_ci;
use DuckLibras;

--aluno


Create table aluno(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(320) NOT NULL, 
    photo  BLOB,
    senha VARCHAR(255) NOT NULL,
    nivel int,
    ponto int,

FOREIGN KEY (id_bs) REFERENCES BS(id_bs),
FOREIGN KEY (id_flascard) REFERENCES FLASHCARD(id_flascard),
FOREIGN KEY (id_anotaccao) REFERENCES ANOTACOES(id_anotaccao)
);





--boardSquare
--FlashCards
--Anotacoes 
--Aulas 


CREATE TABLE FLASHCARD(
     id_flashcard INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
     ponto INT,
     quest VARCHAR(255) NOT NULL,
     sinais string (255)
     
);
-----TABELA AULA-------------------------
create table aulas
(
id_aula primary key ,
id_usuario int(10) unique not null,
idsinal  primary key varchar(20),
explicaçao text(255),
id_videos int(4) not null,
atividades  text(500),
resumo text(500),
nivel_id int(5) not null,
resultado int(10)
);
 --idsinal identificação dos sinais passados.
--id_aula é a identificação das aulas.
--id_usuario é a identificação do usuário.
--id_videos é a identificação dos vídeos nas aulas.
--id_nivel é a identificação dos squareboard e seus níveis.
--explicação é o texto que vai ter em cada atividade.
--resumo vai ter em todas em squaresboard e dicas.
--resultado é das atividades e provas para passar para o próximo nível.
-

create table videos(

id_videos int(4) not null,
videos mp4 ,
descricao text(255),
categoria_video text(32),
id_categoria int not null
);

--id_videos é a identificação dos vídeos nas aulas.
--videos serão passados as respectivas aulas.
--descricao dos videos para leitura.
--categoria_video ex:categoria cumprimento sinal: olá!
--id_categoria identificação das categorias.

create table sinal(

   idsinal primary key not null,
   nome varchar(30) not null,
   video mp4 ,
   descricao text(255),
   id_categoria primary key int not null
);


--idsinal identificação dos sinais passados.
--nome dos sinais.
--video onde será passado os sinais.
--descricao dos sinais.
--id_categoria identificação da categoria.

create table categorias(
    id_categoria primary key,
    nome varchar(255),
    categoria_video  text(255)

);

--id_categoria identificação da categoria.
--nome da categoria.
--categoria_video ex:categoria cumprimento sinal: olá!

create table perguntas(
    id_pergunta primary key,
    id_quiz primary key,
    pergunta varchar(255),
    respostacorreta varchar(20)
);

--id_pergunta identificação da pergunta.
--id_quiz identificação do quiz.
--pergunta para as atividades das aulas.
--respostacorreta onde terá o gabarito do quiz.


--Tabela Anotações 
CREATE TABLE Anotacoes (
    id_anotacao INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    conteudo TEXT NOT NULL,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
 

--Tradução
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

Create table BS(

    id_bs INT(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    STATUS BOOLEAN NOT NULL,
    FOREIGN KEY (id_aulas) REFERENCES AULAS(id_aulas),
    FOREIGN KEY (id_flashcard) REFERENCES FLASHCARD(id_flashcard)
);
 





