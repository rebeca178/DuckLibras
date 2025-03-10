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

create table aulas (
id_aulas int(10) PRIMARY KEY unique not null AUTO_INCREMENT,
sinal varchar(500) not null,
explicaçao text(255) not null,
videos text(255) not null,
nivel  int(255) not null,
status BOOLEAN,
id_traduçao int not null
FOREIGN KEY (id_traduçao) REFERENCES traduçao(id_traduçao)
);