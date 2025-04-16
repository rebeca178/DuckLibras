use DuckLibras;

insert into chatbot (id_chat,chat, perguntas, respostas,amizade) VALUES ('1', 'Quem sou eu ?', 'Você é um humano ','1');

insert into loja (id_lol, produto, preco) VALUES ('1', 'pato aranha', '100P');

insert into compra (id_cop, quantidade, loja_id,ALID) VALUES ('1', '1','1','1');

insert into dicionario_libras (id,palavra,traducao,sinal,imagem,video_url,descricao,categoria,dificuldade) VALUES  ('1','coelho','coelho2','sinalcoelho', 'imgcoleho','vidocoelho','oqcoelho','animal','Fácil');

insert into pontuacao (id,pontos,nivel) VALUES  ('1','5','1');

insert into BS (id_bs,STATUS,id_aula,id_flashcard,nivel) VALUES  ('1','1','1','1','1');

insert into FLASHCARD (id,quest,Pid,DICIOid) values ('1', 'WHAT?', '1','1');

insert into aulas (id,explicacao,Pid,DICIOid) VALUES  ('1','pipipopo','1','1');

insert into BS (id,STATUS,auID,FlashID,PonId) VALUES  ('1','1','1','1','1');

insert into traducao (id,palavra,dicioId) VALUES  ('1','coelho','1');

insert into anotacao (id,titulo,texto,dicioId,BSid) VALUES  ('1','aula1','sinais','1','1');

insert into loja (id,produto,preco) VALUES  ('1','patobatman','2.50');

insert into aluno (id,username,email,photo,senha,Anoid,TradId,BSid,pontID) VALUES  ('1','francisco','fran@gmail.com','franfoto',MD5 ('1'),'1','1','1','1');

insert into aluno (id,username,email,photo,senha,Anoid,TradId,BSid,pontID) VALUES  ('2','joao','joao@gmail.com','joaofoto',MD5 ('2'),'1','1','1','1');

insert into chat(id,mensagem,remetente,destinatario) VALUES  ('1','oi','1','2');

insert into flash_al(id_flashcard,id_aluno) values ('1','1');

insert into au_al(id_aula,id_aluno) VALUES  ('1','1');

insert into compra (id,quantidade,loja_id,ALID ) values ('1', '1', '1','1');

insert into dicas (ID,ajuda,Fid,Cid,DICIOid ) values ('1', 'help', '1','1','1');
