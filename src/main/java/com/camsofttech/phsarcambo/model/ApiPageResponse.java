package com.camsofttech.phsarcambo.model;

import lombok.Data;
import org.springframework.data.domain.Page;


/**
 * @author: chhai.chivon on 1/15/2019.
 * Software Engineer
 */
@Data
public class ApiPageResponse<T> extends ApiBaseResponse {

    private Page<T> data;
}
