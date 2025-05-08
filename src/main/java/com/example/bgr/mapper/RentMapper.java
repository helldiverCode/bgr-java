package com.example.bgr.mapper;

import com.example.bgr.model.dto.RentDTO;
import com.example.bgr.model.entity.GameEntity;
import com.example.bgr.model.entity.PlayerEntity;
import com.example.bgr.model.entity.RentEntity;

public class RentMapper extends Mapper<RentDTO, RentEntity> {
    @Override
    public RentDTO mapToDto(RentEntity entity) {
        if (entity == null) {
            return null;
        }
        RentDTO mapped = new RentDTO();
        mapped.setRentEnd(entity.getRentEnd());
        mapped.setGameId(entity.getGame().getId());
        mapped.setRentStart(entity.getRentStart());
        mapped.setPlayerId(entity.getPlayer().getId());
        return mapped;

    }

    @Override
    public RentEntity mapToEntity(RentDTO dto) {
        if (dto == null) {
            return null;
        }

        RentEntity mapped = new RentEntity();
        mapped.setRentEnd(dto.getRentEnd());
        GameEntity game = new GameEntity();
        game.setId(dto.getGameId());
        mapped.setGame(game);
        mapped.setRentStart(dto.getRentStart());
        PlayerEntity player = new PlayerEntity();
        player.setId(dto.getPlayerId());
        mapped.setPlayer(player);
        return mapped;
    }
}
