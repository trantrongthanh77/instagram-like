package com.cozwork.intergration.dtos;

import com.cozwork.domain.entities.Image;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class ImageInfoDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("image_url")
    private String imageUrl;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("description")
    private String description;

    public ImageInfoDTO(Image image) {
        this.id = image.getId();
        this.imageUrl = image.getImageUrl();
        this.createdAt = image.getCreatedAt();
        this.description = image.getDescription();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
