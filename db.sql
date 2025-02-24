
create table aulas
(
id_usuario int(10) unique not null,
sinal varchar(20),
explicaçao text(255),
id_videos int(4) not null,
atividades  text(500),
resumo text(500),
nivel_id int(5) not null,
resultado number ,
);



--id_usuario é a identificação do usuário.
--id_videos é a identificação dos vídeos nas aulas.
--id_nivel é a identificação dos squareboard e seus níveis.
--explicação é o texto que vai ter em cada atividade.
--resumo vai ter em todas em squaresboard e dicas.
--resultado é das atividades e provas para passar para o próximo nível.