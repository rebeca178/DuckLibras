create database DuckLibras
DEFAULT CHARACTER SET utf8mb4
DEFAULT COLLATE utf8mb4_general_ci;
use DuckLibras;

reate table FLASHCARD (
    ID_FLASHCARD INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    quest VARCHAR(255) NOT NULL,
    SINAL VARCHAR(255),
    Img varchar(255),
    Pid INT NOT NULL,
    DICIOid INT NOT NULL,
    DICASid INT NOT NULL,
    FOREIGN KEY(Pid) REFERENCES pontuacao(id_pontucao),
    FOREIGN KEY (DICIOid) REFERENCES Dicionario_Libras (id_dicionario),
    FOREIGN key (DICASid) REFERENCES Dicas(id_dicas),

);
create table Dicas (
    ID_dicas int primary key not null AUTO_INCREMENT,
    img varchar (255),
    ajuda varchar(255),
    Fid INT NOT NULL,
    Cid INT NOT NULL,
    FOREIGN KEY(CID) REFERENCES compras(id_cop),
    FOREIGN key (Fid) REFERENCES FLASHCARD(id_flashcard)

);
