package com.example.bgr.dao;

import com.example.bgr.model.entity.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GameDao extends JpaRepository<GameEntity, Long>, JpaSpecificationExecutor<GameEntity> {
    boolean existsByBarcode(String barcode);
}