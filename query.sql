-- [RF01] Cadastrar um novo aluno
-- Cadastra um novo aluno no banco de dados com username, senha (criptografada), email e foto.
INSERT INTO aluno (username, senha, email, photo) 
VALUES ('Francisco', MD5('123'), 'email@email.com', 'photo.jpg');

-- [RF02] Logar
-- Realiza o login do aluno verificando a senha e o e-mail fornecidos.
SELECT * FROM aluno 
WHERE senha = MD5('123') 
AND email = 'email@email.com';

-- [RF03] Recuperação de dados pelo e-mail
-- Recupera as informações do aluno baseado no e-mail fornecido.
SELECT * FROM aluno 
WHERE email = 'email@email.com';

-- [RF04] Teste Flashcards
-- Realiza a consulta de flashcards específicos com base na questão.
SELECT * FROM flashcards 
WHERE quest = 'a';

-- [RF05] Alteração de login (verificação de foto associada ao usuário)
-- Verifica se o aluno tem a foto correta associada ao seu nome de usuário.
SELECT * FROM aluno 
WHERE username = 'Francisco' 
AND photo = 'photo.jpg';

-- [RF06] Termos de uso e Política de Privacidade
-- Verifica se o aluno aceitou os Termos de Uso e Política de Privacidade.
SELECT * FROM aluno 
WHERE username = 'Francisco' 
AND termos_aceitos = TRUE;

-- [RF07] Entrar no Board Square (casa de tabuleiro)
-- Verifica se o aluno já possui um status de acesso ao Board Square.
SELECT * FROM board_square 
WHERE aluno_id = (SELECT id FROM aluno WHERE username = 'Francisco') 
AND status = 1;

-- [RF08] Finalização do Board Square
-- Verifica se o aluno concluiu todas as atividades no Board Square.
SELECT * FROM board_square 
WHERE aluno_id = (SELECT id FROM aluno WHERE username = 'Francisco') 
AND status = 0;

-- [RF09] Ganho de nível ao finalizar Board Square
-- Verifica o nível do aluno após a finalização de um Board Square.
SELECT * FROM board_square 
WHERE aluno_id = (SELECT id FROM aluno WHERE username = 'Francisco') 
AND status = 0 
AND nivel = 1;

-- [RF10] Flash Cards com pontuação específica
-- Recupera flashcards baseados em uma pontuação específica.
SELECT * FROM flashcards 
WHERE pontos = 35;

-- [RF11] Emitir aulas
-- Exibe todas as aulas disponíveis no sistema.
SELECT * FROM aulas;

-- [RF12] Resposta de tradução
-- Recupera a tradução de um conteúdo específico com base no ID.
SELECT * FROM traducoes 
WHERE id = 1;

-- [RF13] Anotações
-- Recupera as anotações do aluno.
SELECT * FROM anotacoes 
WHERE aluno_id = (SELECT id FROM aluno WHERE username = 'Francisco');

-- [RF14] Enviar Aulas
-- Recupera as aulas desbloqueadas para o aluno 'Francisco'
SELECT aulas.*
FROM aulas
JOIN AU_AL ON aulas.ID = AU_AL.id_aula
JOIN aluno ON AU_AL.id_aluno = aluno.id
WHERE aluno.username = 'francisco';

-- [RF15] Buscar Tradução
-- Verifica as traduções de uma palavra específica com base no ID da tradução.
SELECT * FROM traducao 
WHERE id = 1 LIMIT 1;

-- [RF16] Resposta da Tradução
-- Verifica a tradução de uma palavra com base no sinal ou explicação fornecida.

-- [RF17] Anotações
-- Recupera as anotações do aluno "Francisco".
SELECT * FROM anotacao 
WHERE id = (SELECT id FROM aluno WHERE username = 'francisco') 
LIMIT 5;

-- [RF18] Loja
-- Realiza a compra de um item da loja com base nos pontos do aluno.
-- Antes de fazer a compra, verifica se o aluno tem pontos suficientes
UPDATE aluno 
SET pontos = pontos - 10 
WHERE id = (SELECT id FROM aluno WHERE username = 'Francisco') 
AND pontos >= 10;

INSERT INTO transacoes (aluno_id, produto, pontos) 
VALUES ((SELECT id FROM aluno WHERE username = 'Francisco'), 'Produto X', 10);
