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
                Item emptyItem = new Item();
            } catch (Exception ex) {
                fail(ex.getMessage());
            }
        }

        @Test
        @DisplayName("Testing full constructor")
        void testConstructor() {
            try {
                Item anItem = new Item("an id", "a name", "a description");
                Item another = new Item("123", "name", "desc");
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
            assertEquals(coolToken.getId(), "coolToken");
            assertEquals(cuteToken.getId(), "cuteToken");
            assertEquals(emptyToken.getId(), null);
        }

        @Test
        @DisplayName("Testing get method for name")
        void testGetName() {
            assertEquals(coolToken.getName(), "Cool Token");
            assertEquals(cuteToken.getName(), "Cute Token");
            assertEquals(emptyToken.getName(), null);
        }

        @Test
        @DisplayName("Testing get method for description")
        void testGetDescription() {
            assertEquals(coolToken.getDescription(), "A token showing how cool you are");
            assertEquals(cuteToken.getDescription(), "A token showing your fondness for cute things");
            assertEquals(emptyToken.getDescription(), null);
        }
    }

    @Nested
    @DisplayName("Setters test")
    class SetterTest {
        Item coolToken;
        Item emptyToken;

        @BeforeEach
        void init() {
            coolToken = Constants.COOL_TOKEN;
            emptyToken = Constants.EMPTY_TOKEN;
        }

        @Test
        @DisplayName("Testing set method for id")
        void testSetId() {
            String newCoolId = "newCoolToken";
            String newCuteId = "newCuteToken";

            coolToken.setId(newCoolId);
            emptyToken.setId(newCuteId);
            assertEquals(coolToken.getId(), newCoolId);
            assertEquals(emptyToken.getId(), newCuteId);
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