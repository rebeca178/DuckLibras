create database DuckLibras
DEFAULT CHARACTER SET utf8mb4
DEFAULT COLLATE utf8mb4_general_ci;
use DuckLibras;

CREATE TABLE Dicionario_Libras (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
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
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    pontos INT DEFAULT 0,
    nivel INT DEFAULT 1,
    ultima_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
);

Create table FLASHCARD (
    ID_FLASHCARD INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    quest VARCHAR(255) NOT NULL,
    Pid INT NOT NULL,
    DICIOid INT NOT NULL,
    FOREIGN KEY(Pid) REFERENCES pontuacao(id_pontucao),
    FOREIGN KEY (DICIOid) REFERENCES Dicionario_Libras (id_dicionario),
);

Create table aulas (
    ID_aula INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    explicacao VARCHAR(255) NOT NULL,
    Pid INT NOT NULL,
    DICIOid INT NOT NULL,
    FOREIGN KEY(Pid) REFERENCES pontuacao(id_pontucao),
    FOREIGN KEY (DICIOid) REFERENCES Dicionario_Libras (id_dicionario),
);

Create table BS(
    id_bs INT(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    STATUS BOOLEAN NOT NULL,
    id_aula int, 
    id_flashcard int,
    id_pontuacao int,
    FOREIGN KEY (id_pontuacao) REFERENCES pontuacao(id_pontuacao),
    FOREIGN KEY (id_aula) REFERENCES aulas(id_aula),
    FOREIGN KEY (id_flashcard) REFERENCES FLASHCARD(id_flashcard)
);

CREATE TABLE traducao (
    id_traducao INT PRIMARY KEY AUTO_INCREMENT,
    palavra VARCHAR(255) NOT NULL,
    dicionario_id INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (dicionario_id) REFERENCES dicionario(id) ON DELETE CASCADE
);

CREATE TABLE anotacao (
    id_anotacao INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    texto TEXT NOT NULL,
    dicionario_id INT,
    boardsquare_id INT,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (dicionario_id) REFERENCES dicionario(id) ON DELETE SET NULL,
    FOREIGN KEY (boardsquare_id) REFERENCES boardsquare(id_bs) ON DELETE SET NULL
  );

create table loja(
    id_lol int primary key auto_increment,
    produto varchar(255),
    preco varchar(255)
);

Create table aluno(
    id_Aluno INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(320) NOT NULL, 
    photo  VARCHAR(320),
    senha VARCHAR(255) NOT NULL,
    id_anotacao int,
    id_chat int,
    id_cop int,
    id_traducao int,
    id_BS int,
    id_pont int,
FOREIGN KEY (id_anotacao) REFERENCES Anotacoes(id_anotacao),
FOREIGN KEY (id_chat) REFERENCES ChatBOT(id_chat),
FOREIGN KEY (id_cop) REFERENCES COMPRAS(id_cop),
FOREIGN KEY (id_traducao) REFERENCES TRADUÇÃO(id_traducao),
FOREIGN KEY (id_BS) REFERENCES BS(id_BS),
FOREIGN KEY (id_pont) REFERENCES Pontuacao(id_pontuacao),
);

create table chat(
    id_c int primary key auto_increment,
    mensagem text not null,
    remetente int,
    destinatario int,
    foreign key (remetente) references usuario(id_aluno),
    foreign key (destinatario) references usuario(id_aluno)
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

create table compra(
    id_cop int primary key auto_increment,
    quantidade int,
    loja_id INT,
    ALID INT,
    foreign key (loja_id) references loja(lol),
    foreign key (ALID) references aluno(id_Aluno)
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
