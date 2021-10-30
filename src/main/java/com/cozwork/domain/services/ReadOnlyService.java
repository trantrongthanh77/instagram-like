package com.cozwork.domain.services;


import com.cozwork.domain.BaseEntity;
import com.cozwork.infrastructure.ReadOnlyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public abstract class ReadOnlyService<E extends BaseEntity, R extends ReadOnlyRepository<E>> {

    @Autowired
    protected R repository;

    @PersistenceContext
    protected EntityManager entityManager;

    private final Logger logger = LoggerFactory.getLogger(ReadOnlyService.class);

    /**
     * Find one item
     *
     * @param id -> key
     * @return entity
     */
    public E findById(Long id) {
        logger.info("Find item by id: {}", id);
        return repository.findById(id).orElse(null);
    }

    /**
     * Find all items
     *
     * @return multiple entities
     */
    public List<E> findAll() {
        logger.info("Find all items");
        return repository.findAll();
    }

    /**
     * Count all items
     *
     * @return number entities
     */
    public Long count() {
        logger.info("Count all items");
        return repository.count();
    }
}