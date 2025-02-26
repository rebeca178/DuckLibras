--RF[01]cadastrar
SELECT * FROM aluno a WHERE a.username = 'Francisco' and a.senha = MD5('123') and a.email='email@email.com' and photo= 'photo';


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
