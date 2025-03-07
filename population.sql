use DuckLibras;


insert into BS (id_bs,STATUS,id_aula,id_flashcard,nivel) VALUES  ('1','1','1','1','1');

insert into FLASH_AL(id_aluno,id_flashcard) VALUES  ('1','1');

insert into AU_AL(id_aula,id_aluno) VALUES  ('1','1');

insert into traducao_libras (palavra, sinal, explicacao, status, created_at, updated_at), values ('Acusar', 'https://sistemas.cead.ufv.br/capes/dicionario/wp-content/uploads/2017/08/04.jpg', 'atribuir falta, infração ou crime a (alguém ou si próprio); culpar(-se), incriminar(-se)', 'ativa', '2602', 'não');

insert into FLASHCARD (ID_FLASHCARD,quest,Pid,DICIOid,DICASid ) values ('1', 'WHAT?', '1','1','1');

insert into Dicas (ID_dicas,ajuda,Fid,Cid,DICIOid ) values ('1', 'help', '1','1','1');


