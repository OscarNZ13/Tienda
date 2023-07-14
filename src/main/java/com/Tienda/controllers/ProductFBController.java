package com.Tienda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.Tienda.dto.ProductFB;
import com.Tienda.service.IProductFBService;

@Controller
@RequestMapping("/FireProduct")
public class ProductFBController {

    @Autowired
    private IProductFBService service;

    @GetMapping(value = "/greet/{name}")
    public String greet(@PathVariable(value = "name") String name) {
        return "Hello, " + name;
    }

    @GetMapping(value = "/list")
    public ResponseEntity list() {
        return new ResponseEntity(service.list(), HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity add(@RequestBody ProductFB product) {
        return new ResponseEntity(service.add(product), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}/update")
    public ResponseEntity edit(@PathVariable(value = "id") String id, @RequestBody ProductFB product) {
        return new ResponseEntity(service.edit(id, product), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}/delete")
    public ResponseEntity delete(@PathVariable(value = "id") String id) {
        return new ResponseEntity(service.delete(id), HttpStatus.OK);
    }
}
