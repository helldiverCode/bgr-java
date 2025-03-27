package com.example.bgr.service.impl;

import com.example.bgr.dao.GameDao;
import com.example.bgr.mapper.GameMapper;
import com.example.bgr.model.dto.GameDTO;
import com.example.bgr.model.dto.GameFilterDTO;
import com.example.bgr.model.entity.GameEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
        // Arrange
        GameFilterDTO filter = new GameFilterDTO();
        filter.setSearchTerm("strategy");
        filter.setCategory("board");
        filter.setMinPlayers(2);
        filter.setMaxPlayers(4);
        filter.setMaxPlayTime(60);
        filter.setAgeRecommendation(12);
        filter.setMinRating(4);
        filter.setAvailableOnly(true);
        filter.setPage(1);
        filter.setPageSize(10);

        GameEntity gameEntity1 = new GameEntity();
        GameEntity gameEntity2 = new GameEntity();
        List<GameEntity> gameEntities = Arrays.asList(gameEntity1, gameEntity2);

        GameDTO gameDTO1 = new GameDTO();
        GameDTO gameDTO2 = new GameDTO();
        List<GameDTO> gameDTOs = Arrays.asList(gameDTO1, gameDTO2);

        Pageable pageable = PageRequest.of(filter.getPage(), filter.getPageSize());
        Page<GameEntity> gamePage = new PageImpl<>(gameEntities, pageable, gameEntities.size());

        when(gameDao.findAll(any(Specification.class), any(Pageable.class))).thenReturn(gamePage);
        when(gameMapper.mapToDtos(gameEntities)).thenReturn(gameDTOs);

        // Act
        List<GameDTO> result = gameService.getGames(filter);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(gameDao, times(1)).findAll(any(Specification.class), any(Pageable.class));
        verify(gameMapper, times(1)).mapToDtos(gameEntities);
    }
}
