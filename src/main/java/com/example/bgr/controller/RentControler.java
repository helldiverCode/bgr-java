package com.example.bgr.controller;

import com.example.bgr.model.dto.RentDTO;
import com.example.bgr.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RentControler {

    private GameService gameService;

    @Autowired
    public RentControler(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/game-rent")
    public ResponseEntity<RentDTO> rentGame(@RequestBody RentDTO rentDTO) {
        RentDTO rentedGame = gameService.rentGame(rentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(rentedGame);
    }
}
