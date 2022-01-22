package com.challenge.crudmysql.controller;

import com.challenge.crudmysql.model.Item;
import com.challenge.crudmysql.service.ItemService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    Logger LOGGER = LogManager.getLogger(ItemController.class);

    @Autowired
    ItemService itemService;

    @PostMapping()
    public Item createItem(@RequestBody Item item){
        LOGGER.info("An item is created");
        return itemService.createItem(item);
    }

    @GetMapping()
    public List<Item> getAllItems(){
        LOGGER.info("All items are returned");
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable Long id){
        LOGGER.info("An item with ID {} is returned", id);
        return itemService.getItemById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id){
        LOGGER.info("An item with ID {} is deleted", id);
        itemService.deleteItem(id);
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody Item itemToUpdate){
        LOGGER.info("An item with ID {} is updated", id);
        return itemService.updateItem(id,itemToUpdate);
    }
}
