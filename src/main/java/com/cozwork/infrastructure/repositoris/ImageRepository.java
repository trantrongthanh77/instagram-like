package com.cozwork.infrastructure.repositoris;

import com.cozwork.domain.entities.Image;
import com.cozwork.infrastructure.GenericRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ImageRepository extends GenericRepository<Image> {

    Page<Image> findAllByUser_UserIdOrderByCreatedAtDesc(UUID userId, Pageable pageable);
}
