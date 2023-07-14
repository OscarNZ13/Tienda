package com.Tienda.service;

import java.util.List;

import com.Tienda.dto.ProductFB;

public interface IProductFBService {

    List<ProductFB> list();

    Boolean add(ProductFB product);

    Boolean edit(String id, ProductFB product);

    Boolean delete(String id);
}
