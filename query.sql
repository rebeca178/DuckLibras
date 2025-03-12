use DuckLibras;

-- [RF20] Metas
SELECT a.username AS Aluno, COUNT(DISTINCT fa.id_flashcard) AS Flashcards_Completados, COUNT(DISTINCT aa.id_aula) AS Aulas_Realizadas, p.pontos AS Pontuacao_Atual, p.nivel AS Nivel_Atual FROM aluno a LEFT JOIN flash_al fa ON fa.id_aluno = a.id LEFT JOIN au_al aa ON aa.id_aluno = a.id LEFT JOIN pontuacao p ON p.id = a.pontID GROUP BY a.id ORDER BY a.username;

-- [RF21 Amizades
SELECT a1.username AS Aluno_1, a2.username AS Aluno_2, COUNT(c.id) AS Mensagens_Trocadas FROM chat c JOIN aluno a1 ON a1.id = c.remetente JOIN aluno a2 ON a2.id = c.destinatario WHERE a1.id != a2.id GROUP BY a1.id, a2.id ORDER BY Mensagens_Trocadas DESC;
