package com.cozwork.infrastructure.repositoris;

import com.cozwork.domain.entities.User;
import com.cozwork.infrastructure.GenericRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends GenericRepository<User> {

	User findByUsername(String username);

	User findByUserId(UUID userId);
}