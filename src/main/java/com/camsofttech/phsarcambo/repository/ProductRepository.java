package com.camsofttech.phsarcambo.repository;

import com.camsofttech.phsarcambo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * @author : chhai chivon on 2/26/2019.
 * Software Engineer
 */

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
