package com.cozwork.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PersistRepository<T> extends JpaRepository<T, Long> {

}