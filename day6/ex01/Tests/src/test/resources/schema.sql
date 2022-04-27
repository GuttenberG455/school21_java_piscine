DROP TABLE IF EXISTS products CASCADE;

CREATE TABLE IF NOT EXISTS products (
                                        id INTEGER IDENTITY PRIMARY KEY,
                                        name VARCHAR(100) NOT NULL,
                                        price INTEGER
);