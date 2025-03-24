package com.example.bgr.controller;

import com.example.bgr.model.dto.GameDTO;
import com.example.bgr.model.dto.GameFilterDTO;
import com.example.bgr.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameController {

    private GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/game")
    public List<GameDTO> searchGames(@RequestBody() GameFilterDTO gameFilter) {
        return gameService.getGames(gameFilter);
    }
}
