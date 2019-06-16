package com.camsofttech.phsarcambo.controller;

import com.camsofttech.phsarcambo.model.Product;
import com.camsofttech.phsarcambo.model.ApiPageResponse;
import com.camsofttech.phsarcambo.model.ApiResponse;
import com.camsofttech.phsarcambo.model.ApiSingleResponse;
import com.camsofttech.phsarcambo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 * @author : chhai chivon on 2/26/2019.
 * Software Engineer
 */
@RestController
@RequestMapping(value = "/api/products")
public class ProductController implements IBaseController<Product> {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<ApiPageResponse<Product>> findAllBy(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "limit",defaultValue = "100") int limit) {
        Page<Product> productPage = productService.findAll(page,limit);
        return new ApiResponse<Product>().apiPageResponseResponseEntity(productPage);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<ApiSingleResponse<Product>> findById(@PathVariable("id") Long id) {
        Product product = productService.findById(id);
        return new ApiResponse<Product>().apiSingleResponseResponseEntity(product, RequestMethod.POST);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<ApiSingleResponse<Product>> onSave(Product entity) {
        Product product = productService.onSave(entity);
        return new ApiResponse<Product>().apiSingleResponseResponseEntity(product, RequestMethod.POST);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<ApiSingleResponse<Product>> onUpdate(@PathVariable("id") Long id, Product entity) {
        entity.setId(id);
        Product product = productService.onUpdate(entity);
        return new ApiResponse<Product>().apiSingleResponseResponseEntity(product, RequestMethod.PUT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<ApiSingleResponse<Product>> onDelete(@PathVariable("id") Long id) {
        Product product = productService.onDelete(id);
        return new ApiResponse<Product>().apiSingleResponseResponseEntity(product, RequestMethod.DELETE);
    }
}
