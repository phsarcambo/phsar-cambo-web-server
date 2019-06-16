package com.camsofttech.phsarcambo.service;

/*
 * @author : chhai chivon on 2/26/2019.
 * Software Engineer
 */

import com.camsofttech.phsarcambo.model.Product;
import com.camsofttech.phsarcambo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IAbstractService<Product> {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Page<Product> findAll(int page, int limit) {
        return productRepository.findAll(new PageRequest(page,limit));
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> productOptional  = productRepository.findById(id);
        if(productOptional.isPresent()){
            return productOptional.get();
        }
        return null;
    }

    @Override
    public Product onSave(Product entity) {
        return productRepository.save(entity);
    }

    @Override
    public Product onUpdate(Product entity) {
        return productRepository.save(entity);
    }

    @Override
    public Product onDelete(Long id) {
        Product product  = findById(id);
        if(product  !=  null){
            productRepository.deleteById(id);
            return product;
        }
        return null;
    }
}
