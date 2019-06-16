package com.camsofttech.phsarcambo.repository;

import com.camsofttech.phsarcambo.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : chhai chivon on 6/11/2019.
 * Software Engineer
 */
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {
}
