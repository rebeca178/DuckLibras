--tabela de pontuação

CREATE TABLE Pontuacao (
    id_pontuacao SERIAL PRIMARY KEY,
    id_usuario INT NOT NULL,
    pontos INT DEFAULT 0,
    nivel INT DEFAULT 1,
    ultima_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id)
);
