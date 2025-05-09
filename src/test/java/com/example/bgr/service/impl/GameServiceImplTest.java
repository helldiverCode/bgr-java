package com.example.bgr.service.impl;

import com.example.bgr.dao.GameDao;
import com.example.bgr.mapper.GameMapper;
import com.example.bgr.model.dto.GameDTO;
import com.example.bgr.model.dto.GameFilterDTO;
import com.example.bgr.model.entity.GameEntity;
import com.example.bgr.service.RentService;
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
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GameServiceImplTest {

    @Mock
    private GameDao gameDao;

    @Mock
    private GameMapper gameMapper;

    @Mock
    private RentService rentService;

    @InjectMocks
    private GameServiceImpl gameService;

    @BeforeEach
    void setUp() {
        gameService = new GameServiceImpl(gameDao, gameMapper, rentService);
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

    @Test
    void testGetGameById() {
        // Arrange
        Long id = 1L;
        GameEntity gameEntity = new GameEntity();
        GameDTO gameDTO = new GameDTO();

        when(gameDao.findById(any(Long.class))).thenReturn(Optional.of(gameEntity));
        when(gameMapper.mapToDto(gameEntity)).thenReturn(gameDTO);

        // Acr
        GameDTO result = gameService.getGameById(id);

        //Assert
        assertNotNull(result);
        verify(gameDao, times(1)).findById(id);
        verify(gameMapper, times(1)).mapToDto(gameEntity);
    }

    @Test
    void testGetGameById_shouldThrowException() {
        // Arrange
        Long id = 1L;

        when(gameDao.findById(any(Long.class))).thenReturn(Optional.empty());

        // Acr
        Exception exception = assertThrows(ResponseStatusException.class, () -> {
            gameService.getGameById(id);
        });


        // Assert
        String expectedMessage = "Game not found with ID: " + id;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

        verify(gameDao, times(1)).findById(id);
        verify(gameMapper, never()).mapToDto(any());
    }

    @Test
    void saveGame_shouldSaveSuccessfully_whenGameIsValidAndNotExists() {
        // Arrange
        GameDTO gameDTO = new GameDTO();
        gameDTO.setId(null);
        gameDTO.setBarcode("12345");

        GameEntity gameEntity = new GameEntity();
        GameEntity savedEntity = new GameEntity();
        GameDTO savedDTO = new GameDTO();

        when(gameDao.existsByBarcode("12345")).thenReturn(false);
        when(gameMapper.mapToEntity(gameDTO)).thenReturn(gameEntity);
        when(gameDao.save(gameEntity)).thenReturn(savedEntity);
        when(gameMapper.mapToDto(savedEntity)).thenReturn(savedDTO);

        // Act
        GameDTO result = gameService.saveGame(gameDTO);

        // Assert
        assertNotNull(result);
        verify(gameDao).existsByBarcode("12345");
        verify(gameDao).save(gameEntity);
        verify(gameMapper).mapToEntity(gameDTO);
        verify(gameMapper).mapToDto(savedEntity);
    }

    @Test
    void saveGame_shouldThrowException_whenGameWithSameBarcodeExists() {
        // Arrange
        GameDTO gameDTO = new GameDTO();
        gameDTO.setId(null);
        gameDTO.setBarcode("12345");

        when(gameDao.existsByBarcode("12345")).thenReturn(true);

        // Act & Assert
        ResponseStatusException exception = assertThrows(ResponseStatusException.class,
                () -> gameService.saveGame(gameDTO));

        assertEquals("400 BAD_REQUEST \"A game with the same barcode already exists.\"", exception.getMessage());
        verify(gameDao).existsByBarcode("12345");
        verify(gameMapper, never()).mapToEntity(any());
        verify(gameDao, never()).save(any());
    }
}
