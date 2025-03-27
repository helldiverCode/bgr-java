package com.example.bgr.dao;

import com.example.bgr.model.entity.GameEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface GameDao extends CrudRepository<GameEntity, Long>, JpaSpecificationExecutor<GameEntity> {
}
