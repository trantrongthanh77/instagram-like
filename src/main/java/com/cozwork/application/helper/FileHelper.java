package com.cozwork.application.helper;

import com.google.common.io.Files;
import org.springframework.http.MediaType;

public class FileHelper {


    public static MediaType getMediaType(String fileName) {
        String ext = Files.getFileExtension(fileName);
        MediaType mediaType;
        switch (ext) {
            case "jpg":
            case "jpeg":
                mediaType = MediaType.IMAGE_JPEG;
                break;
            case "png":
                mediaType = MediaType.IMAGE_PNG;
                break;
            case "txt":
                mediaType = MediaType.TEXT_PLAIN;
                break;
            case "pdf":
                mediaType = MediaType.APPLICATION_PDF;
                break;
            default:
                mediaType = MediaType.APPLICATION_OCTET_STREAM;
        }
        return mediaType;
    }
}
