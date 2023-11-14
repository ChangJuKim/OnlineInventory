package io.onlineinventory.item;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/items")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    // Don't need ("id") after PathVariable when the variable names are the same
    @RequestMapping("/items/{id}")
    public Item getItem(@PathVariable("id") String id) {
        return itemService.getItem(id);
    }

    // By default method is GET
    @RequestMapping(method = RequestMethod.POST, value = "/items")
    public void addItem(@RequestBody Item item) {
        itemService.addItem(item);
    }
}
