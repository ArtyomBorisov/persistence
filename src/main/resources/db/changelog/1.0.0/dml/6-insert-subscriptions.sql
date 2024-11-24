--liquibase formatted sql
--changeset author:Artyom 6-insert-subscriptions

INSERT INTO SUBSCRIPTION (ID, TITLE, DESCRIPTION)
VALUES ('b285fde5-64f7-444a-aa41-267bbfe9442b', 'SMS-оповещение', null),
       ('36d84860-a6ce-4996-805a-83b5e5f503ba', 'Интернет-банкинг', null),
       ('faf5d4c0-1599-44fb-a5db-1a694e6a60d8', 'Овердрафт', null),
       ('1cea0597-9e85-41a1-9e4a-8483060943b7', 'Ежемесячная выписка', 'Ежемесячная расшифровка списаний и начислений'),
       ('0414a80b-5ff1-4ac8-a875-9722bdd0a865', 'Копилка', 'Возможность накопления');

INSERT INTO ACCOUNT_SUBSCRIPTION (ACCOUNT_ID, SUBSCRIPTION_ID)
VALUES ('d3b8f2e4-7c5e-4b7c-bc1b-8c9c8f1e1f4a', 'b285fde5-64f7-444a-aa41-267bbfe9442b'),
       ('d3b8f2e4-7c5e-4b7c-bc1b-8c9c8f1e1f4a', '36d84860-a6ce-4996-805a-83b5e5f503ba'),
       ('d3b8f2e4-7c5e-4b7c-bc1b-8c9c8f1e1f4a', 'faf5d4c0-1599-44fb-a5db-1a694e6a60d8'),
       ('f6e1c4b2-e6f8-4e2a-9a4e-9f6b3a0f3e2b', '1cea0597-9e85-41a1-9e4a-8483060943b7'),
       ('f6e1c4b2-e6f8-4e2a-9a4e-9f6b3a0f3e2b', '0414a80b-5ff1-4ac8-a875-9722bdd0a865'),
       ('2a5c9d91-6b0b-4b36-bf4c-5c7b1d9e6c15', 'b285fde5-64f7-444a-aa41-267bbfe9442b'),
       ('2a5c9d91-6b0b-4b36-bf4c-5c7b1d9e6c15', '36d84860-a6ce-4996-805a-83b5e5f503ba'),
       ('2a5c9d91-6b0b-4b36-bf4c-5c7b1d9e6c15', 'faf5d4c0-1599-44fb-a5db-1a694e6a60d8'),
       ('2a5c9d91-6b0b-4b36-bf4c-5c7b1d9e6c15', '1cea0597-9e85-41a1-9e4a-8483060943b7'),
       ('2a5c9d91-6b0b-4b36-bf4c-5c7b1d9e6c15', '0414a80b-5ff1-4ac8-a875-9722bdd0a865'),
       ('a7d5f3b9-3f45-4e3d-b3c0-3d9a2c6b4a7e', 'b285fde5-64f7-444a-aa41-267bbfe9442b'),
       ('9a1f4d82-2e3c-4a89-a7f5-0e5d6f1e3b8a', '36d84860-a6ce-4996-805a-83b5e5f503ba'),
       ('c2e5d8a7-8c3d-4f1b-b8e0-5a1f9c7d3b2e', 'faf5d4c0-1599-44fb-a5db-1a694e6a60d8'),
       ('4f7e8d92-2a6c-4bcb-bec7-2b8e0d5f1c5a', '1cea0597-9e85-41a1-9e4a-8483060943b7'),
       ('0c1e2d3f-4b5a-48a5-b6f9-e2a7b3c1d8e0', '0414a80b-5ff1-4ac8-a875-9722bdd0a865'),
       ('8b6f4d1a-b8d0-44e6-a9e1-d5c0b2a7e4f9', '36d84860-a6ce-4996-805a-83b5e5f503ba'),
       ('8b6f4d1a-b8d0-44e6-a9e1-d5c0b2a7e4f9', 'faf5d4c0-1599-44fb-a5db-1a694e6a60d8'),
       ('8b6f4d1a-b8d0-44e6-a9e1-d5c0b2a7e4f9', '1cea0597-9e85-41a1-9e4a-8483060943b7'),
       ('8b6f4d1a-b8d0-44e6-a9e1-d5c0b2a7e4f9', '0414a80b-5ff1-4ac8-a875-9722bdd0a865');