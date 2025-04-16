create database DuckLibras
DEFAULT CHARACTER SET utf8mb4
DEFAULT COLLATE utf8mb4_general_ci;
use DuckLibras;

CREATE TABLE Dicionario_Libras (
    id INT(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    palavra VARCHAR(100) NOT NULL,
    traducao VARCHAR(100) NOT NULL,
    sinal VARCHAR(255) NOT NULL,
    imagem VARCHAR(255) NOT NULL,
    video_url VARCHAR(255) NOT NULL,
    descricao TEXT,
    categoria VARCHAR(50),
    dificuldade ENUM('Fácil', 'Médio', 'Difícil') DEFAULT 'Fácil'
  );

  CREATE TABLE Pontuacao (
    id INT(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    pontos INT DEFAULT 0,
    nivel INT DEFAULT 1,
    ultima_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

Create table FLASHCARD (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    quest VARCHAR(255) NOT NULL,
    Pid INT ,
    DICIOid INT ,
    FOREIGN KEY(Pid) REFERENCES pontuacao(id),
    FOREIGN KEY(DICIOid) REFERENCES Dicionario_Libras(id)
);

Create table aulas (
    ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    explicacao VARCHAR(255) NOT NULL,
    Pid INT ,
    DICIOid INT ,
    FOREIGN KEY(Pid) REFERENCES pontuacao(id),
    FOREIGN KEY(DICIOid) REFERENCES Dicionario_Libras(id)
);

Create table BS(
    id INT(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    STATUS BOOLEAN NOT NULL,
    auID int, 
    FlashID int,
    PonId int,
    FOREIGN KEY (PonId) REFERENCES pontuacao(id),
    FOREIGN KEY (auID) REFERENCES aulas(id),
    FOREIGN KEY (FlashID) REFERENCES FLASHCARD(id)
);

CREATE TABLE traducao (
    id INT PRIMARY KEY AUTO_INCREMENT,
    palavra VARCHAR(255) NOT NULL,
    dicioId INT ,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY(dicioId) REFERENCES Dicionario_Libras(id) ON DELETE CASCADE
);

CREATE TABLE anotacao (
    id INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    texto TEXT NOT NULL,
    dicioId INT,
    BSid INT,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (dicioId) REFERENCES Dicionario_Libras(id) ON DELETE SET NULL,
    FOREIGN KEY (BSid) REFERENCES BS(id) ON DELETE SET NULL
  );

create table loja(
    id int primary key auto_increment,
    produto varchar(255),
    preco varchar(255)
);

Create table aluno(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(320) NOT NULL, 
    photo VARCHAR(320),
    senha VARCHAR(255) NOT NULL,
    Anoid int,
    TradId int,
    BSid int,
    pontID int,
FOREIGN KEY (Anoid) REFERENCES anotacao(id),
FOREIGN KEY (TradId) REFERENCES traducao(id),
FOREIGN KEY (BSid) REFERENCES BS(id),
FOREIGN KEY (pontID) REFERENCES Pontuacao(id)
);

create table compra(
    id int primary key auto_increment,
    quantidade int,
    loja_id INT,
    ALID INT,
    foreign key (loja_id) references loja(id),
    foreign key (ALID) references aluno(id)
); 

create table chat(
    id int primary key auto_increment,
    mensagem text not null,
    remetente int,
    destinatario int,
    foreign key (remetente) references aluno(id),
    foreign key (destinatario) references aluno(id)
);

Create table FLASH_AL(
    id_flashcard int,
    id_aluno int,
    FOREIGN KEY (id_aluno) REFERENCES aluno(id),
    FOREIGN KEY (id_flashcard) REFERENCES FLASHCARD(id)
);

Create table AU_AL(
    id_aula int,
    id_aluno int,
    FOREIGN KEY (id_aula) REFERENCES aulas(id),
    FOREIGN KEY (id_aluno) REFERENCES aluno(id)
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

create table chat(
    id_c int primary key auto_increment,
    mensagem text not null,
    remetente int,
    destinatario int,
    foreign key (remetente) references usuario(id_aluno),
    foreign key (destinatario) references usuario(id_aluno)
);

create table loja(
    id_lol int primary key auto_increment,
    produto varchar(255),
    preco varchar(255)
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
    ID int primary key not null AUTO_INCREMENT,
    ajuda varchar(255),
    Fid INT ,
    Cid INT ,
    DICIOid INT,
    FOREIGN KEY (DICIOid) REFERENCES Dicionario_Libras (id),
    FOREIGN KEY(CID) REFERENCES compra(id),
    FOREIGN key (Fid) REFERENCES FLASHCARD(id)
);
