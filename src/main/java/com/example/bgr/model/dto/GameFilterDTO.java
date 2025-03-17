package com.example.bgr.model.dto;

public class GameFilterDTO {

    private String searchTerm;      // Search by game name or description (optional)
    private String category;        // Filter by category (e.g., strategy, party, card)
    private Integer minPlayers;      // Minimum number of players
    private Integer maxPlayers;      // Maximum number of players
    private Integer maxPlayTime;     // Maximum playtime in minutes
    private Integer ageRecommendation; // Minimum age requirement
    private Integer minRating;       // Minimum average rating (1-5)
    private Boolean availableOnly;  // Show only available games
    private Integer page;
    private Integer pageSize;
}
