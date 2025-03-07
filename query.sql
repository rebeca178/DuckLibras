-- [RF02] Logar
SELECT id, username, email FROM aluno 
WHERE senha = MD5('123') AND email = 'email@email.com';

-- [RF03] Verificar o Cadastro
SELECT id, username, email FROM aluno 
WHERE username = 'Francisco' AND senha = MD5('123') AND email = 'email@email.com';

-- [RF04] Recuperação de dados
SELECT id, username, email FROM aluno 
WHERE email = 'email@email.com';

-- [RF05] Teste de Flashcard
SELECT id_flashcard, quest, resposta FROM flashcards 
WHERE quest = 'a';

-- [RF06] Alteração de login
SELECT id, username, photo FROM aluno 
WHERE username = 'Francisco' AND photo = 'photo';

-- [RF08] Limitação (nível no Board Square)
SELECT id_bs, nivel, status FROM boardsquare 
WHERE nivel = 1;

-- [RF09] Entrar no Board Square (casa de tabuleiro)
SELECT id_bs, status, nivel FROM boardsquare 
WHERE status = 1;

-- [RF10] Finalização do Board Square
SELECT id_bs, status FROM boardsquare 
WHERE status = 0;

-- [RF13] Ganho de nível no Board Square
SELECT id_bs, status, nivel FROM boardsquare 
WHERE status = 0 AND nivel = 1;

-- [RF14] Flash Cards (pontuação)
SELECT id_flashcard, pontos, nivel FROM flashcards 
WHERE pontos = 35;

-- [RF15] Emitir Aulas
SELECT id_aula, titulo, descricao, status FROM aulas;

-- [RF17] Resposta de Tradução
SELECT id_traducao, palavra, sinal, explicacao FROM traducao 
WHERE id_traducao = 1;

-- [RF18] Listar Anotações
SELECT id_anotacao, titulo, texto, imagem, data_criacao FROM anotacao;

-- [RF19] Loja (produtos e preços)
SELECT id_produto, produto, preco FROM loja 
WHERE produto = 'a' AND preco = 1.00;

-- [RF20] Grupos de Alunos
SELECT id, username, grupo_id FROM aluno 
WHERE id = 1;

-- [RF21] Amizades no Chatbot
SELECT id_chatbot, amizades FROM chatbot 
WHERE amizades = 1;
