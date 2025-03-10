use DuckLibras;

insert into traducao_libras (palavra, sinal, explicacao, status, created_at, updated_at), values ('Acusar', 'https://sistemas.cead.ufv.br/capes/dicionario/wp-content/uploads/2017/08/04.jpg', 'atribuir falta, infração ou crime a (alguém ou si próprio); culpar(-se), incriminar(-se)', 'ativa', '2602', 'não');

insert into FLASHCARD (ID_FLASHCARD,quest,Pid,DICIOid,DICASid ) values ('1', 'WHAT?', '1','1','1');

insert into Dicas (ID_dicas,ajuda,Fid,Cid,DICIOid ) values ('1', 'help', '1','1','1');

INSERT INTO aulas (sinal,explicaçao ,videos,nivel,status) VALUES ('olá','para cumprimentar alguem se dizer ola','video00001','nivel0001','1');
INSERT INTO aulas (sinal,explicaçao ,videos,nivel,status) VALUES ('tchau','para se despedir de alguem se dizer tchau','video00002','nivel0001','2');
INSERT INTO aulas (sinal,explicaçao ,videos,nivel,status) VALUES ('meu nome é','para se apresentar à alguem ','video00003','nivel0001','3');
INSERT INTO aulas (sinal,explicaçao ,videos,nivel,status) VALUES ('numeros','os numeros em libras é assim','video00004','nivel0001','4');

