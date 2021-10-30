package com.cozwork.intergration.controller;

import com.cozwork.application.exceptions.ExceptionCode;
import com.cozwork.application.exceptions.InvalidRequestException;
import com.cozwork.application.helper.FileHelper;
import com.cozwork.application.message.FileResponse;
import com.cozwork.application.message.ImagesByUserResponse;
import com.cozwork.application.message.UploadImageRequest;
import com.cozwork.domain.command.ImageCommand;
import com.cozwork.domain.entities.Image;
import com.cozwork.domain.entities.User;
import com.cozwork.domain.services.queries.ImageQueryService;
import com.cozwork.domain.services.queries.UserQueryService;
import com.cozwork.infrastructure.storage.StorageService;
import com.google.common.io.ByteStreams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.UUID;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private StorageService storageService;

    @Autowired
    private ImageQueryService imageQueryService;

    @Autowired
    private UserQueryService userQueryService;

    @Value("${directory}")
    private String directory;

    @GetMapping("/image-name/{imageName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName) throws Exception {
        InputStream inputStream = storageService.getFileStorage(imageName, directory);
        byte[] bytes = ByteStreams.toByteArray(inputStream);
        return ResponseEntity.ok().contentType(FileHelper.getMediaType(imageName)).body(bytes);
    }

    @PostMapping("/upload")
    public FileResponse uploadFile(@ModelAttribute UploadImageRequest request) throws Exception {
        request.validate();
        String path = this.storageService.uploadImage((ImageCommand) request.toCommand(), directory);
        return new FileResponse(path);
    }

    @GetMapping("/find-by-user-id")
    public ImagesByUserResponse findImagesByUserId(@RequestParam UUID userId, Pageable pageable) throws InvalidRequestException {
        User user = userQueryService.findByUserId(userId);
        if (user == null) {
            throw new InvalidRequestException(ExceptionCode.INVALID_USERNAME);
        }
        Page<Image> images = this.imageQueryService.findAllByUserId(userId, pageable);
        return new ImagesByUserResponse(user, images);
    }

}
