package com.Tienda.service.impl;

import com.Tienda.db.ICategoryRepository;
import com.Tienda.entities.Category;
import com.Tienda.service.ICategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends BaseService<Category, Integer> implements ICategoryService {
    public CategoryService(ICategoryRepository categoryRepository) {
        super(categoryRepository);
    }

}
