--liquibase formatted sql

--changeset javify:4 labels:schema
--comment Adiciona constraint de validacao de preco negativo - esquecida no changeset 1

ALTER TABLE plano
   ADD CONSTRAINT chk_plano_preco_nao_negativo
       CHECK (preco >= 0);

--rollback ALTER TABLE plano DROP CONSTRAINT chk_plano_preco_nao_negativo;
