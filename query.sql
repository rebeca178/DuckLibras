[RF01] Login


SELECT * FROM aluno a WHERE a.email=”bhbh” AND a.senha=”vvjvgjh”;

-----------------------------------------
[RF02] Alteração de login


  ALTER a 'nome'@'host' IDENTIFIED BY 'nova_senha';
--------------------------------------------
[RF03] Recuperação de dados


     mysql -u [a] -p [BS] < [arquivo_de_backup.sql]
--------------------------------------------
[RF04] Voltar a home


SELECT * FROM h WHERE =HOME ‘1’.

------------------------------------------------
[RF06] Finalização do board square 


SELECT a FROM aulas WHERE a.pontos=”1’;

-------------------------------------
[RF07]emissão de pontuação

SELECT * from flashcard where=points.
-------------------------------------
[RF08] “enviar” aula e atividade

Select atividades from bs where= a.(‘pontos’,’questoes’,’sinais’);
---------------------------------------------------
[RF09] Ganho de nível 

Select * from aluno where=atividade=acertos>erros.



------------------------------------------------------

[RF10] Flash Cards
Select * from a where=a.(flashcards)
SELECT * FROM Flashcards WHERE category = 'History';
SELECT question, answer FROM Flashcards WHERE card_id = 123;
SELECT * FROM Flashcards WHERE last_reviewed < DATE_SUB(CURDATE(), INTERVAL 7 DAY);
UPDATE Flashcards SET last_reviewed = CURDATE() WHERE card_id = 123;
SELECT * FROM Flashcards WHERE difficulty = 3;
SELECT * FROM Flashcards ORDER BY difficulty DESC LIMIT 10;
--------------------------------------------------
[RF11] Timeline 
           SELECT *
          FROM TimelineEvents
   ORDER BY event_date ASC;
