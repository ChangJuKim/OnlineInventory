package io.onlineinventory.item;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ItemControllerTest {

    @Mock
    private ItemService itemService;

    @InjectMocks
    private ItemController itemController;

    private List<Item> itemList;

    @BeforeEach
    void init() {
        itemList = new ArrayList<>();
        Item coolToken = new Item("coolToken", "Cool Token", "A token showing how cool you are");
        Item cuteToken = new Item("cuteToken", "Cute Token", "A token showing your fondness for cute things");
        itemList.add(coolToken);
        itemList.add(cuteToken);

        when(itemService.getAllItems()).thenReturn(itemList);
        when(itemService.getItem("coolToken")).thenReturn(coolToken);
        when(itemService.getItem("cuteToken")).thenReturn(cuteToken);

    }
}
