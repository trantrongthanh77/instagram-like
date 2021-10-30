package com.cozwork.application.message;

import com.cozwork.domain.entities.User;
import com.cozwork.intergration.dtos.UserDTO;

public class UserResponse extends Response {

    private UserDTO userDTO;

    public UserResponse(User user) {
        this.userDTO = new UserDTO(user);
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
