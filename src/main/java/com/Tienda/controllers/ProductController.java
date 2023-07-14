package com.Tienda.controllers;

import com.Tienda.entities.Category;
import com.Tienda.entities.Product;
import com.Tienda.service.ICategoryService;
import com.Tienda.service.IProductService;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    private final IProductService productService;
    private final ICategoryService categoryService;

    public ProductController(IProductService productService, ICategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/product")
    public String index(Model model, @RequestParam("lowerPrice") Optional<Integer> lowerPrice, @RequestParam("higherPrice") Optional<Integer> higherPrice) {

        var baseProduct = new Product();
        baseProduct.setCategory(new Category());
        model.addAttribute("productDefault", baseProduct);
        model.addAttribute("products", this.productService.getProductsWithFilters(lowerPrice, higherPrice));
        model.addAttribute("categories", this.categoryService.getAll());
        return "product";
    }

}
