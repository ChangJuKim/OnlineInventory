package io.onlineinventory.item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.onlineinventory.util.Constants;

@SpringBootTest
public class ItemTest {

    @Nested
    @DisplayName("Constructor")
    class ConstructorTest {

        @Test
        @DisplayName("Testing empty constructor")
        void testEmptyConstructor() {
            try {
                new Item("empty item");
            } catch (Exception ex) {
                fail(ex.getMessage());
            }
        }

        @Test
        @DisplayName("Testing full constructor")
        void testConstructor() {
            try {
                new Item("an id", "a name", "a description");
                new Item("123", "name", "desc");
            } catch (Exception ex) {
                fail(ex.getMessage());
            }
        }
    }

    @Nested
    @DisplayName("Getters test")
    class GetterTest {
        Item coolToken;
        Item cuteToken;
        Item emptyToken;

        @BeforeEach
        void init() {
            coolToken = Constants.COOL_TOKEN;
            cuteToken = Constants.CUTE_TOKEN;
            emptyToken = Constants.EMPTY_TOKEN;
        }

        @Test
        @DisplayName("Testing get method for id")
        void testGetId() {
            assertEquals(coolToken.getId(), Constants.COOL_TOKEN.getId());
            assertEquals(cuteToken.getId(), Constants.CUTE_TOKEN.getId());
            assertEquals(emptyToken.getId(), Constants.EMPTY_TOKEN.getId());
        }

        @Test
        @DisplayName("Testing get method for name")
        void testGetName() {
            assertEquals(coolToken.getName(), Constants.COOL_TOKEN.getName());
            assertEquals(cuteToken.getName(), Constants.CUTE_TOKEN.getName());
            assertEquals(emptyToken.getName(), Constants.EMPTY_TOKEN.getName());
        }

        @Test
        @DisplayName("Testing get method for description")
        void testGetDescription() {
            assertEquals(coolToken.getDescription(), Constants.COOL_TOKEN.getDescription());
            assertEquals(cuteToken.getDescription(), Constants.CUTE_TOKEN.getDescription());
            assertEquals(emptyToken.getDescription(), Constants.EMPTY_TOKEN.getDescription());
        }
    }

    @Nested
    @DisplayName("Setters test")
    class SetterTest {
        Item coolToken;
        Item emptyToken;

        @BeforeEach
        void init() {
            coolToken = new Item(
                    Constants.COOL_TOKEN.getId(),
                    Constants.COOL_TOKEN.getName(),
                    Constants.COOL_TOKEN.getDescription());
            emptyToken = new Item(
                    Constants.EMPTY_TOKEN.getId(),
                    Constants.EMPTY_TOKEN.getName(),
                    Constants.EMPTY_TOKEN.getDescription());
        }

        @Test
        @DisplayName("Testing set method for name")
        void testSetName() {
            String newCoolName = "New Cool Token";
            String newCuteName = "New Cute Token";

            coolToken.setName(newCoolName);
            emptyToken.setName(newCuteName);
            assertEquals(coolToken.getName(), newCoolName);
            assertEquals(emptyToken.getName(), newCuteName);
        }

        @Test
        @DisplayName("Testing set method for description")
        void testSetDescription() {
            String newCoolDescription = "A very very cool token";
            String newCuteDescription = "Now even cuter than before";

            coolToken.setDescription(newCoolDescription);
            emptyToken.setDescription(newCuteDescription);
            assertEquals(coolToken.getDescription(), newCoolDescription);
            assertEquals(emptyToken.getDescription(), newCuteDescription);
        }
    }
}