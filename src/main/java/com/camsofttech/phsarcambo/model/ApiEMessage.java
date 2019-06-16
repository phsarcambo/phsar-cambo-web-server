package com.camsofttech.phsarcambo.model;

/**
 * @author : chhai chivon on 4/9/2019.
 * Software Engineer
 */

public enum ApiEMessage {

    GET_SUCCESS("Get data success"),
    GET_FAIL("Get data fail"),
    SAVE_SUCCESS("Save data success"),
    SAVE_FAIL("Save data fail"),
    UPDATE_SUCCESS("Update data success"),
    UPDATE_FAIL("Update data fail"),
    DELETE_SUCCESS("Delete data success"),
    DELETE_FAIL("Delete data fail");

    private final String name;

    ApiEMessage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
