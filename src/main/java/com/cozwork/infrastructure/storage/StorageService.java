package com.cozwork.infrastructure.storage;

import com.cozwork.domain.command.ImageCommand;
import com.cozwork.domain.services.command.ImageCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class StorageService {

    private static final Logger logger = LoggerFactory.getLogger(StorageService.class);

    @Value("${root-path}")
    private String rootPath;

    @Value("${url-image}")
    private String urlImage;

    @Value("${directory}")
    private String directory;

    @Autowired
    private ImageCommandService imageCommandService;

    public InputStream getFileStorage(String fileName, String directory) {
        InputStream inputStream = null;
        Path path = Paths.get(System.getProperty(this.rootPath) + File.separator + directory + File.separator + fileName);
        File file = new File(String.valueOf(path));
        try {
            inputStream = new FileInputStream(file);
        } catch (Exception ex) {
        }
        return inputStream;
    }

    public String uploadImage(ImageCommand command, String directory) throws IOException {
        // build image name
        String username = (String) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        String fileExtension = com.google.common.io.Files.getFileExtension(command.getImageName());
        String imageName = username.concat(LocalDateTime.now().format(DateTimeFormatter.ofPattern("-yyyy-MM-dd-hh-mm-ss.SSS")))
                .concat(".").concat(fileExtension);
        // upload image to server
        boolean isSuccess = uploadImage(command.getMultipartFile().getInputStream(), imageName, directory);
        String url = null;
        if (isSuccess) {
            // add image to db
            url = String.format("%s/%s", this.urlImage, imageName);
            this.imageCommandService.addImage(username, url, command.getDescription() );
        }
        return url;
    }

    public boolean uploadImage(InputStream inputStream, String fileName, String directory) {
        boolean isSuccess = false;
        Path path = Paths.get(System.getProperty(this.rootPath) + File.separator + directory);
        try {
            if (!Files.exists(path)) Files.createDirectories(path);
            Files.copy(inputStream, Paths.get(path + File.separator + fileName), StandardCopyOption.REPLACE_EXISTING);
            isSuccess = true;
        } catch (Exception ex) {
            logger.error("[ERROR]: upload file on self storage : failed!");
        } finally {
            try {
                if (inputStream != null) inputStream.close();
            } catch (IOException ioe) {
                logger.error("[ERROR]: failed to close the input stream!");
            }
        }
        return isSuccess;
    }
}
