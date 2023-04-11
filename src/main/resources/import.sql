insert into cozinha (id, nome) values (1, 'Brasileira');
insert into cozinha (id, nome) values (2, 'Francesa');

insert into restaurante (nome, taxa_frete, cozinha_id) values ('Bem10', 6.50, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Bemfis', 8.50, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('BemGuedes', 10.50, 2);

insert into forma_pagamento (descricao) values ('Credito');
insert into forma_pagamento (descricao) values ('Debito');
insert into forma_pagamento (descricao) values ('Pix');

insert into permissao (nome, descricao) values ('Consultar Produtos', 'Permite fazer consulta de produtos');
insert into permissao (nome, descricao) values ('Consultar Cozinha', 'Permite fazer consulta de cozinhas');

insert into estado (nome) values ('Pará');
insert into estado (nome) values ('Amapá');

insert into cidade (nome, estado_id) values ('Monte Dourado', 1);
insert into cidade (nome, estado_id) values ('Belém', 1);
insert into cidade (nome, estado_id) values ('Macapá', 2);