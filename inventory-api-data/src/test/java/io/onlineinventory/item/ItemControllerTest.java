package io.onlineinventory.item;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import io.onlineinventory.util.Constants;

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
        itemList = Arrays.asList(new Item[] { Constants.COOL_TOKEN, Constants.CUTE_TOKEN });

        when(itemService.getAllItems()).thenReturn(itemList);
        when(itemService.getItem("coolToken")).thenReturn(Constants.COOL_TOKEN);
        when(itemService.getItem("cuteToken")).thenReturn(Constants.CUTE_TOKEN);

    }
}
