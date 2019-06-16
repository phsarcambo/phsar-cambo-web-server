package com.camsofttech.phsarcambo.controller;

import com.camsofttech.phsarcambo.model.ApiPageResponse;
import com.camsofttech.phsarcambo.model.ApiSingleResponse;
import org.springframework.http.ResponseEntity;


/**
 * @author : chhai chivon on 4/9/2019.
 * Software Engineer
 */

public interface IBaseController<T> {

    ResponseEntity<ApiPageResponse<T>> findAllBy(int page, int limit);

     ResponseEntity<ApiSingleResponse<T>> findById(Long id);

     ResponseEntity<ApiSingleResponse<T>> onSave(T entity);

     ResponseEntity<ApiSingleResponse<T>> onUpdate(Long id, T entity);

     ResponseEntity<ApiSingleResponse<T>> onDelete(Long id);

}
