package com.camsofttech.phsarcambo.service;

import org.springframework.data.domain.Page;

/**
 * @author : chhai chivon on 4/9/2019.
 * Software Engineer
 */

public interface IAbstractService<T> {

    Page<T> findAll(int page, int limit);

    T findById(Long id);

    T onSave(T entity);

    T onUpdate(T entity);

    T onDelete(Long id);

}
