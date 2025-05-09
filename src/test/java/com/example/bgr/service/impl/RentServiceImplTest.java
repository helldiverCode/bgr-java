package com.example.bgr.service.impl;

import com.example.bgr.dao.RentDao;
import com.example.bgr.mapper.RentMapper;
import com.example.bgr.model.dto.RentDTO;
import com.example.bgr.model.entity.RentEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RentServiceImplTest {

    @Mock
    private RentDao rentDao;

    @Mock
    private RentMapper rentMapper;

    @InjectMocks
    private RentServiceImpl rentService;

    @BeforeEach
    void setUp() {
        rentService = new RentServiceImpl(rentDao, rentMapper);
    }

    @Test
    void saveGame() {
        // Arrange
        RentDTO rentDTO = new RentDTO();
        rentDTO.setGameId(1L);
        rentDTO.setPlayerId("12345");

        RentEntity rentEntity = new RentEntity();
        RentEntity savedEntity = new RentEntity();
        RentDTO savedDTO = new RentDTO();

        when(rentMapper.mapToEntity(rentDTO)).thenReturn(rentEntity);
        when(rentDao.save(rentEntity)).thenReturn(savedEntity);
        when(rentMapper.mapToDto(savedEntity)).thenReturn(savedDTO);

        // Act
        RentDTO result = rentService.rentGame(rentDTO);

        // Assert
        assertNotNull(result);
        verify(rentDao).save(rentEntity);
        verify(rentMapper).mapToEntity(rentDTO);
        verify(rentMapper).mapToDto(savedEntity);
    }
}