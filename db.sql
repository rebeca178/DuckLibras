
Create table aluno(
    id_Aluno INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(320) NOT NULL, 
    photo  VARCHAR(320),
    senha VARCHAR(255) NOT NULL,
    nivel int,
    ponto int,
	id_bs int,
    id_flashcard int,
    id_anotacao int,
    id_chat int,
    id_loja int,
    id_cop int,
    id_traducao int,
    id_aulas int,
FOREIGN KEY (id_bs) REFERENCES BS(id_bs),
FOREIGN KEY (id_flashcard) REFERENCES FLASHCARD(id_flashcard),
FOREIGN KEY (id_anotacao) REFERENCES Anotacoes(id_anotacao),
FOREIGN KEY (id_chat) REFERENCES ChatBOT(id_chat),
FOREIGN KEY (id_loja) REFERENCES LOJA(id_loja),
FOREIGN KEY (id_cop) REFERENCES COMPRAS(id_cop),
FOREIGN KEY (id_traducao) REFERENCES TRADUÇÃO(id_traducao),
FOREIGN KEY (id_aulas) REFERENCES Aulas(id_aulas),



create database DuckLibras
DEFAULT CHARACTER SET utf8mb4
DEFAULT COLLATE utf8mb4_general_ci;
use DuckLibras;

CREATE TABLE Dicionario_Libras (
    id_dicionario SERIAL PRIMARY KEY,
    palavra VARCHAR(100) NOT NULL,
    traducao VARCHAR(100) NOT NULL,
    sinal VARCHAR(255) NOT NULL,
    imagem VARCHAR(255) NOT NULL,
    video_url VARCHAR(255) NOT NULL,
    descricao TEXT,
    categoria VARCHAR(50),
    dificuldade ENUM('Fácil', 'Médio', 'Difícil') DEFAULT 'Fácil',
  );
  
  CREATE TABLE Pontuacao (
    id_pontuacao SERIAL PRIMARY KEY,
    id_usuario INT NOT NULL,
    pontos INT DEFAULT 0,
    nivel INT DEFAULT 1,
    ultima_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id)
);

CREATE TABLE traducao (
    id_traducao INT PRIMARY KEY AUTO_INCREMENT,
    palavra VARCHAR(255) NOT NULL,
    sinal VARCHAR(255) NOT NULL,
    imagem VARCHAR(500),
    explicacao TEXT NOT NULL,
    status BOOLEAN NOT NULL DEFAULT FALSE,
    usuario_id INT NOT NULL,
    dicionario_id INT NOT NULL,
    palavra_id INT,
    video_id INT,
    sinal_id INT,
    flashcard_id INT,
    boardsquare_id INT,
    anotacao_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (usuario_id) REFERENCES aluno(id) ON DELETE CASCADE,
    FOREIGN KEY (dicionario_id) REFERENCES dicionario(id) ON DELETE CASCADE,
    FOREIGN KEY (palavra_id) REFERENCES palavras(id) ON DELETE SET NULL,
    FOREIGN KEY (video_id) REFERENCES videos(id) ON DELETE SET NULL,
    FOREIGN KEY (sinal_id) REFERENCES sinais(id) ON DELETE SET NULL,
    FOREIGN KEY (flashcard_id) REFERENCES flashcards(id_flashcard) ON DELETE SET NULL,
    FOREIGN KEY (boardsquare_id) REFERENCES boardsquare(id_bs) ON DELETE SET NULL,
    FOREIGN KEY (anotacao_id) REFERENCES anotacao(id_anotacao) ON DELETE SET NULL
);

CREATE TABLE anotacao (
    id_anotacao INT PRIMARY KEY AUTO_INCREMENT,
    usuario_id INT NOT NULL,
    titulo VARCHAR(255) NOT NULL,
    texto TEXT NOT NULL,
    imagem VARCHAR(500),
    dicionario_id INT,
    palavra_id INT,
    video_id INT,
    sinal_id INT,
    flashcard_id INT,
    boardsquare_id INT,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (usuario_id) REFERENCES aluno(id) ON DELETE CASCADE,
    FOREIGN KEY (dicionario_id) REFERENCES dicionario(id) ON DELETE SET NULL,
    FOREIGN KEY (palavra_id) REFERENCES palavras(id) ON DELETE SET NULL,
    FOREIGN KEY (video_id) REFERENCES videos(id) ON DELETE SET NULL,
    FOREIGN KEY (sinal_id) REFERENCES sinais(id) ON DELETE SET NULL,
    FOREIGN KEY (flashcard_id) REFERENCES flashcards(id_flashcard) ON DELETE SET NULL,
    FOREIGN KEY (boardsquare_id) REFERENCES boardsquare(id_bs) ON DELETE SET NULL
  );

Create table FLASHCARD (
    ID_FLASHCARD INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    quest VARCHAR(255) NOT NULL,
    Pid INT NOT NULL,
    DICIOid INT NOT NULL,
    DICASid INT NOT NULL,
    FOREIGN KEY(Pid) REFERENCES pontuacao(id_pontucao),
    FOREIGN KEY (DICIOid) REFERENCES Dicionario_Libras (id_dicionario),
    FOREIGN key (DICASid) REFERENCES Dicas(id_dicas),
);
  
create table Dicas (
    ID_dicas int primary key not null AUTO_INCREMENT,
    ajuda varchar(255),
    Fid INT NOT NULL,
    Cid INT NOT NULL,
    DICIOid INT NOT NULL,
    FOREIGN KEY (DICIOid) REFERENCES Dicionario_Libras (id_dicionario),
    FOREIGN KEY(CID) REFERENCES compras(id_cop),
    FOREIGN key (Fid) REFERENCES FLASHCARD(id_flashcard)
);

Create table FLASH_AL(
    id_flashcard int,
    id_aluno int,
    FOREIGN KEY (id_aluno) REFERENCES aluno(id_aluno),
    FOREIGN KEY (id_flashcard) REFERENCES FLASHCARD(id_flashcard)
);

Create table AU_AL(
    id_flashcard int,
    id_aluno int,
    FOREIGN KEY (id_aula) REFERENCES aulas(id_aula),
    FOREIGN KEY (id_aluno) REFERENCES aluno(id_aluno)
);
  
Create table BS(
    id_bs INT(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    STATUS BOOLEAN NOT NULL,
    nivel int,
    id_aula int, 
    id_flashcard int,
    id_pontuacao int,
    CONSTRAINT fk_nivel FOREIGN KEY (nivel) REFERENCES pontuacao(nivel),
    FOREIGN KEY (id_pontuacao) REFERENCES pontuacao(id_pontuacao),
    FOREIGN KEY (id_aula) REFERENCES aulas(id_aula),
    FOREIGN KEY (id_flashcard) REFERENCES FLASHCARD(id_flashcard)
);
