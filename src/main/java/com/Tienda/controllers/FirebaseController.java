package com.Tienda.controllers;

import com.Tienda.dto.PostDTO;
import com.Tienda.service.IFirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/firebase")
public class FirebaseController {

    @Autowired
    private IFirebaseService service;

    @GetMapping(value = "/greet/{name}")
    public String greet(@PathVariable(value = "name") String name){
        return  "Hello, "+name;
    }

    @GetMapping(value = "/list")
    public ResponseEntity list(){
        return new ResponseEntity(service.list(), HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity add(@RequestBody PostDTO post){
        return new ResponseEntity(service.add(post), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}/update")
    public ResponseEntity edit(@PathVariable(value = "id") String id, @RequestBody PostDTO post){
        return new ResponseEntity(service.edit(id,post), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}/delete")
    public ResponseEntity delete(@PathVariable(value = "id") String id){
        return  new ResponseEntity(service.delete(id), HttpStatus.OK);
    }
}
