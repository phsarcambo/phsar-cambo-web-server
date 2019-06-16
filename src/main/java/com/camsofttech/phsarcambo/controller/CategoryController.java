package com.camsofttech.phsarcambo.controller;

/*
 * @author : chhai chivon on 2/26/2019.
 * Software Engineer
 */

import com.camsofttech.phsarcambo.model.*;
import com.camsofttech.phsarcambo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/categories")
public class CategoryController implements IBaseController<Category> {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<ApiPageResponse<Category>> findAllBy(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "limit",defaultValue = "100") int limit ) {
        Page<Category> categoryPage = categoryService.findAll(page,limit);
        return new ApiResponse<Category>().apiPageResponseResponseEntity(categoryPage);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<ApiSingleResponse<Category>> findById(@PathVariable("id") Long id) {
        Category category  = categoryService.findById(id);
        return new ApiResponse<Category>().apiSingleResponseResponseEntity(category, RequestMethod.POST);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<ApiSingleResponse<Category>> onSave(@RequestBody Category entity) {
        Category category = categoryService.onSave(entity);
        return new ApiResponse<Category>().apiSingleResponseResponseEntity(category, RequestMethod.POST);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<ApiSingleResponse<Category>> onUpdate(@PathVariable("id") Long id, @RequestBody Category entity) {
        entity.setId(id);
        Category category = categoryService.onUpdate(entity);
        return new ApiResponse<Category>().apiSingleResponseResponseEntity(new Category(), RequestMethod.PUT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<ApiSingleResponse<Category>> onDelete(@PathVariable("id") Long id) {
        Category category = categoryService.onDelete(id);
        return new ApiResponse<Category>().apiSingleResponseResponseEntity(category, RequestMethod.DELETE);
    }
}
