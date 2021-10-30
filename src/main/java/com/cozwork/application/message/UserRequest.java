package com.cozwork.application.message;

import com.cozwork.domain.command.Command;
import com.cozwork.domain.command.UserCommand;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserRequest extends Request implements RequestToCommand {

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("avatar_image_path")
    private String avatarImagePath;

    @JsonProperty("description")
    private String description;

    @JsonProperty("gender")
    private Boolean gender;

    @JsonProperty("married")
    private Boolean married;

    @JsonProperty("dob")
    private LocalDate dob;

    @JsonProperty("email")
    private String email;

    @JsonProperty("active")
    private Boolean active;

    @Override
    public void rules() throws Exception {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAvatarImagePath() {
        return avatarImagePath;
    }

    public void setAvatarImagePath(String avatarImagePath) {
        this.avatarImagePath = avatarImagePath;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public Command toCommand() {
        UserCommand userCommand = new UserCommand();
        userCommand.setUsername(this.username);
        userCommand.setPassword(this.password);
        userCommand.setFirstName(this.firstName);
        userCommand.setLastName(this.lastName);
        userCommand.setActive(this.active);
        userCommand.setDob(this.dob);
        userCommand.setAvatarImagePath(this.avatarImagePath);
        userCommand.setDescription(this.description);
        userCommand.setGender(this.gender);
        userCommand.setEmail(this.email);
        userCommand.setUpdateAt(LocalDateTime.now());
        return userCommand;
    }
}
