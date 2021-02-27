SET CLIENT_ENCODING = 'UTF-8';

INSERT INTO role (name)
VALUES ('ADMIN');
INSERT INTO role (name)
VALUES ('MODERATOR');
INSERT INTO role (name)
VALUES ('USER');

INSERT INTO userdata(age, firstname, lastname, middlename)
VALUES ('1991-02-05', 'Евгений', 'Сидоренко', 'Иванович');
INSERT INTO userdata(age, firstname, lastname, middlename)
VALUES ('1993-01-08', 'Михаил', 'Петров', 'Евгеньевич');
INSERT INTO userdata(age, firstname, lastname, middlename)
VALUES ('1995-12-10', 'Юрий', 'Астапенко', 'Валентинович');
INSERT INTO userdata(age, firstname, lastname, middlename)
VALUES ('2000-03-14', 'Валерий', 'Нитко', 'Леонидович');
INSERT INTO userdata(age, firstname, lastname, middlename)
VALUES ('1999-04-15', 'Иван', 'Чуп', 'Иванович');

INSERT INTO "user" (email, password, role_id, userdata_id)
VALUES ('admin@freebook.test', 'admin', 1, 1);
INSERT INTO "user" (email, password, role_id, userdata_id)
VALUES ('moderator1@freebook.test', 'moderator1', 2, 2);
INSERT INTO "user" (email, password, role_id, userdata_id)
VALUES ('moderator2@freebook.test', 'moderator2', 2, 3);
INSERT INTO "user" (email, password, role_id, userdata_id)
VALUES ('user1@freebook.test', 'user1', 3, 4);
INSERT INTO "user" (email, password, role_id, userdata_id)
VALUES ('user2@freebook.test', 'user2', 3, 5);

/*INSERT INTO book(agerestrictions, author, binding, description, isbn, name, publisher, publishingyear)
VALUES ('16+', 'Брюс Эккель', 'Твердый переплет',
        'Впервые читатель может познакомиться с полной версией этого классического труда, который ранее на русском языке печатался в сокращении. Книга, выдержавшая в оригинале не одно переиздание, за глубокое и поистине философское изложение тонкостей языка Java считается одним из лучших пособий для программистов. Чтобы по-настоящему понять язык Java, необходимо рассматривать его не просто как набор неких команд и операторов, а понять его «философию», подход к решению задач, в сравнении с таковыми в других языках программирования. На этих страницах автор рассказывает об основных проблемах написания кода: в чем их природа и какой подход использует Java в их разрешении. Поэтому обсуждаемые в каждой главе черты языка неразрывно связаны с тем, как они используются для решения определенных задач.',
        '978-5-4461-1107-7', 'Философия Java', 'Питер', '2019');*/