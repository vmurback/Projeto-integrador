CREATE TABLE `tb_usuario` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`userCasal` varchar(30) NOT NULL,
	`email` varchar(255) NOT NULL UNIQUE,
	`senha` varchar(255) NOT NULL,
	`nomeCompleto_1` varchar(255) NOT NULL,
	`nomeCompleto_2` varchar(255) NOT NULL,
	`sexo_1` varchar(9) NOT NULL,
	`sexo_2` varchar(9) NOT NULL,
	`nasc_1` DATE NOT NULL,
	`nasc_2` DATE NOT NULL,
	`pontuacao` DECIMAL,
	`notificacao` bigint,
	PRIMARY KEY (`id`)
);

CREATE TABLE `tb_postagem` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`corpoMsg` varchar(999) NOT NULL,
	`curtir` int,
	`data` DATETIME NOT NULL,
	`arquivoAnexo` longblob,
	`marcarUsuario` varchar(255),
	`usuario_id` bigint NOT NULL,
	`tema_id` bigint NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `tb_tema` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`desafio` varchar(255) NOT NULL,
	`descricao` varchar(255) NOT NULL,
	`pontuacao` DECIMAL NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `tb_usuario` ADD CONSTRAINT `tb_usuario_fk0` FOREIGN KEY (`notificacao`) REFERENCES `tb_postagem`(`id`);

ALTER TABLE `tb_postagem` ADD CONSTRAINT `tb_postagem_fk0` FOREIGN KEY (`usuario_id`) REFERENCES `tb_usuario`(`id`);

ALTER TABLE `tb_postagem` ADD CONSTRAINT `tb_postagem_fk1` FOREIGN KEY (`tema_id`) REFERENCES `tb_tema`(`id`);

