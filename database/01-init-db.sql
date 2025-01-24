BEGIN TRANSACTION;

-- IF YOU ADD MORE TABLES IN YOUR CUSTOM.SQL, ADD THEM HERE ⬇️
DROP TABLE IF EXISTS "user", weather_collection;
-- IF YOU ADD MORE TABLES IN YOUR CUSTOM.SQL, ADD THEM HERE ⬆️

CREATE TABLE "user" (
	id SERIAL PRIMARY KEY,
	username VARCHAR(80) UNIQUE NOT NULL,
	email VARCHAR(255) UNIQUE NOT NULL,
	password VARCHAR(255) NOT NULL,
	role VARCHAR(50) NOT NULL
);

CREATE TABLE weather_collection (
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    cities_json TEXT NOT NULL,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES "user" (id)
);

INSERT INTO "user" (username, email, password, role) VALUES ('root', 'admin@example.com', '6bcd9a3191e445180dc742b1f609f8af', 'admin');

-- password: rootpwd


COMMIT;



