package com.cozwork.intergration.dtos;

import com.cozwork.domain.entities.Image;
import com.cozwork.intergration.dtos.UserDTO;

import java.time.LocalDateTime;

public class ImageDTO {

    private Long id;

    private UserDTO userDTO;

    private String imageUrl;

    private LocalDateTime createdAt;

    private String description;

    public ImageDTO(Image image) {
        this.id = image.getId();
        this.userDTO = new UserDTO(image.getUser());
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

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
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
