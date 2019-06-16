package com.camsofttech.phsarcambo.model;

/*
 * @author : chhai chivon on 2/26/2019.
 * Software Engineer
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public abstract class AbstractModel extends BaseModel {

    @JsonProperty("name_en")
    public String nameEn;
    @JsonProperty("name_kh")
    private String nameKh;
    @JsonProperty("desc_en")
    private String descEn;
    @JsonProperty("desc_kh")
    private String descKh;

}
