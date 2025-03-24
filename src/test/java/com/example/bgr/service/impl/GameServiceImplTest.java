package com.example.bgr.service.impl;

import com.example.bgr.dao.GameDao;
import com.example.bgr.mapper.GameMapper;
import com.example.bgr.model.dto.GameDTO;
import com.example.bgr.model.dto.GameFilterDTO;
import com.example.bgr.model.entity.GameEntity;
import com.example.bgr.service.GameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GameServiceImplTest {

    @Mock
    private GameDao gameDao;

    @Mock
    private GameMapper gameMapper;

    @InjectMocks
    private GameServiceImpl gameService;

    @BeforeEach
    void setUp() {
        gameService = new GameServiceImpl(gameDao, gameMapper);
    }

    @Test
    void testGetGames() {
        // given
        GameEntity gameEntity1 = new GameEntity();
        GameEntity gameEntity2 = new GameEntity();
        List<GameEntity> gameEntities = Arrays.asList(gameEntity1, gameEntity2);

        GameDTO gameDTO1 = new GameDTO();
        GameDTO gameDTO2 = new GameDTO();
        List<GameDTO> gameDTOs = Arrays.asList(gameDTO1, gameDTO2);

        when(gameDao.findAll()).thenReturn(gameEntities);
        when(gameMapper.mapToDtos(gameEntities)).thenReturn(gameDTOs);

        // when
        List<GameDTO> result = gameService.getGames(new GameFilterDTO());

        // then
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(gameDao, times(1)).findAll();
        verify(gameMapper, times(1)).mapToDtos(gameEntities);
    }

}