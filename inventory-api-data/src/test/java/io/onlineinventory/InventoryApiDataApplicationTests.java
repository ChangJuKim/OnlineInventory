package io.onlineinventory;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.onlineinventory.item.Item;

@SpringBootTest
class InventoryApiDataApplicationTests {

	@Test
	void contextLoads() {
		Item item = new Item("an ID", "a name", "a description");
		String expected = "an ID";

		assertEquals(item.getId(), expected);

	}

}
