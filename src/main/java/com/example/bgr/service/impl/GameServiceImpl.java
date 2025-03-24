package com.example.bgr.service.impl;

import com.example.bgr.dao.GameDao;
import com.example.bgr.mapper.GameMapper;
import com.example.bgr.model.dto.GameDTO;
import com.example.bgr.model.dto.GameFilterDTO;
import com.example.bgr.model.entity.GameEntity;
import com.example.bgr.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    private GameDao gameDao;
    private GameMapper gameMapper;

    @Autowired
    public GameServiceImpl(GameDao gameDao, GameMapper gameMapper) {
        this.gameDao = gameDao;
        this.gameMapper = gameMapper;
    }

    @Override
    public List<GameDTO> getGames(GameFilterDTO filter) {
        List<GameEntity> result = new ArrayList<>();
        gameDao.findAll().forEach(result::add);
        return gameMapper.mapToDtos(result);
    }
}
