--aluno:Dhermeson 
--boardSquare(BS):rebeca
--FlashCards:Guilherme
--Anotacoes:Ana Clara
--Aulas:Manu 

create database Aulas;

use Aulas;


create table usuario(
id int(10) unique not null,
sinal varchar(20),
explicaçao text);



create table videos(

id int(4) not null,
atividades  text(500),
resumo text(500),
nivel_id int(5) not null


);


