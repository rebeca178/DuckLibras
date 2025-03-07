INSERT INTO traducao (palavra, sinal, imagem, explicacao, status) VALUES
('Livro', 'SINAL_LIVRO', 'livro.png', 'Sinal correspondente à palavra Livro.', TRUE),
('Casa', 'SINAL_CASA', 'casa.png', 'Sinal correspondente à palavra Casa.', TRUE),
('Água', 'SINAL_AGUA', 'agua.png', 'Sinal correspondente à palavra Água.', TRUE),
('Amigo', 'SINAL_AMIGO', 'amigo.png', 'Sinal correspondente à palavra Amigo.', FALSE),
('Futuro', 'SINAL_FUTURO', 'futuro.png', 'Sinal correspondente à palavra Futuro.', FALSE);

INSERT INTO anotacao (usuario_id, titulo, texto, imagem) VALUES
(1, 'Anotação sobre o Projeto', 'Esta é uma anotação importante sobre o andamento do projeto...', 'imagem1.jpg'),
(2, 'Anotação de Reunião', 'A reunião discutiu as metas para o mês de setembro...', 'imagem2.png'),
(3, 'Anotação Técnica', 'Analisamos a estrutura do banco de dados e fizemos algumas alterações...', 'imagem3.jpg'),
(1, 'Anotação de Testes', 'Testes de funcionalidades realizados no sistema para verificar os erros...', 'imagem4.jpg'),
(4, 'Anotação Pessoal', 'Revisão das anotações de código e melhorias feitas no projeto...', 'imagem5.png');
