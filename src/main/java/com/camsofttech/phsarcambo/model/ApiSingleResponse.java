package com.camsofttech.phsarcambo.model;

import lombok.Data;


/**
 * @author: chhai.chivon on 2/18/2019.
 * Software Engineer
 */
@Data
public class ApiSingleResponse<T> extends ApiBaseResponse {

    private T data;
}
