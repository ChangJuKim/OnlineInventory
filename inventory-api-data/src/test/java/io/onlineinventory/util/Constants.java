package io.onlineinventory.util;

import io.onlineinventory.item.Item;

public class Constants {

    private Constants() {

    }

    public static final Item COOLTOKEN = new Item("coolToken", "Cool Token", "A token showing how cool you are");
    public static final Item CUTETOKEN = new Item("cuteToken", "Cute Token",
            "A token showing your fondness for cute things");
    public static final Item NEWTOKEN = new Item("strongToken", "Strong Token",
            "A token indicating your strength. Holding onto it attracts trouble");
    public static final Item EMPTYTOKEN = new Item();
}
