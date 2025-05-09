package com.example.bgr.service.impl;

import com.example.bgr.dao.RentDao;
import com.example.bgr.mapper.RentMapper;
import com.example.bgr.model.dto.RentDTO;
import com.example.bgr.model.entity.RentEntity;
import com.example.bgr.service.RentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RentServiceImpl implements RentService {

    private RentDao rentDao;
    private RentMapper rentMapper;

    @Autowired
    public RentServiceImpl(RentDao rentDao, RentMapper rentMapper) {
        this.rentDao = rentDao;
        this.rentMapper = rentMapper;
    }

    @Override
    public RentDTO rentGame(@Valid RentDTO rentDTO) {
        RentEntity rentEntity = rentMapper.mapToEntity(rentDTO);
        RentEntity savedEntity = rentDao.save(rentEntity);
        return rentMapper.mapToDto(savedEntity);
    }
}
