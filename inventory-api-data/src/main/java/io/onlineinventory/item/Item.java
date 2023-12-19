package io.onlineinventory.item;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Item {

    @Id
    private final String id;
    private String name;
    private String description;

    public Item(String id) {
        this.id = id;
    }

    public Item(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return "{\nid: " + this.id + "\n\tname: " + this.name + "\n\tdescription: " + this.description + "}";
    }
}
