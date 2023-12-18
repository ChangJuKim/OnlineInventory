package io.onlineinventory.util;

import io.onlineinventory.item.Item;

public class Constants {

    private Constants() {

    }

    public static final Item COOL_TOKEN = new Item("coolToken", "Cool Token", "A token showing how cool you are");
    public static final Item CUTE_TOKEN = new Item("cuteToken", "Cute Token",
            "A token showing your fondness for cute things");
    public static final Item STRONG_TOKEN = new Item("strongToken", "Strong Token",
            "A token indicating your strength. Holding onto it attracts trouble");
    public static final Item EMPTY_TOKEN = new Item();
}
