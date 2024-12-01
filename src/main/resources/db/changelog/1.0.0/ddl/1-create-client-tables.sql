--liquibase formatted sql
--changeset author:Artyom 1-create-client-tables

CREATE TABLE CLIENT_INFO (
    ID        UUID,
    NAME      VARCHAR(50) NOT NULL,
    SURNAME   VARCHAR(50) NOT NULL,
    PRIMARY KEY (ID)
);
COMMENT ON TABLE CLIENT_INFO IS 'Информация о клиенте (дополнительная)';

CREATE TABLE CLIENT (
    ID                    UUID,
    CLIENT_INFO_ID        UUID        NOT NULL,
    IDENTIFICATION_NUMBER VARCHAR(50) NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (CLIENT_INFO_ID) REFERENCES CLIENT_INFO (ID)
);
COMMENT ON TABLE CLIENT IS 'Информация о клиенте';

