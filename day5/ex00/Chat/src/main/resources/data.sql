INSERT INTO chat.users (login, password)
VALUES ('supernagibator', 'password');
INSERT INTO chat.users (login, password)
VALUES ('ZXC', 'qwerty');
INSERT INTO chat.users (login, password)
VALUES ('Alex2009', '12345678');
INSERT INTO chat.users (login, password)
VALUES ('BadBoy', '20011992');
INSERT INTO chat.users (login, password)
VALUES ('Leet', '13371337');

INSERT INTO chat.rooms (name, owner)
VALUES ('Random', 1);
INSERT INTO chat.rooms (name, owner)
VALUES ('/b/', 2);
INSERT INTO chat.rooms (name, owner)
VALUES ('Baraholka DNR', 3);
INSERT INTO chat.rooms (name, owner)
VALUES ('Free Sushi', 4);
INSERT INTO chat.rooms (name, owner)
VALUES ('MDK', 5);

INSERT INTO chat.messages (author, room, text, timestamp)
VALUES (1, 1, 'Hello', '2014-01-01 00:00:01');
INSERT INTO chat.messages (author, room, text, timestamp)
VALUES (2, 2, 'Gde kupit karburator', '2014-01-01 00:00:01');
INSERT INTO chat.messages (author, room, text, timestamp)
VALUES (5, 3, 'Prodam Garazh', '2014-01-01 00:00:02');
INSERT INTO chat.messages (author, room, text, timestamp)
VALUES (4, 4, 'Hochu Kaliforniyu', '2014-01-01 00:00:04');
INSERT INTO chat.messages (author, room, text, timestamp)
VALUES (5, 5, 'LOL', '2014-01-01 00:00:05');
INSERT INTO chat.messages (author, room, text, timestamp)
VALUES (1, 5, 'AHAHAHHA', '2014-01-01 00:00:06');
INSERT INTO chat.messages (author, room, text, timestamp)
VALUES (4, 3, 'Kuplyu bilety na avtobus v Rostov', '2014-01-01 00:00:07');
INSERT INTO chat.messages (author, room, text, timestamp)
VALUES (5, 2, 'Skinte full', '2014-01-01 00:00:08');