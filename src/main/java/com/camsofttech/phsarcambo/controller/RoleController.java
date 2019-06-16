package com.camsofttech.phsarcambo.controller;

/**
 * @author : chhai chivon on 4/28/2019.
 * Software Engineer
 */

import com.camsofttech.phsarcambo.model.ApiPageResponse;
import com.camsofttech.phsarcambo.model.ApiResponse;
import com.camsofttech.phsarcambo.model.ApiSingleResponse;
import com.camsofttech.phsarcambo.model.Role;
import com.camsofttech.phsarcambo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/roles")
@RestController
public class RoleController implements IBaseController<Role> {

    private RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<ApiPageResponse<Role>> findAllBy(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "limit",defaultValue = "100") int limit) {
        Page<Role> rolePage = roleService.findAll(page,limit);
        return new ApiResponse<Role>().apiPageResponseResponseEntity(rolePage);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<ApiSingleResponse<Role>> findById(@PathVariable("id") Long id) {
        Role role  = roleService.findById(id);
        return new ApiResponse<Role>().apiSingleResponseResponseEntity(role, RequestMethod.POST);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<ApiSingleResponse<Role>> onSave(Role entity) {
        Role role = roleService.onSave(entity);
        return new ApiResponse<Role>().apiSingleResponseResponseEntity(role, RequestMethod.POST);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<ApiSingleResponse<Role>> onUpdate(@PathVariable("id") Long id, Role entity) {
        entity.setId(id);
        Role role  = roleService.onUpdate(entity);
        return new ApiResponse<Role>().apiSingleResponseResponseEntity(role, RequestMethod.PUT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<ApiSingleResponse<Role>> onDelete(@PathVariable("id") Long id) {
        Role role = roleService.onDelete(id);
        return new ApiResponse<Role>().apiSingleResponseResponseEntity(role, RequestMethod.DELETE);
    }
}
