--liquibase formatted sql
--changeset author:Artyom 2-create-account-tables

CREATE TABLE ACCOUNT (
    ID        UUID,
    CLIENT_ID UUID        NOT NULL,
    NUMBER    VARCHAR(50) NOT NULL,
    TYPE      VARCHAR(10) NOT NULL
    CHECK (TYPE IN ('BYN', 'USD', 'EUR')),
    PRIMARY KEY (ID),
    FOREIGN KEY (CLIENT_ID) REFERENCES CLIENT (ID)
);
COMMENT ON TABLE ACCOUNT IS 'Информация о расчетном счете';

CREATE TABLE BALANCE (
    ID     UUID,
    AMOUNT NUMERIC(10, 2) DEFAULT 0 NOT NULL,
    PRIMARY KEY(ID),
    FOREIGN KEY (ID) REFERENCES ACCOUNT (ID)
);
COMMENT ON TABLE BALANCE IS 'Информация о балансе';