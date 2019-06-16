package com.camsofttech.phsarcambo.service;

/*
 * @author : chhai chivon on 2/26/2019.
 * Software Engineer
 */

import com.camsofttech.phsarcambo.model.Category;
import com.camsofttech.phsarcambo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements IAbstractService<Category> {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Page<Category> findAll(int page, int limit) {
        return categoryRepository.findAll(new PageRequest(page,limit));
    }

    @Override
    public Category findById(Long id) {
        Optional<Category>  categoryOptional = categoryRepository.findById(id);
        if(categoryOptional.isPresent()){
            return categoryOptional.get();
        }
        return null;
    }

    @Override
    public Category onSave(Category entity) {
        return categoryRepository.save(entity);
    }

    @Override
    public Category onUpdate(Category entity) {
        return categoryRepository.save(entity);
    }

    @Override
    public Category onDelete(Long id) {
        Category category = findById(id);
        if(category != null){
            categoryRepository.deleteById(id);
            return category;
        }
        return null;
    }

    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }
}
