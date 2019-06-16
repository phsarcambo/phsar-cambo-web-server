package com.camsofttech.phsarcambo.model;

import lombok.Data;

/**
 * @author: chhai.chivon on 2/18/2019.
 * Software Engineer
 */
@Data
public class ApiBaseResponse {

    private String message;
    private int code;
    private boolean status;
}
