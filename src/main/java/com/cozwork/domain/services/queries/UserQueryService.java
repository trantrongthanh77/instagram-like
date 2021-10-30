package com.cozwork.domain.services.queries;

import com.cozwork.application.exceptions.ExceptionCode;
import com.cozwork.application.exceptions.UnauthorizedException;
import com.cozwork.domain.entities.User;
import com.cozwork.domain.services.ReadOnlyService;
import com.cozwork.infrastructure.repositoris.UserRepository;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserQueryService extends ReadOnlyService<User, UserRepository> implements UserDetailsService {

    public User findByUsername(String username) {
        return this.repository.findByUsername(username);
    }

    public User findById(Long id) {
        Optional<User> user = this.repository.findById(id);
        return user.orElse(null);
    }

    public User findByUserId(UUID userId) {
        return this.repository.findByUserId(userId);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = this.repository.findByUsername(username);

        if (user == null)
            throw new UnauthorizedException(ExceptionCode.INVALID_USERNAME);

        if (!user.getActive())
            throw new UnauthorizedException(ExceptionCode.USER_INACTIVE);

        new AccountStatusUserDetailsChecker().check(user);

        return user;
    }
}
