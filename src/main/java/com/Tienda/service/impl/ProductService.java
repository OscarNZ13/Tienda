package com.Tienda.service.impl;

import com.Tienda.db.IProductRepository;
import com.Tienda.entities.Product;
import com.Tienda.service.IProductService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService implements IProductService {
    private final IProductRepository productRepository;
    
    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    public List<Product> getAllProducts() {
        return (List<Product>) this.productRepository.findAll();
    }
}
