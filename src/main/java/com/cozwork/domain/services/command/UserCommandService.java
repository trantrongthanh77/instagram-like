package com.cozwork.domain.services.command;

import com.cozwork.domain.command.UserCommand;
import com.cozwork.domain.entities.User;
import com.cozwork.domain.services.PersistService;
import com.cozwork.domain.vobjects.PersonalInfo;
import com.cozwork.infrastructure.repositoris.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserCommandService extends PersistService<User, UserRepository> {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional(rollbackOn = Exception.class)
    public User addUser(UserCommand command) {
        User user = new User();
        user.setUsername(command.getUsername());
        user.setPassword(passwordEncoder.encode(command.getPassword()));
        user.setEnabled(Boolean.TRUE);
        user.setActive(Boolean.TRUE);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(command.getUpdateAt());
        user.setCreatedBy(command.getUsername());
        user.setUpdatedBy(command.getUsername());
        user.setUserId(UUID.randomUUID());

        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setFirstName(command.getFirstName());
        personalInfo.setLastName(command.getLastName());
        personalInfo.setEmail(command.getEmail());
        personalInfo.setGender(command.getGender());
        personalInfo.setMarried(command.getMarried());
        personalInfo.setAvatarImagePath(command.getAvatarImagePath());
        personalInfo.setDob(command.getDob());
        user.setPersonalInfo(personalInfo);
        return this.repository.save(user);
    }
}
