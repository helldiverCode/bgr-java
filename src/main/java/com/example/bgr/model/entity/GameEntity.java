package com.example.bgr.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "GAME")
public class GameEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;             // Game title
    private String description;      // Brief game description
    private String category;         // Board game category (e.g., strategy, party, card)
    private Integer minPlayers;       // Minimum players required
    private Integer maxPlayers;       // Maximum players allowed
    private Integer playTime;         // Estimated playtime in minutes
    private Integer ageRecommendation; // Recommended minimum age
    private Integer rentalPrice;      // Price per rental (e.g., per hour/day)
    private Boolean available;       // Availability status (true = available, false = rented out)
    private String imageUrl;         // URL to game cover image
    private String barcode;
    private Integer quantity;
    private Integer inStock;

    public GameEntity() {
    }

    public GameEntity(Long id, String name, String description, String category, Integer minPlayers, Integer maxPlayers, Integer playTime, Integer ageRecommendation, Integer rentalPrice, Boolean available, String imageUrl, String barcode, Integer quantity, Integer inStock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.playTime = playTime;
        this.ageRecommendation = ageRecommendation;
        this.rentalPrice = rentalPrice;
        this.available = available;
        this.imageUrl = imageUrl;
        this.barcode = barcode;
        this.quantity = quantity;
        this.inStock = inStock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Integer getPlayTime() {
        return playTime;
    }

    public void setPlayTime(Integer playTime) {
        this.playTime = playTime;
    }

    public Integer getAgeRecommendation() {
        return ageRecommendation;
    }

    public void setAgeRecommendation(Integer ageRecommendation) {
        this.ageRecommendation = ageRecommendation;
    }

    public Integer getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(Integer rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getInStock() {
        return inStock;
    }

    public void setInStock(Integer inStock) {
        this.inStock = inStock;
    }
}


