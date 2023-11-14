package io.onlineinventory.item;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private List<Item> items = Arrays.asList(
            new Item("coolToken", "Cool Token", "A token showing how cool you are"),
            new Item("cuteToken", "Cute Token", "A token showing your fondness for cute things"),
            new Item("strongToken", "Strong Token",
                    "A token indicating your strength. Highly contested. Holding onto it attracts trouble"));

    public List<Item> getAllItems() {
        return items;
    }

    public Item getItem(String id) {
        return items.stream().filter(item -> item.getId().equals(id)).findFirst().get();
    }
}
