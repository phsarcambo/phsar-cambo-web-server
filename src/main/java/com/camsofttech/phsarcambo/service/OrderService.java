package com.camsofttech.phsarcambo.service;

import com.camsofttech.phsarcambo.model.Order;
import com.camsofttech.phsarcambo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author : chhai chivon on 6/11/2019.
 * Software Engineer
 */
@Service
public class OrderService implements IAbstractService<Order> {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Page<Order> findAll(int page, int limit) {
        return orderRepository.findAll(new PageRequest(page,limit));
    }

    @Override
    public Order findById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.orElse(null);
    }

    @Override
    public Order onSave(Order entity) {
        return orderRepository.save(entity);
    }

    @Override
    public Order onUpdate(Order entity) {
        return orderRepository.save(entity);
    }

    @Override
    public Order onDelete(Long id) {
        if(findById(id) != null){
            Order order = findById(id);
            orderRepository.deleteById(id);
            return order;
        }
        return null;
    }
}
