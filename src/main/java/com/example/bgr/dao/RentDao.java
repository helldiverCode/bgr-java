package com.example.bgr.dao;

import com.example.bgr.model.entity.RentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RentDao extends JpaRepository<RentEntity, Long>, JpaSpecificationExecutor<RentEntity> {
}
