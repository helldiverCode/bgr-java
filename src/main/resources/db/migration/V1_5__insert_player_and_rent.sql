INSERT INTO PLAYER (id, name) VALUES ('player1', 'Alice');
INSERT INTO PLAYER (id, name) VALUES ('player2', 'Bob');

INSERT INTO RENT (id, game_id, player_id, rent_start, rent_end)
VALUES (1, 1, 'player1', TIMESTAMP '2024-05-01 10:00:00', TIMESTAMP '2024-05-05 10:00:00');

INSERT INTO RENT (id, game_id, player_id, rent_start, rent_end)
VALUES (2, 2, 'player2', TIMESTAMP '2024-05-02 12:00:00', TIMESTAMP '2024-05-06 12:00:00');
INSERT INTO RENT (id, game_id, player_id, rent_start, rent_end)
VALUES (3, 3, 'player2', TIMESTAMP '2024-05-02 12:00:00', null);
ALTER SEQUENCE RENT_SEQ RESTART WITH (SELECT MAX(id) + 1 FROM RENT);