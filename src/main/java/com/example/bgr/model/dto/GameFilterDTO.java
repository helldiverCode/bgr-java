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

    public GameFilterDTO() {
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getMinPlayers() {
        return minPlayers;
    }

    public void setMinPlayers(Integer minPlayers) {
        this.minPlayers = minPlayers;
    }

    public Integer getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(Integer maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public Integer getMaxPlayTime() {
        return maxPlayTime;
    }

    public void setMaxPlayTime(Integer maxPlayTime) {
        this.maxPlayTime = maxPlayTime;
    }

    public Integer getAgeRecommendation() {
        return ageRecommendation;
    }

    public void setAgeRecommendation(Integer ageRecommendation) {
        this.ageRecommendation = ageRecommendation;
    }

    public Integer getMinRating() {
        return minRating;
    }

    public void setMinRating(Integer minRating) {
        this.minRating = minRating;
    }

    public Boolean getAvailableOnly() {
        return availableOnly;
    }

    public void setAvailableOnly(Boolean availableOnly) {
        this.availableOnly = availableOnly;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
