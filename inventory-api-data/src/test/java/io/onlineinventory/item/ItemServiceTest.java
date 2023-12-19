package io.onlineinventory.item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import io.onlineinventory.util.Constants;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemService itemService;

    @BeforeEach
    void init() {
        Mockito.reset(itemRepository);
    }

    @Test
    void testGetAllItems() {

        List<Item> itemList = Arrays
                .asList(new Item[] { Constants.COOL_TOKEN, Constants.CUTE_TOKEN, Constants.STRONG_TOKEN });

        when(itemRepository.findAll()).thenReturn(itemList);

        List<Item> result = itemService.getAllItems();

        assertEquals(itemList, result);
        verify(itemRepository, times(1)).findAll();
    }

    @Nested
    @DisplayName("Testing getItem")
    class GetItemTest {

        @Test
        void testGetItem() {
            Item item = Constants.COOL_TOKEN;
            when(itemRepository.findById("coolToken")).thenReturn(Optional.of(item));

            Item result = itemService.getItem("coolToken");

            assertEquals(item, result);
            verify(itemRepository, times(1)).findById("coolToken");
        }

        @Test
        void testGetNonexistentItem() {
            Exception ex = new NoSuchElementException();
            when(itemRepository.findById("falseId")).thenThrow(ex);

            Item result = itemService.getItem("falseId");

            assertEquals(null, result);
            verify(itemRepository, times(1)).findById("falseId");
        }
    }

    @Nested
    @DisplayName("Testing addItem")
    class AddItemTest {

        @Test
        void testAddItem() {
            when(itemRepository.save(Constants.COOL_TOKEN)).thenReturn(Constants.COOL_TOKEN);

            itemService.addItem(Constants.COOL_TOKEN);

            verify(itemRepository, times(1)).save(Constants.COOL_TOKEN);
        }
    }

    @Nested
    @DisplayName("Testing updateItem")
    class UpdateItemTest {

        @Test
        void testUpdateItem() {
            when(itemRepository.save(Constants.COOL_TOKEN)).thenReturn(Constants.COOL_TOKEN);

            itemService.updateItem("coolToken", Constants.COOL_TOKEN);

            verify(itemRepository, times(1)).save(Constants.COOL_TOKEN);
        }

        @Test
        void testUpdateItemDifferentId() {
            try {
                itemService.updateItem("fake id", Constants.COOL_TOKEN);
                fail("Did not throw exception");
            } catch (IllegalArgumentException ex) {
                verify(itemRepository, times(0)).save(Constants.COOL_TOKEN);
            }
        }
    }

    @Nested
    @DisplayName("Testing deleteItem")
    class DeleteItemTest {

        @Test
        void testDeleteItem() {
            itemService.deleteItem("coolToken");

            verify(itemRepository, times(1)).deleteById("coolToken");
        }
    }
}
