package com.cozwork.domain.services.queries;

import com.cozwork.domain.entities.Image;
import com.cozwork.domain.services.ReadOnlyService;
import com.cozwork.infrastructure.repositoris.ImageRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ImageQueryService extends ReadOnlyService<Image, ImageRepository> {

    public Page<Image> findAllByUserId(UUID userId, Pageable pageable) {
        return this.repository.findAllByUser_UserIdOrderByCreatedAtDesc(userId, pageable);
    }
}
