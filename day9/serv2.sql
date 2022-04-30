DROP SCHEMA IF EXISTS sockets2 CASCADE;

CREATE SCHEMA IF NOT EXISTS sockets2;


CREATE TABLE IF NOT EXISTS sockets2.users (
                                          id SERIAL PRIMARY KEY,
                                          login TEXT UNIQUE NOT NULL,
                                          password TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS sockets2.messages (
                                          id SERIAL PRIMARY KEY,
                                          text TEXT UNIQUE NOT NULL,
                                          author INTEGER REFERENCES sockets2.users(id) NOT NULL,
										  sendingTime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);