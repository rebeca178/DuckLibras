use ducklibras;

INSERT INTO chatbot (id_chat,chat, perguntas, respostas,amizade) VALUES ('1', 'Quem sou eu ?', 'Você é um humano ','1');


INSERT INTO loja (id_lol, produto, preco) VALUES ('1', 'pato aranha', '100P');

INSERT INTO compra (id_cop, quantidade, loja_id,ALID) VALUES ('1', '1','1','1');

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



insert into BS (id_bs,STATUS,id_aula,id_flashcard,nivel) VALUES  ('1','1','1','1','1');

insert into FLASH_AL(id_aluno,id_flashcard) VALUES  ('1','1');

insert into AU_AL(id_aula,id_aluno) VALUES  ('1','1');

insert into traducao_libras (palavra, sinal, explicacao, status, created_at, updated_at), values ('Acusar', 'https://sistemas.cead.ufv.br/capes/dicionario/wp-content/uploads/2017/08/04.jpg', 'atribuir falta, infração ou crime a (alguém ou si próprio); culpar(-se), incriminar(-se)', 'ativa', '2602', 'não');

insert into FLASHCARD (ID_FLASHCARD,quest,Pid,DICIOid,DICASid ) values ('1', 'WHAT?', '1','1','1');

insert into Dicas (ID_dicas,ajuda,Fid,Cid,DICIOid ) values ('1', 'help', '1','1','1');

