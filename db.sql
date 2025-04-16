CREATE DATABASE DuckLibras
DEFAULT CHARACTER SET utf8mb4
DEFAULT COLLATE utf8mb4_general_ci;

USE DuckLibras;

CREATE TABLE Dicionario_Libras (
    id INT AUTO_INCREMENT PRIMARY KEY,
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
    id INT AUTO_INCREMENT PRIMARY KEY,
    pontos INT DEFAULT 0,
    nivel INT DEFAULT 1,
    ultima_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE FLASHCARD (
    id INT AUTO_INCREMENT PRIMARY KEY,
    quest VARCHAR(255) NOT NULL,
    Pid INT,
    DICIOid INT,
    FOREIGN KEY (Pid) REFERENCES Pontuacao(id),
    FOREIGN KEY (DICIOid) REFERENCES Dicionario_Libras(id)
);

CREATE TABLE aulas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    explicacao VARCHAR(255) NOT NULL,
    Pid INT,
    DICIOid INT,
    FOREIGN KEY (Pid) REFERENCES Pontuacao(id),
    FOREIGN KEY (DICIOid) REFERENCES Dicionario_Libras(id)
);

CREATE TABLE BS (
    id_bs INT AUTO_INCREMENT PRIMARY KEY,
    STATUS BOOLEAN NOT NULL,
    nivel_valor INT,
    id_aula INT,
    id_flashcard INT,
    id_pontuacao INT,
    FOREIGN KEY (id_pontuacao) REFERENCES Pontuacao(id),
    FOREIGN KEY (id_aula) REFERENCES aulas(id),
    FOREIGN KEY (id_flashcard) REFERENCES FLASHCARD(id)
);

CREATE TABLE traducao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    palavra VARCHAR(255) NOT NULL,
    dicioId INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (dicioId) REFERENCES Dicionario_Libras(id) ON DELETE CASCADE
);

CREATE TABLE anotacao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    texto TEXT NOT NULL,
    dicioId INT,
    BSid INT,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (dicioId) REFERENCES Dicionario_Libras(id),
    FOREIGN KEY (BSid) REFERENCES BS(id_bs)
);

CREATE TABLE aluno (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(320) NOT NULL,
    photo VARCHAR(320),
    senha VARCHAR(255) NOT NULL,
    Anoid INT,
    TradId INT,
    BSid INT,
    pontID INT,
    FOREIGN KEY (Anoid) REFERENCES anotacao(id),
    FOREIGN KEY (TradId) REFERENCES traducao(id),
    FOREIGN KEY (BSid) REFERENCES BS(id_bs),
    FOREIGN KEY (pontID) REFERENCES Pontuacao(id)
);

CREATE TABLE loja (
    id INT AUTO_INCREMENT PRIMARY KEY,
    produto VARCHAR(255),
    preco VARCHAR(255)
);

CREATE TABLE compra (
    id INT AUTO_INCREMENT PRIMARY KEY,
    quantidade INT,
    loja_id INT,
    ALID INT,
    FOREIGN KEY (loja_id) REFERENCES loja(id),
    FOREIGN KEY (ALID) REFERENCES aluno(id)
);

CREATE TABLE chat (
    id INT AUTO_INCREMENT PRIMARY KEY,
    mensagem TEXT NOT NULL,
    remetente INT,
    destinatario INT,
    FOREIGN KEY (remetente) REFERENCES aluno(id),
    FOREIGN KEY (destinatario) REFERENCES aluno(id)
);

CREATE TABLE FLASH_AL (
    id_flashcard INT,
    id_aluno INT,
    FOREIGN KEY (id_flashcard) REFERENCES FLASHCARD(id),
    FOREIGN KEY (id_aluno) REFERENCES aluno(id)
);

CREATE TABLE AU_AL (
    id_aula INT,
    id_aluno INT,
    FOREIGN KEY (id_aula) REFERENCES aulas(id),
    FOREIGN KEY (id_aluno) REFERENCES aluno(id)
);

CREATE TABLE Dicas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ajuda VARCHAR(255),
    Fid INT,
    Cid INT,
    DICIOid INT,
    FOREIGN KEY (Fid) REFERENCES FLASHCARD(id),
    FOREIGN KEY (Cid) REFERENCES compra(id),
    FOREIGN KEY (DICIOid) REFERENCES Dicionario_Libras(id)
);
