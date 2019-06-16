package com.camsofttech.phsarcambo.controller;

import com.camsofttech.phsarcambo.model.ApiPageResponse;
import com.camsofttech.phsarcambo.model.ApiResponse;
import com.camsofttech.phsarcambo.model.ApiSingleResponse;
import com.camsofttech.phsarcambo.model.User;
import com.camsofttech.phsarcambo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author : chhai chivon on 4/28/2019.
 * Software Engineer
 */

@RequestMapping(value = "/api/users")
@RestController
public class UserController implements IBaseController<User> {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<ApiPageResponse<User>> findAllBy(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "limit",defaultValue = "100") int limit) {
        Page<User> userPage = userService.findAll(page,limit);
        return new ApiResponse<User>().apiPageResponseResponseEntity(userPage);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<ApiSingleResponse<User>> findById(@PathVariable("id") Long id) {
        User user = userService.findById(id);
        return new ApiResponse<User>().apiSingleResponseResponseEntity(user, RequestMethod.POST);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<ApiSingleResponse<User>> onSave(User entity) {
        User user  = userService.onSave(entity);
        return new ApiResponse<User>().apiSingleResponseResponseEntity(user, RequestMethod.POST);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<ApiSingleResponse<User>> onUpdate(@PathVariable("id") Long id, User entity) {
        entity.setId(id);
        User user = userService.onUpdate(entity);
        return new ApiResponse<User>().apiSingleResponseResponseEntity(user, RequestMethod.PUT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<ApiSingleResponse<User>> onDelete(@PathVariable("id") Long id) {
        User user = userService.onDelete(id);
        return new ApiResponse<User>().apiSingleResponseResponseEntity(user, RequestMethod.DELETE);
    }
}
