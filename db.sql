create database DuckLibras
DEFAULT CHARACTER SET utf8mb4
DEFAULT COLLATE utf8mb4_general_ci;
use DuckLibras;

Create table BS(
    id_bs INT(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    STATUS BOOLEAN NOT NULL,
    nivel int,
    id_aula int, 
    id_flashcard int,
    id_pontuacao int,
    CONSTRAINT fk_nivel FOREIGN KEY (nivel) REFERENCES pontuacao(nivel),
    FOREIGN KEY (id_pontuacao) REFERENCES pontuacao(id_pontuacao),
    FOREIGN KEY (id_aula) REFERENCES aulas(id_aula),
    FOREIGN KEY (id_flashcard) REFERENCES FLASHCARD(id_flashcard)
);

Create table FLASH_AL(
    id_flashcard int,
    id_aluno int,
    FOREIGN KEY (id_aluno) REFERENCES aluno(id_aluno),
    FOREIGN KEY (id_flashcard) REFERENCES FLASHCARD(id_flashcard)
);

Create table AU_AL(
    id_flashcard int,
    id_aluno int,
    FOREIGN KEY (id_aula) REFERENCES aulas(id_aula),
    FOREIGN KEY (id_aluno) REFERENCES aluno(id_aluno)
);


