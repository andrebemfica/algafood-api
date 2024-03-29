insert into cozinha (nome) values ('Paraense');
insert into cozinha (nome) values ('Francesa');
insert into cozinha (nome) values ('Argentina');
insert into cozinha (nome) values ('Brasileira');

insert into estado (nome) values ('Para');
insert into estado (nome) values ('Amapa');

insert into cidade (nome, estado_id) values ('Monte Dourado', 1);
insert into cidade (nome, estado_id) values ('Belem', 1);
insert into cidade (nome, estado_id) values ('Macapa', 2);

insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro) values ('Bem10', 6.50, 1, utc_timestamp, utc_timestamp, 1, '66050-350', 'Municipalidade', '1000', 'Umarizal');
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Bemfis', 8.50, 1, utc_timestamp, utc_timestamp);
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('BemGuedes', 10.50, 2, utc_timestamp, utc_timestamp);
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Java Steakhouse', 12, 3, utc_timestamp, utc_timestamp);
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Lanchonete do Tio Sam', 11, 4, utc_timestamp, utc_timestamp);
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Bar da Maria', 6, 4, utc_timestamp, utc_timestamp);

insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Churrasco', 'Picanha no ponto', 58.80, true, 1);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Feijoada', 'Do mestre Bem', 48.60, true, 2);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Pizza', 'Melhor de Belém', 68.20, true, 3);

insert into forma_pagamento (descricao) values ('Credito');
insert into forma_pagamento (descricao) values ('Debito');
insert into forma_pagamento (descricao) values ('Pix');

insert into permissao (nome, descricao) values ('Consultar Produtos', 'Permite fazer consulta de produtos');
insert into permissao (nome, descricao) values ('Consultar Cozinha', 'Permite fazer consulta de cozinhas');

insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1, 1), (1, 2), (1, 3), (2, 3), (3, 2), (3, 3), (4, 1), (4, 2), (5, 1), (5, 2), (6, 3);