package com.challenge.crudmysql.service;

import com.challenge.crudmysql.model.Item;

import java.util.List;
//import org.springframework.stereotype.Service;

public interface ItemService {
    List<Item> getAllItems();
    Item getItemById(Long id);
    Item createItem(Item i);
    void deleteItem(Long id);
    Item updateItem(Long id, Item i);
}
