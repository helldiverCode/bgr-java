INSERT INTO GAME (id, name, description, category, min_players, max_players, play_time, age_recommendation, rental_price, available, image_url, barcode, quantity, in_stock)
VALUES
(1, 'Catan', 'A strategy board game where players collect resources and build settlements to dominate the island of Catan.', 'Strategy', 3, 4, 90, 10, 5, TRUE, 'https://example.com/catan.jpg', '1234567890123', 10, 5),

(2, 'Carcassonne', 'A tile-placement game where players build cities, roads, and fields to score points.', 'Tile Placement', 2, 5, 45, 8, 4, TRUE, 'https://example.com/carcassonne.jpg', '1234567890456', 8, 3),

(3, 'Uno', 'A classic card game where players race to get rid of all their cards while using special action cards.', 'Card Game', 2, 10, 30, 7, 2, TRUE, 'https://example.com/uno.jpg', '1234567890789', 15, 10),

(4, 'Dixit', 'A storytelling card game where players use beautifully illustrated cards to create and guess stories.', 'Party', 3, 6, 30, 8, 3, TRUE, 'https://example.com/dixit.jpg', '1234567890111', 6, 2),

(5, 'Gloomhaven', 'A cooperative tactical combat game set in a fantasy world, with legacy-style gameplay.', 'Adventure', 1, 4, 120, 14, 10, TRUE, 'https://example.com/gloomhaven.jpg', '1234567890999', 4, 1);
ALTER SEQUENCE GAME_SEQ RESTART WITH (SELECT MAX(id) + 1 FROM GAME);