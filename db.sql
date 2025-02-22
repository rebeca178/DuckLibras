CREATE TABLE SuaTabela (
    id INT PRIMARY KEY AUTO_INCREMENT,-- Identificador único gerado automaticamente 
    sinal TINYINT NOT NULL,-- Valor do sinal (de -128 a 127)
    explicacao VARCHAR(500) NOT NULL,
    status BOOLEAN NOT NULL DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,-- Data e hora da criação do registro
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  -- Data e hora da última atualização
) ENGINE=InnoDB;

-- melhorias e afins :D
--AUTO_INCREMENT: O id será gerado automaticamente pelo banco de dados, facilitando a inserção de novos registros.
--NOT NULL: Garantimos que sinal, explicacao e status não possam ser nulos, exigindo que sempre sejam fornecidos valores.
--VARCHAR(500): Aumentamos o tamanho máximo da coluna explicacao para 500 caracteres, permitindo descrições mais longas.
--created_at e updated_at: Adicionamos colunas para registrar automaticamente a data e hora de criação e atualização do registro, ajudando a rastrear alterações no banco de dados.
--ENGINE=InnoDB: Utilizamos o mecanismo InnoDB, que oferece suporte a transações e integridade referencial.
-- <3