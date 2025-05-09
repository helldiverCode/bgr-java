package com.example.bgr.model.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class RentDTO {

    @NotNull
    private Long gameId;
    @NotNull
    private String playerId;
    private LocalDateTime rentStart;
    private LocalDateTime rentEnd;

    public RentDTO() {
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public LocalDateTime getRentStart() {
        return rentStart;
    }

    public void setRentStart(LocalDateTime rentStart) {
        this.rentStart = rentStart;
    }

    public LocalDateTime getRentEnd() {
        return rentEnd;
    }

    public void setRentEnd(LocalDateTime rentEnd) {
        this.rentEnd = rentEnd;
    }
}
