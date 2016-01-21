ALTER TABLE `livro_caixa_2`.`operacao_bancaria_por_canal` 
	DROP FOREIGN KEY `FK_OPERACAO_BANCARIA_ID` , 
	DROP FOREIGN KEY `FK_CANAL_ATENDIMENTO_ID` ;

ALTER TABLE `livro_caixa_2`.`operacao_bancaria_por_canal` 
	DROP COLUMN `data` , 
	ADD COLUMN `id` SMALLINT NOT NULL AUTO_INCREMENT  FIRST , 
	DROP PRIMARY KEY , 
	ADD PRIMARY KEY (`id`) , 
	DROP INDEX `FK_CANAL_ATENDIMENTO_ID` ;

ALTER TABLE `livro_caixa_2`.`operacao_bancaria_por_canal` 
	ADD CONSTRAINT `FK_POR_OPERACAO_BANCARIA` FOREIGN KEY (`operacao_bancaria_id` ) 
		REFERENCES `livro_caixa_2`.`operacao_bancaria` (`id` ) 
		ON DELETE NO ACTION ON UPDATE NO ACTION , 
 	ADD CONSTRAINT `FK_POR_CANAL_ATENDIMENTO` FOREIGN KEY (`canal_atendimento_id` )
 		REFERENCES `livro_caixa_2`.`canal_atendimento` (`id` )
		ON DELETE NO ACTION ON UPDATE NO ACTION , 
	ADD INDEX `FK_POR_OPERACAO_BANCARIA` (`operacao_bancaria_id` ASC) , 
	ADD INDEX `FK_POR_CANAL_ATENDIMENTO` (`canal_atendimento_id` ASC) ;


