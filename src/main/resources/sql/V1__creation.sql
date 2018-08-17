DROP TABLE IF EXISTS fines;
DROP TABLE IF EXISTS cars;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS duty;

DROP SEQUENCE IF EXISTS seq_duty;
DROP SEQUENCE IF EXISTS seq_users;
DROP SEQUENCE IF EXISTS seq_cars;
DROP SEQUENCE IF EXISTS seq_fines;

-------------------

CREATE SEQUENCE seq_duty START 1;

CREATE TABLE duty (
  id             INTEGER   PRIMARY KEY DEFAULT nextval('seq_duty'),
  name           VARCHAR   NOT NULL,
  price          INTEGER   NOT NULL,
  version        INTEGER   NOT NULL DEFAULT 0
);

-------------------

CREATE SEQUENCE seq_users START 1;

CREATE TABLE users (
  id             INTEGER   PRIMARY KEY DEFAULT nextval('seq_users'),
  name           VARCHAR   NOT NULL,
  patronymic     VARCHAR   NOT NULL,
  surname        VARCHAR   NOT NULL,
  license_number VARCHAR   NOT NULL,
  version        INTEGER   NOT NULL DEFAULT 0
);

CREATE UNIQUE INDEX unique_users ON users (license_number);

-------------------

CREATE SEQUENCE seq_cars START 1;

CREATE TABLE cars (
  id             INTEGER   PRIMARY KEY DEFAULT nextval('seq_cars'),
  brand          VARCHAR   NOT NULL,
  model          VARCHAR   NOT NULL,
  gov_number     VARCHAR   NOT NULL,
  user_id        INTEGER   NOT NULL REFERENCES users ON DELETE CASCADE,
  version        INTEGER   NOT NULL DEFAULT 0
);

CREATE UNIQUE INDEX unique_cars ON cars (gov_number);

-------------------

CREATE SEQUENCE seq_fines START 1;

CREATE TABLE fines (
  id             INTEGER   PRIMARY KEY DEFAULT nextval('seq_fines'),
  car_id         INTEGER   NOT NULL REFERENCES cars ON DELETE CASCADE,
  duty_id        INTEGER   NOT NULL REFERENCES duty ON DELETE CASCADE,
  status         BOOLEAN   NOT NULL DEFAULT FALSE,
  version        INTEGER   NOT NULL DEFAULT 0
);
