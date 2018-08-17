DELETE FROM fines;
DELETE FROM cars;
DELETE FROM users;
DELETE FROM duty;

ALTER SEQUENCE seq_duty  RESTART WITH 1;
ALTER SEQUENCE seq_users RESTART WITH 1;
ALTER SEQUENCE seq_cars  RESTART WITH 1;
ALTER SEQUENCE seq_fines RESTART WITH 1;

-------------------

INSERT INTO duty (name, price) VALUES
  ('Парковка в неположенном месте',              1000),
  ('Превышение установленной скорости движения', 1500),
  ('Управление в нетрезвом виде',                2000),
  ('Проезд на запрещающий сигнал светофора',     2500),
  ('Тонирование передних и лобового стекол',     3000);

INSERT INTO users (name, patronymic, surname, license_number) VALUES
  ('Максимилиан', 'Александрович', 'Волошин',     'GA5763FWA'),
  ('Владимир',    'Васильевич',    'Гиппиус',     'MH7731BYW'),
  ('Осип',        'Эмильевич',     'Мандельштам', 'LN5214YKQ'),
  ('Борис',       'Леонидович',    'Пастернак',   'MA4012QIB'),
  ('Александр',   'Трифонович',    'Твардовский', 'BM8531WBM');

INSERT INTO cars (brand, model, gov_number, user_id) VALUES
  ('Skoda',   'Octavia',  'А564ФУ 70', 1),
  ('Renault', 'Duster',   'М283ЕУ 70', 2),
  ('Kia',     'Sportage', 'Е884ИТ 70', 3),
  ('Hyundai', 'Creta',    'К121ЮА 70', 4),
  ('Lada',    'Priora',   'Ш433СО 70', 5);

INSERT INTO fines (car_id, duty_id) VALUES
  (1, 1),
  (1, 2),
  (1, 3),

  (2, 1),
  (2, 1),

  (3, 4),
  (3, 5),

  (4, 2),
  (4, 2),
  (4, 2),
  (4, 4),

  (5, 1);


