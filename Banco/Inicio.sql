-- Comentário 
-- Criar banco
-- unique (fazer o campo único, ter só um login brossini por exemplo.
-- auto_increment (o id ser gerado automaticamente)
-- timestamp default current_timestamp (ao fazer insert ele puxa a data e hora do servidor automaticamente)
-- escolher o banco
USE dbinfox;
create table tbusuarios(
iduser int primary key,
usuario varchar(50) not null,
telefone varchar(15),
login varchar(15) not null unique,
senha varchar(15) not null
);
-- descrever table
describe tbusuarios;

insert into tbusuarios (iduser,usuario,telefone,login,senha) values (1,'Ivania Lilia','9999-9999','vcardoso','mudar123');
insert into tbusuarios (iduser,usuario,telefone,login,senha) values (2,'Luis Claudio','9999-9999','lrossini','mudar123');
insert into tbusuarios (iduser,usuario,telefone,login,senha) values (3,'Administrador','9999-9999','useradm','adm');
insert into tbusuarios (iduser,usuario,telefone,login,senha) values (4,'Bruna Rossini','9999-9999','brossini','123');
select * from tbusuarios;

update tbusuarios set telefone='11 98604-0405' where iduser=4;
update tbusuarios set telefone='8888-8888' where iduser=2;

create table tbclientes (
idclient int primary key auto_increment,
nomeclient varchar(50) not null,
enderecoclient varchar(100) not null,
telefoneclient varchar(50) not null,
emailclient varchar(50)
);
describe tbclientes;
insert into  tbclientes (nomeclient,enderecoclient,telefoneclient,emailclient) values ('Maria Cardoso','Av dos Lagos,205','9999-9999','mariac@gmail.com');
select * from tbclientes;

create table tbordemservico(
os int primary key auto_increment,
data_os timestamp default current_timestamp,
equipamento varchar(150) not null,
defeito varchar(150) not null,
servico varchar(150),
tecnico varchar(50) not null,
orcamento decimal(10,2),
idclient int not null,
foreign key (idclient) references tbclientes(idclient)
);

describe tbordemservico;
insert into tbordemservico (equipamento,defeito,servico,tecnico,orcamento,idclient)
values ('Notebook Asus XYZ','Sistema operacional Windows XP não carrega','Recuperar HD e instalar novo Sistema Operacional','Bruna',326.50,1);

select * from tbordemservico;

-- inserts 

select 
O.os,equipamento,defeito,servico,orcamento,
C.nomeclient,telefoneclient
from tbordemservico as O inner join tbclientes as C
-- quando for igual o id do cliente em ambas as tabelas. 
on (O.idclient = C.idclient);





