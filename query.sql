-- [RF12] Ganho de nível no Board Square
SELECT id_bs, status, nivel FROM boardsquare 
WHERE status = 0 AND nivel = 1;

-- [RF13] FLASHCARD
SELECT id_flashcard, pontos, nivel FROM flashcard;

-- [RF13.1] Flash Cards (pontuação)
SELECT id_flashcard, pontos, nivel FROM flashcards 
WHERE pontos = 35;

-- [RF14] Emitir Aulas
SELECT id_aula, titulo, descricao, status FROM aulas;

-- [RF15] Buscar Tradução
SELECT id_traducao, palavra, sinal, explicacao FROM traducao 
WHERE id_traducao = 1;

-- [RF16] Listar Anotações
SELECT id_anotacao, titulo, texto, imagem, data_criacao FROM anotacao;

-- [RF17] loja
SELECT id_produto, produto, preco FROM loja;

-- [RF18] Loja (produtos e preços)
SELECT id_produto, produto, preco FROM loja 
WHERE produto = 'a' AND preco = 1.00;

-- [RF19] Grupos de Alunos
SELECT id, username, grupo_id FROM aluno 
WHERE id IN (1, 2, 3, 4, 5);

--SEGURANÇA

--[RF10] LOGIN E SENHA
SELECT a.photo ,a.username, a.email, a.senha FROM aluno;

--RF[01]cadastrar
SELECT * FROM aluno a WHERE a.username = 'Francisco' and a.senha = MD5('123') and a.email='email@email.com' and photo= 'photo';

--RF[03]Recuperação de dados
SELECT * FROM aluno a WHERE a.email='email@email.com';

--RF[06] Finalização do board square
SELECT * FROM BS b WHERE b.status ='0';

--RF[07] emissão de pontuação
SELECT * FROM FLASHCARDS f WHERE f.pontos ='35';

--[RF09] Ganho de nível
SELECT * FROM FLASHCARDS f WHERE f.nivel ='99';

--[RF10] Flash Cards
SELECT * FROM FLASHCARDS f WHERE f.pontos ='35';

--[RF11] Timeline
SELECT * FROM anotacoes;

--[RF12]Logar 
SELECT * FROM aluno a WHERE a.senha = MD5('123') and a.email='email@email.com';


-- RF01: Registro de aluno
INSERT INTO aluno (username, email, senha, photo, nivel, ponto) 
VALUES ('Francisco', 'email@example.com', 'senha', NULL, 1, 0);

-- RF02: Alteração de login
UPDATE aluno 
SET username = 'Francisco', photo = NULL 
WHERE email = 'email@example.com' AND senha = 'senha';

-- RF03: Recuperação de senha (simplesmente verificando e-mail e senha)
SELECT * FROM aluno 
WHERE email = 'email@example.com' and senha = MD5('123');

-- RF05: Verificação de acesso ao Board Square
SELECT * FROM BS 
WHERE id_bs = (SELECT id_bs FROM aluno WHERE id = aluno_id);

-- RF06: Finalização do Board Square
SELECT COUNT(*) FROM aulas  WHERE id_aulas IN (SELECT id_aula FROM BS WHERE id_bs = (SELECT id_bs FROM aluno WHERE id = aluno_id));

-- RF07: Emissão de pontuação baseada em acertos e erros
UPDATE aluno 
SET ponto = ponto + (SELECT COUNT(*) FROM FLASHCARD WHERE id_flashcard IN (SELECT id_flashcard FROM BS WHERE id_bs = aluno.id_bs) WHERE id = aluno_id;

-- RF08: Enviar aula e atividade (passar para próxima aba, supomos status TRUE ao finalizar)
UPDATE BS 
SET STATUS = TRUE WHERE id_bs = (SELECT id_bs FROM aluno WHERE id = aluno_id);

-- RF09: Ganho de nível baseado na quantidade de pontos acumulados
UPDATE aluno 
SET nivel = nivel + 1 WHERE ponto >= 100; -- Exemplo: ao atingir 100 pontos sobe de nível

-- RF10: Flashcards para aumento de pontos
SELECT * FROM FLASHCARD WHERE ponto IS NOT NULL ORDER BY RAND() LIMIT 1;

-- RF11: Timeline para revisão do aprendizado
SELECT * FROM Traducao_Libras WHERE id_tradu IN (SELECT id_flashcard FROM BS WHERE id_bs = (SELECT id_bs FROM aluno WHERE id = aluno_id));

SELECT c.id, c.mensagem, a1.usurname AS remetente, a2.username AS destinatario FROM chat c 
JOIN usuario a1 ON c.remetente = a1.username
JOIN usuario a2 ON c.destinatario = a2.username;

SELECT id_lol, produto, preco
FROM loja lo;
order by id_lol desc;

SELECT id_cop, quantidade, produto
FROM compra co;
order by id_cop desc;
