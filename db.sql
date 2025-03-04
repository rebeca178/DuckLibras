create table chatbot(
    id_chat int primary key auto_increment,
    perguntas varchar(255),
    respostas varchar(255)
);

create table loja(
    id_lol int primary key auto_increment,
    pato varchar(255),
    preco varchar(255)
);

create table compra(
    id_cop int primary key auto_increment,
    quantidade int,
    foreign key (loja_id) references loja(lol)
); 
