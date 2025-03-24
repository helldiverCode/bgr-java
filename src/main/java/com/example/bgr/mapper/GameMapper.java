package com.example.bgr.mapper;

import com.example.bgr.model.dto.GameDTO;
import com.example.bgr.model.entity.GameEntity;
import org.springframework.stereotype.Component;

@Component
public class GameMapper extends Mapper<GameDTO, GameEntity> {
    @Override
    public GameDTO mapToDto(GameEntity entity) {
        GameDTO mapped = new GameDTO();
        mapped.setAvailable(entity.getAvailable());
        mapped.setBarcode(entity.getBarcode());
        mapped.setAgeRecommendation(entity.getAgeRecommendation());
        mapped.setCategory(entity.getCategory());
        mapped.setDescription(entity.getDescription());
        mapped.setId(entity.getId());
        mapped.setImageUrl(entity.getImageUrl());
        mapped.setInStock(entity.getInStock());
        mapped.setMaxPlayers(entity.getMaxPlayers());
        mapped.setMinPlayers(entity.getMinPlayers());
        mapped.setName(entity.getName());
        mapped.setPlayTime(entity.getPlayTime());
        mapped.setQuantity(entity.getQuantity());
        mapped.setRentalPrice(entity.getRentalPrice());
        return mapped;
    }

    @Override
    public GameEntity mapToEntity(GameDTO dto) {
        GameEntity mapped = new GameEntity();
        mapped.setAvailable(dto.getAvailable());
        mapped.setBarcode(dto.getBarcode());
        mapped.setAgeRecommendation(dto.getAgeRecommendation());
        mapped.setCategory(dto.getCategory());
        mapped.setDescription(dto.getDescription());
        mapped.setId(dto.getId());
        mapped.setImageUrl(dto.getImageUrl());
        mapped.setInStock(dto.getInStock());
        mapped.setMaxPlayers(dto.getMaxPlayers());
        mapped.setMinPlayers(dto.getMinPlayers());
        mapped.setName(dto.getName());
        mapped.setPlayTime(dto.getPlayTime());
        mapped.setQuantity(dto.getQuantity());
        mapped.setRentalPrice(dto.getRentalPrice());
        return mapped;
    }
}
