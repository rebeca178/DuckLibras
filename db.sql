create table chatbot(
    id_chat int primary key auto_increment,
    perguntas varchar(255),
    respostas varchar(255),
    amizade int,
    foreign key (id_aluno) references aluno(id_aluno)
);

create table loja(
    id_lol int primary key auto_increment,
    produto varchar(255),
    preco varchar(255)
);

create table compra(
    id_cop int primary key auto_increment,
    quantidade int,
    loja_id INT,
    ALID INT,
    foreign key (loja_id) references loja(lol),
    foreign key (ALID) references aluno(id_Aluno)
); 
