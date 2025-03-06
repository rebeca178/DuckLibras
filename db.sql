--aluno
--boardSquare
--FlashCards
--Anotacoes 
--Aulas 

--Dicionário
CREATE TABLE Dicionario_Libras (
    id_dicionario SERIAL PRIMARY KEY,
    palavra VARCHAR(100) NOT NULL,
    traducao VARCHAR(100) NOT NULL,
    video_url TEXT NOT NULL,
    descricao TEXT,
    categoria VARCHAR(50),
    dificuldade ENUM('Fácil', 'Médio', 'Difícil') DEFAULT 'Fácil',
);

--tabela de pontuação

CREATE TABLE Pontuacao (
    id_pontuacao SERIAL PRIMARY KEY,
    id_usuario INT NOT NULL,
    pontos INT DEFAULT 0,
    nivel INT DEFAULT 1,
    ultima_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id)
);
