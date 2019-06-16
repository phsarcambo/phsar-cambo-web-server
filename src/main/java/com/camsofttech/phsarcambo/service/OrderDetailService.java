package com.camsofttech.phsarcambo.service;

import com.camsofttech.phsarcambo.model.OrderDetail;
import com.camsofttech.phsarcambo.repository.OrderDetailRepository;
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
public class OrderDetailService  implements IAbstractService<OrderDetail> {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public Page<OrderDetail> findAll(int page, int limit) {
        return orderDetailRepository.findAll(new PageRequest(page,limit));
    }

    @Override
    public OrderDetail findById(Long id) {
        Optional<OrderDetail> orderDetail = orderDetailRepository.findById(id);
        return orderDetail.orElse(null);
    }

    @Override
    public OrderDetail onSave(OrderDetail entity) {
        return orderDetailRepository.save(entity);
    }

    @Override
    public OrderDetail onUpdate(OrderDetail entity) {
        return orderDetailRepository.save(entity);
    }

    @Override
    public OrderDetail onDelete(Long id) {
        if(findById(id) != null){
            OrderDetail orderDetail = findById(id);
            orderDetailRepository.deleteById(id);
            return orderDetail;
        }
        return null;
    }
}
