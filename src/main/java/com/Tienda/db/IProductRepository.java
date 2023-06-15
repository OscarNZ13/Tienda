package com.Tienda.db;

import com.Tienda.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductRepository extends CrudRepository<Product, Integer> {    
    //Acá le estamos mandando un entities(Product) y un integer
    
}
