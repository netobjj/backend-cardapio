CREATE TABLE foods(
    id SERIAL PRIMARY KEY,
    title TEXT NOT NULL,
    description TEXT,
    price INTEGER NOT NULL,
    image TEXT
)