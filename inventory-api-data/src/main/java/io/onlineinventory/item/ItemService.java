package io.onlineinventory.item;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();
        itemRepository.findAll().forEach(items::add);
        return items;
    }

    public Item getItem(String id) {
        Item item;
        try {
            item = itemRepository.findById(id).get();
        } catch (NoSuchElementException ex) {
            item = null;
        }
        return item;
    }

    public void addItem(Item item) {
        itemRepository.save(item);
    }

    public void updateItem(String id, Item item) {
        if (item.getId().equals(id)) {
            itemRepository.save(item);
        } else {
            throw new IllegalArgumentException("Improper id " + id + " for item " + item);
        }
    }

    public void deleteItem(String id) {
        itemRepository.deleteById(id);
    }
}
