--aluno
--boardSquare
--FlashCards
--Anotacoes 
--Aulas 

--tradução
CREATE TABLE Traducao_Libras (
    id INT PRIMARY KEY AUTO_INCREMENT, 
    palavra VARCHAR(255) NOT NULL, 
    sinal VARCHAR(255) NOT NULL, 
    imagem VARCHAR(255) NULL, 
    explicacao TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB;

--tabela da loja

CREATE TABLE loja (
    id_product INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    descricao TEXT,
    imagem VARCHAR (255) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    data_lancamento DATE
);