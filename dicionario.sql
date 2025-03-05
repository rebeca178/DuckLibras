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
