--aluno:Dhermeson 
--boardSquare(BS):rebeca
--FlashCards:Guilherme
--Anotacoes:Ana Clara
--Aulas:Manu 

--Tradução
CREATE TABLE Traducao_Libras (
    id INT PRIMARY KEY AUTO_INCREMENT, 
    palavra VARCHAR(255) NOT NULL, 
    sinal VARCHAR(255) NOT NULL, 
    imagem VARCHAR(255) NULL, 
    explicacao TEXT NOT NULL, 
    status BOOLEAN NOT NULL DEFAULT FALSE, 
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB;
