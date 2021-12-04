package com.topolia.roulette;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class RouletteApplicationTests {

	@Test
	void contextLoads() {
		ArrayList<Integer> collection = new ArrayList<Integer>(4);
		collection.add(1);
		collection.add(2);
		collection.add(3);
		collection.add(4);

		Iterable<Integer> it = (Iterable<Integer>)collection;

		for (int item: it) {
			System.out.println(item);
		}
	}

}
