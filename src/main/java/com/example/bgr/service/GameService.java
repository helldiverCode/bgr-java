package com.example.bgr.service;

import com.example.bgr.model.dto.GameDTO;
import com.example.bgr.model.dto.GameFilterDTO;
import com.example.bgr.model.dto.RentDTO;

import java.util.List;

public interface GameService {

    List<GameDTO> getGames(GameFilterDTO filter);

    GameDTO getGameById(Long id);

    GameDTO saveGame(GameDTO gameDTO);

    RentDTO rentGame(RentDTO rentDTO);
}
