use dbSeguranca;

insert into tb_sistema(nm_sistema,ds_url) 
values ('Sistema Ecommerce','http://localhost:8080/SistemaEcommerce/'),
	   ('Seguranca','http://localhost:8080/Seguranca/menu.html');

update tb_sistema
set ds_url = 'http://localhost:8080/Seguranca/menu.html'
where cd_sistema = 2; -- verifique se o sistema de segurança possui código 2

insert into tb_usuario(ds_login,fl_ativo,ds_email,ds_senha)
values ('carloseduardo',1,'carloseduardodantas@iftm.edu.br','e4UXW0VQYOMjfpJfAjBTypUV6Ggqg8iwmRHHJKH4t18='),
       ('bruno',1,'bruno@iftm.edu.br','pmWkWSBCL51Bfkhn79xPuKBKHz//H6B+mY6G9/eieuM=');
       
       -- carlos
       -- 123
       
insert into tb_role(nm_role,cd_sistema)
values ('ECO_admin',1),
       ('ECO_cadastro',1),
       ('ECO_consulta',1),
       ('SEG_admin',2),
       ('SEG_cadastro',2),
       ('SEG_consulta',2);
       
insert into tb_usuario_role(cd_role,ds_login)
values (1,'bruno'),
       (4,'bruno'),
       (3,'carloseduardo'),
       (6,'carloseduardo'); 
       
	   