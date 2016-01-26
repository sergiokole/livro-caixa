/*
SQLyog Enterprise - MySQL GUI v6.5
MySQL - 5.5.32 : Database - livro_caixa_2
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

create database if not exists `livro_caixa_2`;

USE `livro_caixa_2`;

/*Table structure for table `banco` */

DROP TABLE IF EXISTS `banco`;

CREATE TABLE `banco` (
  `codigo` smallint(6) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `apelido` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `banco` */

/*Table structure for table `banco_agencia_contas` */

DROP TABLE IF EXISTS `banco_agencia_contas`;

CREATE TABLE `banco_agencia_contas` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `banco_codigo` smallint(6) NOT NULL,
  `agencia` varchar(5) NOT NULL,
  `agencia_digito` tinyint(4) DEFAULT NULL,
  `numero_conta` varchar(10) NOT NULL,
  `conta_digito` tinyint(4) DEFAULT NULL,
  `codigo_conta` varchar(3) DEFAULT NULL,
  `poupanca` tinyint(1) NOT NULL,
  `titular_conta` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `IX_AGENCIA` (`agencia`,`numero_conta`,`poupanca`),
  KEY `FK_BANCO_CODIGO` (`banco_codigo`),
  CONSTRAINT `FK_BANCO_CODIGO` FOREIGN KEY (`banco_codigo`) REFERENCES `banco` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `banco_agencia_contas` */

/*Table structure for table `canal_atendimento` */

DROP TABLE IF EXISTS `canal_atendimento`;

CREATE TABLE `canal_atendimento` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `canal_atendimento` */

insert  into `canal_atendimento`(`id`,`nome`) values (1,'Internet Banking'),(2,'App Celular'),(3,'Caixa Eletrônico'),(4,'Caixa Presencial'),(5,'Telefone');

/*Table structure for table `cartao_credito` */

DROP TABLE IF EXISTS `cartao_credito`;

CREATE TABLE `cartao_credito` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `empresa` varchar(255) NOT NULL,
  `bandeira` varchar(45) NOT NULL,
  `validade` date NOT NULL,
  `dia_fechamento` tinyint(4) NOT NULL,
  `dia_vencimento` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `cartao_credito` */

/*Table structure for table `conta` */

DROP TABLE IF EXISTS `conta`;

CREATE TABLE `conta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` text NOT NULL,
  `tipo_conta` tinyint(1) NOT NULL,
  `grupo_conta_id` int(11) NOT NULL,
  `grupo_despesa_id` smallint(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_GRUPO_DESPESAS` (`grupo_despesa_id`),
  KEY `FK_GRUPO_CONTA` (`grupo_conta_id`),
  CONSTRAINT `FK_GRUPO_CONTA` FOREIGN KEY (`grupo_conta_id`) REFERENCES `grupo_conta` (`id`),
  CONSTRAINT `FK_GRUPO_DESPESAS` FOREIGN KEY (`grupo_despesa_id`) REFERENCES `grupo_despesas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `conta` */

/*Table structure for table `conta_bancaria` */

DROP TABLE IF EXISTS `conta_bancaria`;

CREATE TABLE `conta_bancaria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_movimentacao` tinyint(1) NOT NULL,
  `banco_id` smallint(6) NOT NULL,
  `operacao_bancaria_id` smallint(6) NOT NULL,
  `canal_atendimento_id` smallint(6) DEFAULT NULL,
  `data` date NOT NULL,
  `valor` decimal(10,2) NOT NULL,
  `descricao` text,
  PRIMARY KEY (`id`),
  KEY `FK_BANCO_AGENCIA_CONTAS` (`banco_id`),
  KEY `FK_OPERACAO_BANCARIA` (`operacao_bancaria_id`),
  KEY `FK_CANAL_ATENDIMENTO` (`canal_atendimento_id`),
  CONSTRAINT `FK_CANAL_ATENDIMENTO` FOREIGN KEY (`canal_atendimento_id`) REFERENCES `canal_atendimento` (`id`),
  CONSTRAINT `FK_BANCO_AGENCIA_CONTAS` FOREIGN KEY (`banco_id`) REFERENCES `banco_agencia_contas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_OPERACAO_BANCARIA` FOREIGN KEY (`operacao_bancaria_id`) REFERENCES `operacao_bancaria` (`id`),
  CONSTRAINT `FK_PAGAMENTOS` FOREIGN KEY (`id`) REFERENCES `pagamentos` (`conta_bancaria_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `conta_bancaria` */

/*Table structure for table `conta_item` */

DROP TABLE IF EXISTS `conta_item`;

CREATE TABLE `conta_item` (
  `id` int(11) NOT NULL,
  `conta_id` int(11) NOT NULL,
  `empresa_pessoa` text NOT NULL,
  `descricao` text NOT NULL,
  `lancamento` date NOT NULL,
  `valor` decimal(10,2) NOT NULL,
  `dia_vencimento` tinyint(4) NOT NULL,
  `referencia_id` smallint(6) NOT NULL,
  `recorrencia_id` smallint(6) NOT NULL,
  `meio_pagamento_id` smallint(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_CONTA` (`conta_id`),
  KEY `FK_MEIO_PAGAMENTO` (`meio_pagamento_id`),
  CONSTRAINT `FK_CONTA` FOREIGN KEY (`conta_id`) REFERENCES `conta` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_MEIO_PAGAMENTO` FOREIGN KEY (`meio_pagamento_id`) REFERENCES `meio_pagamento` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `conta_item` */

/*Table structure for table `dinheiro` */

DROP TABLE IF EXISTS `dinheiro`;

CREATE TABLE `dinheiro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_movimentacao` tinyint(1) NOT NULL,
  `data` date NOT NULL,
  `valor` decimal(10,2) NOT NULL,
  `descricao` text,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_PAGAMENTOS_DINHEIRO` FOREIGN KEY (`id`) REFERENCES `pagamentos` (`dinheiro_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `dinheiro` */

/*Table structure for table `grupo_conta` */

DROP TABLE IF EXISTS `grupo_conta`;

CREATE TABLE `grupo_conta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `grupo_conta` */

insert  into `grupo_conta`(`id`,`nome`) values (1,'Moradia'),(2,'Alimentação'),(3,'Veículo'),(4,'Serviços Financeiros'),(5,'Lazer'),(6,'Pessoais'),(7,'Saúde'),(9,'Transporte');

/*Table structure for table `grupo_despesas` */

DROP TABLE IF EXISTS `grupo_despesas`;

CREATE TABLE `grupo_despesas` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `grupo_despesas` */

insert  into `grupo_despesas`(`id`,`nome`) values (1,'Gastos Essenciais'),(2,'Estilo de Vida'),(3,'Prioridade Financeira');

/*Table structure for table `meio_pagamento` */

DROP TABLE IF EXISTS `meio_pagamento`;

CREATE TABLE `meio_pagamento` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `agrupador_pagamento` tinyint(1) NOT NULL,
  `cartao_credito_id` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_CARTAO_CREDITO` (`cartao_credito_id`),
  CONSTRAINT `FK_CARTAO_CREDITO` FOREIGN KEY (`cartao_credito_id`) REFERENCES `cartao_credito` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `meio_pagamento` */

/*Table structure for table `movimentacao` */

DROP TABLE IF EXISTS `movimentacao`;

CREATE TABLE `movimentacao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `conta_item_id` int(11) NOT NULL,
  `data` date NOT NULL,
  `vencimento` date NOT NULL,
  `valor` decimal(10,2) NOT NULL,
  `referencia` varchar(255) NOT NULL,
  `parcelas` smallint(6) DEFAULT NULL,
  `numero_parcela` smallint(6) DEFAULT NULL,
  `valor_parcela` decimal(10,2) DEFAULT NULL,
  `observacao` longtext,
  PRIMARY KEY (`id`),
  KEY `FK_CONTA_ITEM` (`conta_item_id`),
  CONSTRAINT `FK_CONTA_ITEM` FOREIGN KEY (`conta_item_id`) REFERENCES `conta_item` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `movimentacao` */

/*Table structure for table `operacao_bancaria` */

DROP TABLE IF EXISTS `operacao_bancaria`;

CREATE TABLE `operacao_bancaria` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `operacao_bancaria` */

insert  into `operacao_bancaria`(`id`,`nome`) values (1,'Saque'),(2,'TED'),(3,'DOC'),(4,'Transferência Mesmo Banco'),(5,'Depósito'),(6,'Pagamentos'),(7,'Cartão Débito'),(8,'Débito Automático'),(9,'Crédito em conta');

/*Table structure for table `operacao_bancaria_por_canal` */

DROP TABLE IF EXISTS `operacao_bancaria_por_canal`;

CREATE TABLE `operacao_bancaria_por_canal` (
  `operacao_bancaria_id` smallint(6) NOT NULL,
  `canal_atendimento_id` smallint(6) DEFAULT NULL,
  UNIQUE KEY `IX_OPERCAO_BANCARIA_POR_CANAL` (`operacao_bancaria_id`,`canal_atendimento_id`),
  KEY `FK_CANAL_ATENDIMENTO_POR_OPERACAO_BANCARIA` (`canal_atendimento_id`),
  CONSTRAINT `FK_CANAL_ATENDIMENTO_POR_OPERACAO_BANCARIA` FOREIGN KEY (`canal_atendimento_id`) REFERENCES `canal_atendimento` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_OPERACAO_BANCARIA_POR_CANAL_ATENDIMENTO` FOREIGN KEY (`operacao_bancaria_id`) REFERENCES `operacao_bancaria` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `operacao_bancaria_por_canal` */

insert  into `operacao_bancaria_por_canal`(`operacao_bancaria_id`,`canal_atendimento_id`) values (1,3),(1,4),(2,1),(2,2),(2,3),(2,4),(3,1),(3,2),(3,3),(3,4),(4,1),(4,2),(4,3),(4,4),(5,3),(5,4),(6,1),(6,2),(6,3),(6,4);

/*Table structure for table `pagamentos` */

DROP TABLE IF EXISTS `pagamentos`;

CREATE TABLE `pagamentos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `movimentacao_id` int(11) NOT NULL,
  `data_pagamento` date NOT NULL,
  `valor_pago` decimal(10,2) NOT NULL,
  `conta_bancaria_id` int(11) DEFAULT NULL,
  `dinheiro_id` int(11) DEFAULT NULL,
  `porquinho_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_MOVIMENTACAO` (`movimentacao_id`),
  KEY `IX_CONTA_BANCARIA` (`conta_bancaria_id`),
  KEY `IX_DINHEIRO` (`dinheiro_id`),
  KEY `IX_PORQUINHO` (`porquinho_id`),
  CONSTRAINT `FK_MOVIMENTACAO` FOREIGN KEY (`movimentacao_id`) REFERENCES `movimentacao` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `pagamentos` */

/*Table structure for table `porquinho` */

DROP TABLE IF EXISTS `porquinho`;

CREATE TABLE `porquinho` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_movimentacao` tinyint(1) NOT NULL,
  `data` date NOT NULL,
  `valor` decimal(10,2) NOT NULL,
  `descricao` text,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_PAGAMENTOS_PORQUINHO` FOREIGN KEY (`id`) REFERENCES `pagamentos` (`porquinho_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `porquinho` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
