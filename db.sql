Create table aluno(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(320) NOT NULL, 
    photo  BLOB,
    senha VARCHAR(255) NOT NULL,
    nivel int,
    ponto int,
	id_bs int,
    id_flashcard int,
    id_anotacao int,
    id_chat int,
    id_loja int,
    id_cop int,

FOREIGN KEY (id_bs) REFERENCES BS(id_bs),
FOREIGN KEY (id_flashcard) REFERENCES FLASHCARD(id_flashcard),
FOREIGN KEY (id_anotacao) REFERENCES Anotacoes(id_anotacao),
FOREIGN KEY (id_chat) REFERENCES ChatBOT(id_chat),
FOREIGN KEY (id_loja) REFERENCES Loja(id_loja),
FOREIGN KEY (id_cop) REFERENCES compras(id_cop),

);