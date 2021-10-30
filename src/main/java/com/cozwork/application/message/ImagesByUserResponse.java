package com.cozwork.application.message;

import com.cozwork.domain.entities.Image;
import com.cozwork.domain.entities.User;

import com.cozwork.intergration.dtos.ImageInfoDTO;
import com.cozwork.intergration.dtos.UserDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class ImagesByUserResponse extends PagingResponse {

    @JsonProperty("user")
    private UserDTO userDTO;

    @JsonProperty("images")
    private List<ImageInfoDTO> images;

    public ImagesByUserResponse(User user, Page<Image> images) {
        super(images.getPageable(), images.getTotalPages(), images.getTotalElements());
        this.userDTO = new UserDTO(user);
        this.images = new ArrayList<>();
        images.forEach(image -> this.images.add(new ImageInfoDTO(image)));
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public List<ImageInfoDTO> getImages() {
        return images;
    }

    public void setImages(List<ImageInfoDTO> images) {
        this.images = images;
    }
}
