package com.challenge.crudmysql.service;

import com.challenge.crudmysql.model.Item;
import com.challenge.crudmysql.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository repository;

    @Override
    public List<Item> getAllItems() {
        return (List<Item>) repository.findAll();
    }

    @Override
    public Item getItemById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Item createItem(Item i) {
        return repository.save(i);
    }

    @Override
    public void deleteItem(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Item updateItem(Long id, Item i) {
        Optional<Item> optional = repository.findById(id);

        Item itemToUpdate = null;

        if(optional.isPresent()){
            itemToUpdate = optional.get();
            itemToUpdate.setName(i.getName());
            itemToUpdate.setCategory(i.getCategory());
            itemToUpdate.setStock(i.getStock());
            repository.save(itemToUpdate);
        }
        return itemToUpdate;
    }
}
