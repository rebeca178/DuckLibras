USE DuckLibras;

--RF01 Cadastrar
  SELECT *  from aluno a WHERE   a.username = 'francisco' and a.email='fran@gmail.com' and a.senha = MD5('1') and a.photo='franfoto';

--[RF02] logar
SELECT * FROM aluno a WHERE a.senha = MD5('1') and a.email='fran@gmail.com';

--[RF03] Recuperação de dados
SELECT * FROM aluno a WHERE a.username = 'francisco' and a.email='fran@gmail.com';

--[RF04] Teste
SELECT * FROM aluno a WHERE a.email='fran@gmail.com';

--[RF05] Alteração de dados 
SELECT * FROM aluno a WHERE a.username= 'joao' and a.photo= 'joaofoto' and a.email= 'joao@gmail.com';

--[RF07] limitação
SELECT * FROM pontuacao WHERE p.nivel = '1';

--[RF08] Entrar no Board square(casa de tabuleiro)
SELECT * FROM BS b;

--[RF09] Finalização do board square
SELECT * FROM BS b WHERE b.status = '0';

--[RF11] Enviar conclusão
SELECT * FROM BS b INNER JOIN aluno a ON b.auID = a.id WHERE  a.username ='joao' ;

--[RF12] Ganho de nivel 
SELECT * FROM pontuacao p WHERE p.pontos = '5' and p.nivel = '1';

--[RF13] Flashcards
SELECT * FROM pontcao p left JOIN Flashcards f  ON f.Pid = p.id WHERE p.nivel = '1' AND f.quest = 'WHAT?';

--[RF14] Enviar Aula 
SELECT * FROM pontucao p left join aulas a ON a.Pid = p.id WHERE p.nivel = '1' AND a.id= '1';

--[RF15] anotações 
SELECT * FROM traducao t left join Dicionario_Libras d on t.dicioId = d.id
left join  aula a on a.dicioIdid = d.id
WHERE t.id = '1' AND a.id = '1';

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

<<<<<<< HEAD

--RF[02]Alteração de login
SELECT * FROM aluno a WHERE a.username = 'Francisco' and photo= 'photo';

--RF[03]Recuperação de dados
SELECT * FROM aluno a WHERE a.email='email@email.com';


--RF[05]Entrar no Board square(casa de tabuleiro)
SELECT * FROM BS b WHERE b.status ='1';


--RF[06] Finalização do board square
SELECT * FROM BS b WHERE b.status ='0';

--RF[07] emissão de pontuação
SELECT * FROM FLASHCARDS f WHERE f.pontos ='35';

--[RF08] “enviar” aula e atividade
SELECT * FROM FLASHCARDS f WHERE f.status ='0';
SELECT * FROM Aulas au WHERE a.status='0';

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
WHERE email = 'email@example.com';

-- RF04: Redirecionamento para home (não há necessidade de query, pois é um redirecionamento no app)

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

SELECT u1.nome AS remetente, u2.nome AS destinatario
FROM chat c
JOIN aluno u1 ON c.remetente = u1.id
JOIN aluno u2 ON c.destinatario = u2.id;

SELECT id_lol, produto, preco
FROM loja lo;
order by id_lol desc;

SELECT id_cop, quantidade, produto
FROM compra co;
order by id_cop desc;
=======
-- [RF21] Metas
SELECT a.username, COUNT(DISTINCT fa.id_flashcard) AS Flashcards_Completados, COUNT(DISTINCT aa.id_aula) AS Aulas_Realizadas, p.pontos, p.nivel FROM aluno a LEFT JOIN FLASH_AL fa ON fa.id_aluno = a.id LEFT JOIN AU_AL aa ON aa.id_aluno = a.id LEFT JOIN Pontuacao p ON p.id = a.pontID GROUP BY a.id ORDER BY a.username;

