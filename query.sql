--[RF02] logar
SELECT * FROM aluno a WHERE a.senha = MD5('123') and a.email='email@email.com';

--[RF03] Verificar o Cadastro
SELECT * FROM aluno a WHERE a.username = 'Francisco' and a.senha = MD5('123') and a.email='email@email.com';

--[RF04] Recuperação de dados
SELECT * FROM aluno a WHERE a.email='email@email.com';

--[RF05] Teste 
SELECT * FROM flashcards f WHERE f.quest= 'a'  ;

--[RF06] Alteração de login
SELECT * FROM aluno a WHERE a.username = 'Francisco' and photo= 'photo';

--[RF08] limitação
SELECT * FROM BS b WHERE b.nivel = '1';

--[RF09] Entrar no Board square(casa de tabuleiro)
SELECT * FROM BS b WHERE b.status = '1';.

--[RF10] Finalização do board square
SELECT * FROM BS b WHERE b.status = '0';

--[RF13] Ganho de nível
SELECT * FROM BS b WHERE b.status = '0' and b.nivel= '1';

--[RF14] Flash Cards
SELECT * FROM FLASHCARDS f WHERE f.pontos ='35';

--[RF15] emitir aulas 
SELECT * FROM aulas;

--[RF17] resposta tradução
SELECT * FROM traducoes t  WHERE t.id ='1';

--[RF18] anotações 
SELECT * FROM anotacoes;

--[RF19] Loja
SELECT * FROM loja l  WHERE l.produto ='a' and l.preco= '1.00' ;

--[RF20] grupos
SELECT * FROM aluno a WHERE a.id= '1' ;

--[RF21] Amizades
SELECT * FROM chatbot c WHERE c.amizades = '1' ;
