package com.camsofttech.phsarcambo.controller;

import com.camsofttech.phsarcambo.model.*;
import com.camsofttech.phsarcambo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author : chhai chivon on 6/7/2019.
 * Software Engineer
 */

@RestController
@RequestMapping(value = "/api/orders")
public class OrderController implements IBaseController<Order>{


    private OrderService orderService;
    @Autowired
    public OrderController( OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<ApiPageResponse<Order>> findAllBy(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "limit",defaultValue = "100") int limit) {
        Page<Order> orderPage = orderService.findAll(page,limit);
        return new ApiResponse<Order>().apiPageResponseResponseEntity(orderPage);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<ApiSingleResponse<Order>> findById(@PathVariable("id") Long id) {
        Order order = orderService.findById(id);
        return new ApiResponse<Order>().apiSingleResponseResponseEntity(order, RequestMethod.POST);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<ApiSingleResponse<Order>> onSave(@RequestBody Order entity) {
        Order order = orderService.onSave(entity);
        return new ApiResponse<Order>().apiSingleResponseResponseEntity(order, RequestMethod.POST);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<ApiSingleResponse<Order>> onUpdate(@PathVariable("id") Long id, @RequestBody Order entity) {
        entity.setId(id);
        Order order = orderService.onUpdate(entity);
        return new ApiResponse<Order>().apiSingleResponseResponseEntity(order, RequestMethod.PUT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<ApiSingleResponse<Order>> onDelete(@PathVariable("id") Long id) {
        Order order = orderService.onDelete(id);
        return new ApiResponse<Order>().apiSingleResponseResponseEntity(order, RequestMethod.DELETE);
    }
}
