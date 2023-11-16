package io.onlineinventory.item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private List<Item> items = new ArrayList<>(Arrays.asList(
            new Item("coolToken", "Cool Token", "A token showing how cool you are"),
            new Item("cuteToken", "Cute Token", "A token showing your fondness for cute things"),
            new Item("strongToken", "Strong Token",
                    "A token indicating your strength. Highly contested. Holding onto it attracts trouble")));

    public List<Item> getAllItems() {
        return items;
    }

    public Item getItem(String id) {
        return items.stream().filter(item -> item.getId().equals(id)).findFirst().get();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void updateItem(String id, Item item) {
        for (int i = 0; i < items.size(); i++) {
            Item itemInList = items.get(i);
            if (itemInList.getId().equals(id)) {
                items.set(i, item);
                return;
            }

        }
    }

    public void deleteItem(String id) {
        items.removeIf(item -> item.getId().equals(id));
    }
}
