use DuckLibras;

insert into dicionario_libras (id,palavra,traducao,sinal,imagem,video_url,descricao,categoria,dificuldade) VALUES  ('1','coelho','coelho2','sinalcoelho', 'imgcoleho','vidocoelho','oqcoelho','animal','Fácil');

insert into pontuacao (id,pontos,nivel) VALUES  ('1','5','1');

insert into FLASHCARD (id,quest,Pid,DICIOid) values ('1', 'WHAT?', '1','1');

insert into aulas (id,explicacao,Pid,DICIOid) VALUES  ('1','pipipopo','1','1');

insert into BS (id,STATUS,auID,FlashID,PonId) VALUES  ('1','1','1','1','1');

insert into traducao (id,palavra,dicioId) VALUES  ('1','coelho','1');

insert into anotacao (id,titulo,texto,dicioId,BSid) VALUES  ('1','aula1','sinais','1','1');
