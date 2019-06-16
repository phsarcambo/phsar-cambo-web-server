package com.camsofttech.phsarcambo.model;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author : chhai chivon on 4/9/2019.
 * Software Engineer
 */

public class ApiResponse<T> {

    public ResponseEntity<ApiPageResponse<T>> apiPageResponseResponseEntity(Page<T> page) {
        ApiPageResponse<T> apiPageResponse = new ApiPageResponse<>();
        if (page != null && page.hasContent()) {
            apiPageResponse.setData(page);
            apiPageResponse.setCode(200);
            apiPageResponse.setMessage(ApiEMessage.GET_SUCCESS.getName());
            apiPageResponse.setStatus(true);
        } else {
            apiPageResponse.setCode(404);
            apiPageResponse.setMessage(ApiEMessage.GET_FAIL.getName());
            apiPageResponse.setStatus(false);
        }
        return new ResponseEntity<>(apiPageResponse, HttpStatus.OK);
    }

    public ResponseEntity<ApiSingleResponse<T>> apiSingleResponseResponseEntity(T entity, RequestMethod requestMethod) {
        ApiSingleResponse<T> apiSingleResponse = new ApiSingleResponse<>();
        if (requestMethod.equals(RequestMethod.GET)) {
            if (entity != null) {
                apiSingleResponse.setData(entity);
                apiSingleResponse.setMessage(ApiEMessage.GET_SUCCESS.getName());
                apiSingleResponse.setCode(200);
                apiSingleResponse.setStatus(true);
            } else {
                apiSingleResponse.setMessage(ApiEMessage.GET_FAIL.getName());
                apiSingleResponse.setCode(404);
                apiSingleResponse.setStatus(false);
            }
        } else if (requestMethod.equals(RequestMethod.POST)) {
            if (entity != null) {
                apiSingleResponse.setData(entity);
                apiSingleResponse.setMessage(ApiEMessage.SAVE_SUCCESS.getName());
                apiSingleResponse.setCode(200);
                apiSingleResponse.setStatus(true);
            } else {
                apiSingleResponse.setMessage(ApiEMessage.SAVE_FAIL.getName());
                apiSingleResponse.setCode(404);
                apiSingleResponse.setStatus(false);
            }
        } else if (requestMethod.equals(RequestMethod.PUT)) {
            if (entity != null) {
                apiSingleResponse.setData(entity);
                apiSingleResponse.setMessage(ApiEMessage.UPDATE_SUCCESS.getName());
                apiSingleResponse.setCode(200);
                apiSingleResponse.setStatus(true);
            } else {
                apiSingleResponse.setMessage(ApiEMessage.UPDATE_FAIL.getName());
                apiSingleResponse.setCode(404);
                apiSingleResponse.setStatus(false);
            }
        } else if (requestMethod.equals(RequestMethod.DELETE)) {
            if (entity != null) {
                apiSingleResponse.setData(entity);
                apiSingleResponse.setMessage(ApiEMessage.DELETE_SUCCESS.getName());
                apiSingleResponse.setCode(200);
                apiSingleResponse.setStatus(true);
            } else {
                apiSingleResponse.setMessage(ApiEMessage.DELETE_FAIL.getName());
                apiSingleResponse.setCode(404);
                apiSingleResponse.setStatus(false);
            }
        }
        return new ResponseEntity<>(apiSingleResponse, HttpStatus.OK);
    }
}
