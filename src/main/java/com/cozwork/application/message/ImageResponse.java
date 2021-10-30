package com.cozwork.application.message;

import com.cozwork.domain.entities.Image;
import com.cozwork.intergration.dtos.ImageDTO;

public class ImageResponse extends Response {
    private ImageDTO image;

    public ImageResponse(Image image) {
        this.image = new ImageDTO(image);
    }

    public ImageDTO getImage() {
        return image;
    }

    public void setImage(ImageDTO image) {
        this.image = image;
    }
}
