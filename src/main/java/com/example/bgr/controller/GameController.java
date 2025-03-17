package com.example.bgr.controller;

import com.example.bgr.model.dto.GameDTO;
import com.example.bgr.model.dto.GameFilterDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameController {

    @PostMapping("/game")
    public List<GameDTO> searchGames(@RequestBody() GameFilterDTO gameFilter) {
        return List.of(new GameDTO());
    }
}
