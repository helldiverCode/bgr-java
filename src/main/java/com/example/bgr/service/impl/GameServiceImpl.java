package com.example.bgr.service.impl;

import com.example.bgr.dao.GameDao;
import com.example.bgr.mapper.GameMapper;
import com.example.bgr.model.dto.GameDTO;
import com.example.bgr.model.dto.GameFilterDTO;
import com.example.bgr.model.entity.GameEntity;
import com.example.bgr.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    private GameDao gameDao;
    private GameMapper gameMapper;

    @Autowired
    public GameServiceImpl(GameDao gameDao, GameMapper gameMapper) {
        this.gameDao = gameDao;
        this.gameMapper = gameMapper;
    }

    @Override
    public List<GameDTO> getGames(GameFilterDTO filter) {
        Specification<GameEntity> spec = Specification.where(null);

        if (filter.getSearchTerm() != null && !filter.getSearchTerm().isEmpty()) {
            spec = spec.and((root, query, cb) -> cb.or(
                    cb.like(cb.lower(root.get("name")), "%%" + filter.getSearchTerm().toLowerCase() + "%%"),
                    cb.like(cb.lower(root.get("description")), "%%" + filter.getSearchTerm().toLowerCase() + "%%")
            ));
        }
        if (filter.getCategory() != null) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("category"), filter.getCategory()));
        }
        if (filter.getMinPlayers() != null) {
            spec = spec.and((root, query, cb) -> cb.greaterThanOrEqualTo(root.get("minPlayers"), filter.getMinPlayers()));
        }
        if (filter.getMaxPlayers() != null) {
            spec = spec.and((root, query, cb) -> cb.lessThanOrEqualTo(root.get("maxPlayers"), filter.getMaxPlayers()));
        }
        if (filter.getMaxPlayTime() != null) {
            spec = spec.and((root, query, cb) -> cb.lessThanOrEqualTo(root.get("playTime"), filter.getMaxPlayTime()));
        }
        if (filter.getAgeRecommendation() != null) {
            spec = spec.and((root, query, cb) -> cb.greaterThanOrEqualTo(root.get("ageRecommendation"), filter.getAgeRecommendation()));
        }
        if (filter.getAvailableOnly() != null && filter.getAvailableOnly()) {
            spec = spec.and((root, query, cb) -> cb.isTrue(root.get("available")));
        }

        Pageable pageable = PageRequest.of(
                filter.getPage() != null ? filter.getPage() : 0,
                filter.getPageSize() != null ? filter.getPageSize() : 10
        );

        Page<GameEntity> resultPage = gameDao.findAll(spec, pageable);
        return gameMapper.mapToDtos(resultPage.getContent());
    }

    @Override
    public GameDTO getGameById(Long id) {
        Optional<GameEntity> gameEntity = gameDao.findById(id);
        return gameEntity.map(gameMapper::mapToDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found with ID: " + id));
    }

    @Override
    public GameDTO saveGame(GameDTO gameDTO) {
        if (gameDTO.getId() == null && gameDTO.getBarcode() != null && gameDao.existsByBarcode(gameDTO.getBarcode())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A game with the same barcode already exists.");
        }
        GameEntity gameEntity = gameMapper.mapToEntity(gameDTO);
        GameEntity savedEntity = gameDao.save(gameEntity);
        return gameMapper.mapToDto(savedEntity);
    }
}
