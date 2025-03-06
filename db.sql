create database DuckLibras
DEFAULT CHARACTER SET utf8mb4
DEFAULT COLLATE utf8mb4_general_ci;
use DuckLibras;

CREATE TABLE traducao (
    id_traducao INT PRIMARY KEY AUTO_INCREMENT,
    palavra VARCHAR(255) NOT NULL,
    sinal VARCHAR(255) NOT NULL,
    imagem VARCHAR(500),
    explicacao TEXT NOT NULL,
    status BOOLEAN NOT NULL DEFAULT FALSE,
    usuario_id INT NOT NULL,
    dicionario_id INT NOT NULL,
    palavra_id INT,
    video_id INT,
    sinal_id INT,
    flashcard_id INT,
    boardsquare_id INT,
    anotacao_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (usuario_id) REFERENCES aluno(id) ON DELETE CASCADE,
    FOREIGN KEY (dicionario_id) REFERENCES dicionario(id) ON DELETE CASCADE,
    FOREIGN KEY (palavra_id) REFERENCES palavras(id) ON DELETE SET NULL,
    FOREIGN KEY (video_id) REFERENCES videos(id) ON DELETE SET NULL,
    FOREIGN KEY (sinal_id) REFERENCES sinais(id) ON DELETE SET NULL,
    FOREIGN KEY (flashcard_id) REFERENCES flashcards(id_flashcard) ON DELETE SET NULL,
    FOREIGN KEY (boardsquare_id) REFERENCES boardsquare(id_bs) ON DELETE SET NULL,
    FOREIGN KEY (anotacao_id) REFERENCES anotacao(id_anotacao) ON DELETE SET NULL
);
