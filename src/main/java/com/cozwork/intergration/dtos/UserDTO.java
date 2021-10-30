package com.cozwork.intergration.dtos;

import com.cozwork.domain.entities.User;
import com.cozwork.domain.vobjects.PersonalInfo;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class UserDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("user_id")
    private UUID userId;

    @JsonProperty("username")
    private String username;

    @JsonProperty("personal_info")
    private PersonalInfo personalInfo;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.userId = user.getUserId();
        this.username = user.getUsername();
        this.personalInfo = user.getPersonalInfo();
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }
}
