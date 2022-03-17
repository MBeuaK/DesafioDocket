CREATE DATABASE IF NOT EXISTS cartorio;

USE cartorio;


CREATE TABLE t_cartorio (
  id int AUTO_INCREMENT PRIMARY KEY,
  nome_cartorio varchar(255),
  endereco varchar(255),
  fk_certidao varchar(255),
);


CREATE TABLE t_certidao (
  id int AUTO_INCREMENT PRIMARY KEY,
  nome_certidao varchar(255),
);

INSERT INTO t_cartorio VALUES
	(null, 'Cartorio Teste', 'Rua das Laranjeiras', '1'); 