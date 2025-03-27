CREATE TABLE GAME (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    category VARCHAR(100),
    min_players INT,
    max_players INT,
    play_time INT,
    age_recommendation INT,
    rental_price INT,
    available BOOLEAN DEFAULT TRUE,
    image_url VARCHAR(500),
    barcode VARCHAR(100) UNIQUE,
    quantity INT DEFAULT 0,
    in_stock INT DEFAULT 0
);
DROP SEQUENCE IF EXISTS GAME_SEQ;
CREATE SEQUENCE GAME_SEQ START WITH (SELECT COALESCE(MAX(id), 0) + 1 FROM GAME) INCREMENT BY 1;
