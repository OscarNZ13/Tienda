package com.Tienda.controllers;

import com.Tienda.entities.Product;
import com.Tienda.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {
    private final IProductService productService;
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    //R
    @GetMapping("/product")
    public String index(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("products", this.productService.getAllProducts());
        return "product";
    }

    //C and U
    @PostMapping("product/save")
    public String save(@ModelAttribute("product") Product product) {
        this.productService.save(product);

        //Cambiar esto de recargar la vista
        return "redirect:/product";
    }

    //D
    @PostMapping("product/delete")
    public ResponseEntity<String> delete(@RequestBody Product product) {
        this.productService.delete(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}