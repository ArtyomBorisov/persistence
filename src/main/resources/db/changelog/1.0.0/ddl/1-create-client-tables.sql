--liquibase formatted sql
--changeset author:Artyom 1-create-client-tables

CREATE TABLE CLIENT (
    ID                    UUID,
    IDENTIFICATION_NUMBER VARCHAR(50) NOT NULL,
    PRIMARY KEY (ID)
);
COMMENT ON TABLE CLIENT IS 'Информация о клиенте';

CREATE TABLE CLIENT_INFO (
    ID        UUID,
    CLIENT_ID UUID        NOT NULL,
    NAME      VARCHAR(50) NOT NULL,
    SURNAME   VARCHAR(50) NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (CLIENT_ID) REFERENCES CLIENT (ID)
);
COMMENT ON TABLE CLIENT_INFO IS 'Информация о клиенте (дополнительная)';