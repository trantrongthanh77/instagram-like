package com.cozwork.intergration.controller;

import com.cozwork.application.exceptions.ExceptionCode;
import com.cozwork.application.exceptions.InvalidRequestException;
import com.cozwork.application.message.UserRequest;
import com.cozwork.application.message.UserResponse;
import com.cozwork.domain.command.UserCommand;
import com.cozwork.domain.entities.User;
import com.cozwork.domain.services.command.UserCommandService;
import com.cozwork.domain.services.queries.UserQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserQueryService userQueryService;

    @Autowired
    private UserCommandService userCommandService;


    @GetMapping("/find-by-username/{username}")
    public UserResponse findByUserName(@PathVariable String username) {
        User user = userQueryService.findByUsername(username);
        UserResponse userResponse = null;
        if (user != null) {
            userResponse = new UserResponse(user);
        }
        return userResponse;
    }

    @PutMapping("/add-user")
    public UserResponse addUser(@RequestBody UserRequest request) throws InvalidRequestException {
        // check username exist
        User user = userQueryService.findByUsername(request.getUsername());
        if (user != null) {
            throw new InvalidRequestException(ExceptionCode.USERNAME_EXIST);
        }
        User userNew = this.userCommandService.addUser((UserCommand) request.toCommand());
        UserResponse userResponse = null;
        if (userNew != null) {
            userResponse = new UserResponse(userNew);
        }
        return userResponse;
    }
}
