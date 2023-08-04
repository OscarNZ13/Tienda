package com.Tienda.service.impl;

import com.Tienda.db.IProductRepository;
import com.Tienda.entities.Item;
import com.Tienda.entities.Product;
import com.Tienda.service.IProductService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends BaseService<Product, Integer> implements IProductService {

    //here we have to create this variable because of syntax we can't see the this.repository as a IproductRepository
    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        super(productRepository);
        this.productRepository = productRepository;
    }

    public List<Product> getProductsWithFilters(Optional<Integer> lowerPrice, Optional<Integer> higherPrice) {

        if (lowerPrice.isPresent() && higherPrice.isPresent()) {
            return this.productRepository.findAllByPrecioBetween(lowerPrice.get(), higherPrice.get());
        }

        if (lowerPrice.isPresent()) {
            return this.productRepository.findAllByPrecioGreaterThanEqual(lowerPrice.get());
        }

        if (higherPrice.isPresent()) {
            return this.productRepository.findAllByPrecioIsLessThanEqual(higherPrice.get());
        }

        return (List<Product>) this.productRepository.findAll();
    }

    @Override
    public Product getProduct(Item item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProduct'");
    }
}
