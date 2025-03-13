USE DuckLibras;

-- RF01 Cadastrar  
SELECT * FROM aluno WHERE username = 'francisco' AND email = 'fran@gmail.com' AND senha = MD5('1') AND photo = 'franfoto';  

-- RF02 Logar  
SELECT * FROM aluno WHERE senha = MD5('1') AND email = 'fran@gmail.com';  

-- RF03 Recuperação de dados  
SELECT * FROM aluno WHERE username = 'francisco' AND email = 'fran@gmail.com';  

-- RF04 Teste  
SELECT * FROM aluno WHERE email = 'fran@gmail.com';  

-- RF05 Alteração de dados  
SELECT * FROM aluno WHERE username = 'joao' AND photo = 'joaofoto' AND email = 'joao@gmail.com';  

-- RF07 Limitação  
SELECT * FROM pontuacao WHERE nivel = 1;  

-- RF08 Entrar no Board Square  
SELECT * FROM BS;  

-- RF09 Finalização do Board Square  
SELECT * FROM BS WHERE status = 1;  

-- RF11 Enviar conclusão  
SELECT b.* FROM BS b INNER JOIN aluno a ON b.auID = a.id WHERE a.username = 'joao';  

-- RF12 Ganho de nível  
SELECT * FROM pontuacao WHERE pontos = 5 AND nivel = 1;  

-- RF13 Flashcards
SELECT * FROM pontuacao p LEFT JOIN FLASHCARD f ON f.Pid = p.id WHERE p.nivel = '1' AND f.quest = 'WHAT?';

-- RF14 Enviar Aula  
SELECT * FROM pontuacao p left join aulas a ON a.Pid = p.id WHERE p.nivel = '1' AND a.id= '1';

-- RF15 Buscar Tradução  
SELECT a.username AS Aluno, an.titulo, an.texto, an.data_criacao FROM anotacao an JOIN aluno a ON an.dicioId = a.id ORDER BY an.data_criacao DESC;  

-- [[RF16] Resposta Tradução
SELECT t.palavra, t.created_at, t.updated_at, d.palavra AS Palavra_Libras FROM traducao t JOIN Dicionario_Libras d ON t.dicioId = d.id ORDER BY t.created_at DESC;

-- [RF17] Anotações
SELECT a.username AS Aluno, an.titulo, an.texto, an.data_criacao FROM anotacao an JOIN aluno a ON an.dicioId = a.id ORDER BY an.data_criacao DESC;

-- [RF18] Loja
SELECT l.produto, l.preco, c.quantidade, a.username AS Aluno FROM loja l JOIN compra c ON l.id = c.loja_id JOIN aluno a ON a.id = c.ALID ORDER BY l.produto;

-- [RF19] Grupos
SELECT a1.username AS Aluno_1, a2.username AS Aluno_2 FROM aluno a1 JOIN aluno a2 ON a1.id != a2.id ORDER BY a1.username, a2.username;

-- [RF20] Amizades
SELECT a1.username AS Aluno_1, a2.username AS Aluno_2, COUNT(c.id) AS Mensagens_Trocadas FROM chat c JOIN aluno a1 ON a1.id = c.remetente JOIN aluno a2 ON a2.id = c.destinatario WHERE a1.id != a2.id GROUP BY a1.id, a2.id ORDER BY Mensagens_Trocadas DESC;

-- [RF21] Metas
SELECT a.username AS Aluno, COUNT(DISTINCT fa.id_flashcard) AS Flashcards_Completados, COUNT(DISTINCT aa.id_aula) AS Aulas_Realizadas, p.pontos AS Pontuacao_Atual, p.nivel AS Nivel_Atual FROM aluno a LEFT JOIN flash_al fa ON fa.id_aluno = a.id LEFT JOIN au_al aa ON aa.id_aluno = a.id LEFT JOIN pontuacao p ON p.id = a.pontID GROUP BY a.id ORDER BY a.username;
