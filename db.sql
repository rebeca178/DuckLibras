CREATE TABLE Anotacoes (
    id INT PRIMARY KEY AUTO_INCREMENT, -- Identificador único gerado automaticamente
    titulo VARCHAR(255) NOT NULL, -- Título da anotação
    conteudo TEXT NOT NULL, -- Conteúdo da anotação
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Data e hora da criação da anotação
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- Data e hora da última atualização
) ENGINE=InnoDB;

-- melhorias e afins :D
-- AUTO_INCREMENT: O id será gerado automaticamente pelo banco de dados, facilitando a inserção de novos registros.
-- NOT NULL: Garantimos que titulo e conteudo não possam ser nulos, exigindo que sempre sejam fornecidos valores.
-- TEXT: O tipo TEXT permite armazenar conteúdos mais longos para as anotações.
-- data_criacao e data_atualizacao: Adicionamos colunas para registrar automaticamente a data e hora de criação e atualização, ajudando a rastrear alterações no banco de dados.
-- ENGINE=InnoDB: Utilizamos o mecanismo InnoDB, que oferece suporte a transações e integridade referencial.
-- <3
