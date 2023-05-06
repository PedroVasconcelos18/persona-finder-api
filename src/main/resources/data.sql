CREATE SCHEMA IF NOT EXISTS persona_finder;
CREATE TYPE type_user_enum AS ENUM('STUDENT', 'PERSONAL');

CREATE TABLE T_USER
(
    id         UUID PRIMARY KEY,
    name       VARCHAR(50),
    email      VARCHAR(100),
    password   varchar(100),
    created_at TIMESTAMP,
    deleted_at TIMESTAMP,
    updated_at TIMESTAMP,
    type_user  type_user_enum
);

CREATE TABLE T_TRAINING_SHEET
(
    id          UUID PRIMARY KEY,
    start_date  DATE,
    end_date    DATE,
    description TEXT,
    created_at  TIMESTAMP,
    deleted_at  TIMESTAMP,
    updated_at  TIMESTAMP,
    fk_student  INTEGER REFERENCES T_USER (id),
    fk_personal INTEGER REFERENCES T_USER (id)
);

CREATE TABLE T_PERSONAL_STUDENT
(
    id          UUID PRIMARY KEY,
    fk_personal INTEGER REFERENCES T_USER (id),
    fk_student  INTEGER REFERENCES T_USER (id)
);
