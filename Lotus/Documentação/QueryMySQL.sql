CREATE TABLE `tb_usuario` (
	`id` bigint(400) NOT NULL AUTO_INCREMENT,
	`nome` varchar(100),
	`email` varchar(50) UNIQUE,
	`senha` varchar(10),
	`telefone` varchar(15),
	`endereco` varchar(255),
	`user` varchar(50),
	`foto` varchar(255) NOT NULL,
	`data_nasc` DATE,
	`genero` varchar(255) NOT NULL,
	`pessoa_fisica` BOOLEAN,
	`cpf` varchar(50) NOT NULL,
	`cnpj` varchar(255) NOT NULL,
	`pontuacao` int(10) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `tb_tema` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`tema` varchar(50) UNIQUE,
	`descricao` varchar(255) NOT NULL,
	`palavraChave` varchar(50) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `tb_postagem` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`mensagem` TEXT,
	`data_postagem` DATETIME NOT NULL,
	`titulo` varchar(255),
	`midia` varchar(255) NOT NULL,
	`usuario_id` bigint,
	`tema_id` bigint,
	PRIMARY KEY (`id`)
);

ALTER TABLE `tb_postagem` ADD CONSTRAINT `tb_postagem_fk0` FOREIGN KEY (`usuario_id`) REFERENCES `tb_usuario`(`id`);

ALTER TABLE `tb_postagem` ADD CONSTRAINT `tb_postagem_fk1` FOREIGN KEY (`tema_id`) REFERENCES `tb_tema`(`id`);

