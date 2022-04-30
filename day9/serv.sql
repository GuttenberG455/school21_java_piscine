DROP SCHEMA IF EXISTS sockets CASCADE;

CREATE SCHEMA IF NOT EXISTS sockets;


CREATE TABLE IF NOT EXISTS sockets.userChat (
                                          id SERIAL PRIMARY KEY,
                                          login text UNIQUE NOT NULL,
                                          password text NOT NULL
);

INSERT INTO sockets.userChat (login, password)
VALUES ('user1', 'qwerty1');
INSERT INTO sockets.userChat (login, password)
VALUES ('supernagibator', 'password');
INSERT INTO sockets.userChat (login, password)
VALUES ('ZXC', 'qwerty');
INSERT INTO sockets.userChat (login, password)
VALUES ('Alex2009', '12345678');
INSERT INTO sockets.userChat (login, password)
VALUES ('BadBoy', '20011992');
INSERT INTO sockets.userChat (login, password)
VALUES ('Leet', '13371337');
INSERT INTO sockets.userChat (login, password)
VALUES ('user2', 'qwerty2');