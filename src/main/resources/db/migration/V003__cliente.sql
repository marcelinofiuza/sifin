CREATE TABLE cliente (
  id_cliente bigint(20) NOT NULL AUTO_INCREMENT,
  zempresa bigint(20) DEFAULT NULL,
  cnpj varchar(18) DEFAULT NULL,
  cpf varchar(14) DEFAULT NULL,
  bairro varchar(40) DEFAULT NULL,
  cep varchar(9) DEFAULT NULL,
  cidade varchar(40) DEFAULT NULL,
  complemento varchar(20) DEFAULT NULL,
  logradouro varchar(50) DEFAULT NULL,
  numero varchar(10) DEFAULT NULL,
  tipo_logradouro varchar(15) DEFAULT NULL,
  uf varchar(2) DEFAULT NULL,
  fantasia varchar(40) NOT NULL,
  ins_estadual varchar(15) DEFAULT NULL,
  ins_municipal varchar(15) DEFAULT NULL,
  razao_social varchar(80) NOT NULL,
  unidade varchar(15) DEFAULT NULL,
  id_conta bigint(20) DEFAULT NULL,
  PRIMARY KEY (id_cliente),
  KEY (id_conta),
  CONSTRAINT FOREIGN KEY (id_conta) REFERENCES conta (id_conta),
  CONSTRAINT FOREIGN KEY (id_conta) REFERENCES conta (id_conta)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE cliente_contatos (
  id_contato bigint(20) NOT NULL AUTO_INCREMENT,
  zempresa bigint(20) DEFAULT NULL,
  celular varchar(15) DEFAULT NULL,
  email varchar(100) DEFAULT NULL,
  nome_contato varchar(50) DEFAULT NULL,
  ramal varchar(5) DEFAULT NULL,
  telefone varchar(15) DEFAULT NULL,
  id_cliente bigint(20) DEFAULT NULL,
  PRIMARY KEY (id_contato),
  KEY id_cliente (id_cliente),
  CONSTRAINT FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente),
  CONSTRAINT FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente)
) ENGINE=InnoDB DEFAULT CHARSET=utf8