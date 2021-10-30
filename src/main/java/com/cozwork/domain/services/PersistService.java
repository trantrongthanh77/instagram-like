package com.cozwork.domain.services;

import com.cozwork.domain.BaseEntity;
import com.cozwork.infrastructure.PersistRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class PersistService<E extends BaseEntity, R extends PersistRepository<E>> {

    @Autowired
    protected R repository;
    private Logger logger = LoggerFactory.getLogger(PersistService.class);

    /**
     * Save all items
     *
     * @param entity
     * @return entity
     */
    public E save(E entity) {
        return this.repository.save(entity);
    }
}