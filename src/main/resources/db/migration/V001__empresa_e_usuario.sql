CREATE TABLE empresa (
  id_empresa bigint(20) NOT NULL AUTO_INCREMENT,
  cnae varchar(9) DEFAULT NULL,
  cnpj varchar(18) DEFAULT NULL,
  celular varchar(15) DEFAULT NULL,
  email varchar(100) DEFAULT NULL,
  nome_contato varchar(50) DEFAULT NULL,
  ramal varchar(5) DEFAULT NULL,
  telefone varchar(15) DEFAULT NULL,
  cpf varchar(14) DEFAULT NULL,
  data_abertura date DEFAULT NULL,
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
  natureza_juridica varchar(5) DEFAULT NULL,
  ramo_atividade varchar(30) DEFAULT NULL,
  razao_social varchar(80) NOT NULL,
  PRIMARY KEY (id_empresa)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE usuario (
  id_usuario bigint(20) NOT NULL AUTO_INCREMENT,
  bloqueado bit(1) NOT NULL,
  credencial varchar(100) NOT NULL,
  nome varchar(50) NOT NULL,
  senha varchar(255) NOT NULL,
  ultimo_acesso date DEFAULT NULL,
  PRIMARY KEY (id_usuario),
  UNIQUE KEY (credencial)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE usuario_empresa (
  id_usuario bigint(20) NOT NULL,
  id_empresa bigint(20) NOT NULL,
  KEY (id_empresa),
  KEY (id_usuario),
  CONSTRAINT FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario),
  CONSTRAINT FOREIGN KEY (id_empresa) REFERENCES empresa (id_empresa)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE permissao (
	id_permissao BIGINT(20) PRIMARY KEY,
	descricao VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE usuario_permissao (
	id_usuario BIGINT(20) NOT NULL,
	id_permissao BIGINT(20) NOT NULL,
	PRIMARY KEY (id_usuario, id_permissao),
	FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
	FOREIGN KEY (id_permissao) REFERENCES permissao(id_permissao)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO permissao (id_permissao, descricao) values (1, 'ROLE_LER_EMPRESA');
INSERT INTO permissao (id_permissao, descricao) values (2, 'ROLE_SALVAR_EMPRESA');
INSERT INTO permissao (id_permissao, descricao) values (3, 'ROLE_EXCLUIR_EMPRESA');

INSERT INTO permissao (id_permissao, descricao) values (4, 'ROLE_LER_USUARIO');
INSERT INTO permissao (id_permissao, descricao) values (5, 'ROLE_SALVAR_USUARIO');
INSERT INTO permissao (id_permissao, descricao) values (6, 'ROLE_EXCLUIR_USUARIO');

INSERT INTO permissao (id_permissao, descricao) values (7, 'ROLE_LER_CLIENTE');
INSERT INTO permissao (id_permissao, descricao) values (8, 'ROLE_SALVAR_CLIENTE');
INSERT INTO permissao (id_permissao, descricao) values (9, 'ROLE_EXCLUIR_CLIENTE');

INSERT INTO empresa (id_empresa, cnae, cnpj, celular, email, nome_contato, ramal, telefone, cpf, bairro, cep, cidade, complemento, logradouro, numero, tipo_logradouro, uf, fantasia, ins_estadual, ins_municipal, natureza_juridica, ramo_atividade, razao_social) 
             values ('1', '', '27785787000109', '', '', '', '', '', '27466356826', 'VILA', '83305-000', 'PIRAQUARA', '556', 'JACOB', '123', 'AV', 'PR', 'MBFS', '', '', '', 'PRESTACAO_SERVICO', 'MARCELINO FIUZA');

INSERT INTO usuario (id_usuario, bloqueado, credencial, nome, senha) 
             values (1, false, 'admin@resvut42.com.br', 'Administrador', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.');

INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 1);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 2);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 3);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 4);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 5);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 6);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 7);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 8);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 9);

INSERT INTO usuario_empresa (id_usuario, id_empresa) values (1, 1);