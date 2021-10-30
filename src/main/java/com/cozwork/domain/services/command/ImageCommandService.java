package com.cozwork.domain.services.command;

import com.cozwork.domain.entities.Image;
import com.cozwork.domain.entities.User;
import com.cozwork.domain.services.PersistService;
import com.cozwork.domain.services.queries.UserQueryService;
import com.cozwork.infrastructure.repositoris.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ImageCommandService extends PersistService<Image, ImageRepository> {

    @Autowired
    private UserQueryService userQueryService;

    public Image addImage(String username, String imageUrl, String description) {
        // find user
        User user = userQueryService.findByUsername(username);
        if (user != null) {
            Image image = new Image();
            image.setUser(new User(user.getId()));
            image.setImageUrl(imageUrl);
            image.setCreatedAt(LocalDateTime.now());
            image.setUpdatedAt(LocalDateTime.now());
            image.setCreatedBy(user.getUsername());
            image.setUpdatedBy(user.getUsername());
            image.setDescription(description);
            return this.repository.save(image);
        }
        return null;
    }

}
