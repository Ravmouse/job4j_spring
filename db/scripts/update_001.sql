CREATE TABLE accidents (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255),
  text VARCHAR(2000),
  address VARCHAR(255)
);
INSERT INTO accidents (name, text, address) VALUES ('Авария', 'Событие, которое произошло...', 'г. Васюки');
INSERT INTO accidents (name, text, address) VALUES ('Кража', 'Кража денег произошла...', 'с. Збруевка');
INSERT INTO accidents (name, text, address) VALUES ('Мошенничество', 'В минувшую среду сотрудниками по борьбе...', 'г. Клин');