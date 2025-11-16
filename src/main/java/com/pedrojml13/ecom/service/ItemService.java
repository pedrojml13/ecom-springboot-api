package com.pedrojml13.ecom.service;

import com.pedrojml13.ecom.model.Item;
import com.pedrojml13.ecom.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository repository;

    public List<Item> getAllItems(){
        return repository.findAll();
    }

    public Item saveItem (Item item){
        return repository.save(item);
    }

    public Item getItemById(int id) {
        return repository.findById(id).orElse(null);
    }
}
