--liquibase formatted sql
--changeset author:Artyom 4-insert-clients

INSERT INTO CLIENT (ID, IDENTIFICATION_NUMBER)
VALUES ('a8ee8326-12d3-480d-ab4a-114f870ac8cd', '1A'),
       ('ebd124f7-a6b5-424a-8ea7-92ceb5a5ba4a', '2B'),
       ('798f6939-d635-47d9-a749-f9bbd8ff6382', '3C'),
       ('7fafbafa-905b-4115-ac5c-3fd01f1346d9', '4D'),
       ('0faf5255-e9ac-46a4-a5f1-b195470d58b4', '5E');

INSERT INTO CLIENT_INFO (ID, CLIENT_ID, NAME, SURNAME)
VALUES ('ad5e2c6c-f68e-4681-8676-746dcba1f91c', 'a8ee8326-12d3-480d-ab4a-114f870ac8cd', 'Алексей', 'Иванов'),
       ('19465c60-4527-45fe-9623-18fa5019d06f', 'ebd124f7-a6b5-424a-8ea7-92ceb5a5ba4a', 'Мария', 'Петрова'),
       ('b3008031-9e95-4366-b595-dfba72982735', '798f6939-d635-47d9-a749-f9bbd8ff6382', 'Сергей', 'Смирнов'),
       ('ac90da8e-3289-4c6e-a5ba-993860be82d7', '7fafbafa-905b-4115-ac5c-3fd01f1346d9', 'Анна', 'Кузнецова'),
       ('0c92ed92-afed-4a93-bef9-d4677e724784', '0faf5255-e9ac-46a4-a5f1-b195470d58b4', 'Дмитрий', 'Сидоров');







