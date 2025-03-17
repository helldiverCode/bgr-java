package com.example.bgr.model.dto;

public class GameDTO {

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
}
