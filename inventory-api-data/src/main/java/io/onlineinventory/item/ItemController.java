package io.onlineinventory.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    private ItemService itemService;

    // Technically autowired unnecessary as we only have one constructor
    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

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

    @RequestMapping(method = RequestMethod.PUT, value = "/items/{id}")
    public void updateItem(@RequestBody Item item, @PathVariable String id) {
        itemService.updateItem(id, item);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/items/{id}")
    public void deleteItem(@PathVariable String id) {
        itemService.deleteItem(id);
    }
}
