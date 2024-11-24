--liquibase formatted sql
--changeset author:Artyom 5-insert-accounts

INSERT INTO ACCOUNT (ID, CLIENT_ID, NUMBER, TYPE)
VALUES ('d3b8f2e4-7c5e-4b7c-bc1b-8c9c8f1e1f4a', 'ebd124f7-a6b5-424a-8ea7-92ceb5a5ba4a', 'first', 'BYN'),
       ('f6e1c4b2-e6f8-4e2a-9a4e-9f6b3a0f3e2b', '798f6939-d635-47d9-a749-f9bbd8ff6382', 'second', 'BYN'),
       ('2a5c9d91-6b0b-4b36-bf4c-5c7b1d9e6c15', '798f6939-d635-47d9-a749-f9bbd8ff6382', 'third', 'USD'),
       ('a7d5f3b9-3f45-4e3d-b3c0-3d9a2c6b4a7e', '7fafbafa-905b-4115-ac5c-3fd01f1346d9', 'fourth', 'USD'),
       ('9a1f4d82-2e3c-4a89-a7f5-0e5d6f1e3b8a', '7fafbafa-905b-4115-ac5c-3fd01f1346d9', 'fifth', 'EUR'),
       ('c2e5d8a7-8c3d-4f1b-b8e0-5a1f9c7d3b2e', '7fafbafa-905b-4115-ac5c-3fd01f1346d9', 'sixth', 'EUR'),
       ('4f7e8d92-2a6c-4bcb-bec7-2b8e0d5f1c5a', '0faf5255-e9ac-46a4-a5f1-b195470d58b4', 'seventh', 'BYN'),
       ('0c1e2d3f-4b5a-48a5-b6f9-e2a7b3c1d8e0', '0faf5255-e9ac-46a4-a5f1-b195470d58b4', 'eighth', 'USD'),
       ('8b6f4d1a-b8d0-44e6-a9e1-d5c0b2a7e4f9', '0faf5255-e9ac-46a4-a5f1-b195470d58b4', 'ninth', 'EUR'),
       ('3e5d7b1a-9c3e-4f69-b0b8-f6e2a4c8d1a3', '0faf5255-e9ac-46a4-a5f1-b195470d58b4', 'tenth', 'BYN');

INSERT INTO BALANCE (ID, AMOUNT)
VALUES ('d3b8f2e4-7c5e-4b7c-bc1b-8c9c8f1e1f4a', 123.45),
       ('f6e1c4b2-e6f8-4e2a-9a4e-9f6b3a0f3e2b', 20000),
       ('2a5c9d91-6b0b-4b36-bf4c-5c7b1d9e6c15', 1456.5),
       ('a7d5f3b9-3f45-4e3d-b3c0-3d9a2c6b4a7e', 43243.4),
       ('9a1f4d82-2e3c-4a89-a7f5-0e5d6f1e3b8a', 12),
       ('c2e5d8a7-8c3d-4f1b-b8e0-5a1f9c7d3b2e', 0),
       ('4f7e8d92-2a6c-4bcb-bec7-2b8e0d5f1c5a', 55),
       ('0c1e2d3f-4b5a-48a5-b6f9-e2a7b3c1d8e0', 1000000),
       ('8b6f4d1a-b8d0-44e6-a9e1-d5c0b2a7e4f9', 0.05),
       ('3e5d7b1a-9c3e-4f69-b0b8-f6e2a4c8d1a3', 1350);