DROP TABLE IF EXISTS annonces;

CREATE TABLE annonces (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    address VARCHAR(255),
    mail VARCHAR(255)
);
