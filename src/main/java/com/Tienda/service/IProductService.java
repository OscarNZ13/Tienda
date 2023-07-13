package com.Tienda.service;

import java.util.List;
import java.util.Optional;

import com.Tienda.entities.Product;

public interface IProductService extends IBaseService<Product, Integer> {

    //La palabra "optional" quiere decir que puede recibir uno solamente de los 2 parametros que le damos, 
    //o no puede recibor ninguno
    List<Product> getProductsWithFilters(Optional<Integer> lowerPrice, Optional<Integer> higherPrice);
}
