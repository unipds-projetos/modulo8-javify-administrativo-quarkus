--liquibase formatted sql

--changeset javify:2 labels:schema
--comment Adiciona campo de descricao de marketing ao plano

ALTER TABLE plano
   ADD COLUMN descricao VARCHAR(500);

--rollback ALTER TABLE plano DROP COLUMN descricao;
