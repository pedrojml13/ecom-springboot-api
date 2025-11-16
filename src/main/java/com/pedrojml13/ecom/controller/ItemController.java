package com.pedrojml13.ecom.controller;

import com.pedrojml13.ecom.model.Item;
import com.pedrojml13.ecom.model.Product;
import com.pedrojml13.ecom.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    ItemService service;

    @GetMapping("/items")
    public List<Item> getItems(){
        return service.getAllItems();
    }

    @GetMapping("/item/{id}")
    public Item getItem(@PathVariable int id){
        return service.getItemById(id);
    }

    @PostMapping("/item")
    public ResponseEntity saveItem(@RequestBody Item item){
        Item savedItem = service.saveItem(item);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

}
