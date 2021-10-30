package com.cozwork.application.message;

import com.cozwork.application.exceptions.ExceptionCode;
import com.cozwork.application.exceptions.InvalidRequestException;
import com.cozwork.domain.command.Command;
import com.cozwork.domain.command.ImageCommand;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;

public class UploadImageRequest extends Request implements RequestToCommand {

    private MultipartFile file;

    private String description;

    public UploadImageRequest() {
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void rules() throws Exception {
        if( ImageIO.read(file.getInputStream()) == null) {
            throw new InvalidRequestException(ExceptionCode.INVALID_UPLOAD_FILE_TYPE);
        }
    }

    @Override
    public Command toCommand() {
        ImageCommand imageCommand = new ImageCommand();
        imageCommand.setMultipartFile(this.file);
        imageCommand.setDescription(this.getDescription());
        imageCommand.setImageName(this.file.getOriginalFilename());
        return imageCommand;
    }
}
