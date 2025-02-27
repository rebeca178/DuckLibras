-- 1. Selecionar todas as anotações
SELECT * FROM Anotacoes;

-- 2. Selecionar uma anotação específica pelo ID
SELECT * FROM Anotacoes WHERE id_anotacao = 1; 

-- 3. Inserir uma nova anotação
INSERT INTO Anotacoes (titulo, conteudo, sinais, explicacao) 
VALUES ('Novo Título', 'Conteúdo da anotação.', 'sinalX', 'Explicação detalhada.');

-- 4. Atualizar uma anotação existente
UPDATE Anotacoes 
SET titulo = 'Título Atualizado', conteudo = 'Conteúdo atualizado.', 
    sinais = 'novoSinal', explicacao = 'Explicação atualizada.'
WHERE id_anotacao = 1;

-- 5. Excluir uma anotação pelo ID
DELETE FROM Anotacoes WHERE id_anotacao = 1;

-- 6. Contar o número total de anotações
SELECT COUNT(*) AS total_anotacoes FROM Anotacoes;

-- 7. Selecionar anotações criadas em uma data específica
SELECT * FROM Anotacoes WHERE DATE(data_criacao) = '12-05-2006';

-- RF[01] Cadastrar um novo aluno
SELECT * FROM aluno AS a 
WHERE a.username = 'Francisco' 
  AND a.senha = MD5('123') 
  AND a.email = 'email@email.com' 
  AND a.photo = 'photo';

-- RF[02] Atualizar informações do login
SELECT * FROM aluno AS a 
WHERE a.username = 'Francisco' 
  AND a.photo = 'photo';

-- RF[03] Recuperar dados do aluno
SELECT * FROM aluno AS a 
WHERE a.email = 'email@email.com';

-- RF[05] Acessar o Board Square (casa de tabuleiro)
SELECT * FROM BS AS b 
WHERE b.STATUS = TRUE;

-- RF[06] Encerrar atividades no Board Square
SELECT * FROM BS AS b 
WHERE b.STATUS = FALSE;

-- RF[07] Gerar pontuação
SELECT * FROM FLASHCARD AS f 
WHERE f.ponto = 35;

-- RF[08] Submeter aula e atividades
SELECT * FROM FLASHCARD AS f 
WHERE f.STATUS = FALSE;
SELECT * FROM aulas AS au 
WHERE au.status = FALSE;

-- RF[09] Obter avanço de nível
SELECT * FROM FLASHCARD AS f 
WHERE f.nivel = 99;

-- RF[10] Consultar Flash Cards
SELECT * FROM FLASHCARD AS f 
WHERE f.ponto = 35;

-- RF[11] Visualizar anotações
SELECT * FROM Anotacoes;

-- RF[12] Login do aluno
SELECT * FROM aluno AS a 
WHERE a.senha = MD5('123') 
  AND a.email = 'email@email.com';
