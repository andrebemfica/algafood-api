insert into cozinha (id, nome) values (1, 'Brasileira');
insert into cozinha (id, nome) values (2, 'Francesa');

insert into estado (nome) values ('Para');
insert into estado (nome) values ('Amapa');

insert into cidade (nome, estado_id) values ('Monte Dourado', 1);
insert into cidade (nome, estado_id) values ('Belem', 1);
insert into cidade (nome, estado_id) values ('Macapa', 2);

insert into restaurante (nome, taxa_frete, cozinha_id, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro) values ('Bem10', 6.50, 1, 1, '66050-350', 'Municipalidade', '1000', 'Umarizal');
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Bemfis', 8.50, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('BemGuedes', 10.50, 2);

insert into forma_pagamento (descricao) values ('Credito');
insert into forma_pagamento (descricao) values ('Debito');
insert into forma_pagamento (descricao) values ('Pix');

insert into permissao (nome, descricao) values ('Consultar Produtos', 'Permite fazer consulta de produtos');
insert into permissao (nome, descricao) values ('Consultar Cozinha', 'Permite fazer consulta de cozinhas');

insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1, 1), (1, 2), (1, 3), (2, 3), (3, 2), (3, 3);