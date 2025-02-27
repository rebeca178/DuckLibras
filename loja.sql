--tabela da loja

CREATE TABLE loja (
    id_product INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    descricao TEXT,
    imagem VARCHAR (255) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    data_lancamento DATE
);