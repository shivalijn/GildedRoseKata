package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GildedRoseTest {

	private static final String STANDARD_ITEM = "Standard Item";

	private GildedRose app;
	private Item[] items;

	@Test
	void decrementSellInAndQuality_ofStandardItem_atEndOfDay() throws Exception {
		// setup
		items = new Item[] { new Item(STANDARD_ITEM, 15, 5) };
		app = new GildedRose(items);

		// execute
		app.updateQuality();

		// verify
		assertEquals(14, items[0].sellIn);
		assertEquals(4, items[0].quality);
	}

	@Test
	void decrementQualityTwiceAsFast_whenSellByDateHasPassed() throws Exception {
		// setup
		items = new Item[] { new Item(STANDARD_ITEM, -1, 15) };
		app = new GildedRose(items);

		// execute
		app.updateQuality();

		// verify
		assertEquals(-2, items[0].sellIn);
		assertEquals(13, items[0].quality);
	}

	@Test
	void shouldNotDecrementQualityBelowZero() throws Exception {
		// setup
		items = new Item[] { new Item(STANDARD_ITEM, 20, 0) };
		app = new GildedRose(items);

		// execute
		app.updateQuality();

		// verify
		assertEquals(19, items[0].sellIn);
		assertEquals(0, items[0].quality);
	}

	@Test
	void incrementAgedBrieQuality_atEndOfDay() throws Exception {
		// setup
		items = new Item[] { new Item(ItemFactory.AGED_BRIE_ITEM, 12, 16) };
		app = new GildedRose(items);

		// execute
		app.updateQuality();

		// verify
		assertEquals(11, items[0].sellIn);
		assertEquals(17, items[0].quality);
	}

	@Test
	void shouldNotDecrementSulfurasSellInAndQuality() throws Exception {
		// setup
		items = new Item[] { new Item(ItemFactory.SULFURAS_ITEM, 15, 15) };
		app = new GildedRose(items);

		// execute
		app.updateQuality();

		// verify
		assertEquals(15, items[0].sellIn);
		assertEquals(15, items[0].quality);
	}

	@Test
	void incrementBackstagePassesQuality_atEndOfDay() throws Exception {
		// setup
		items = new Item[] { new Item(ItemFactory.BACKSTAGE_PASSES_ITEM, 20, 11) };
		app = new GildedRose(items);

		// execute
		app.updateQuality();

		// verify
		assertEquals(19, items[0].sellIn);
		assertEquals(12, items[0].quality);
	}

	@Test
	void shouldNotIncrementBackstagePassesQuality_whenAboveFifty() throws Exception {
		// setup
		items = new Item[] { new Item(ItemFactory.BACKSTAGE_PASSES_ITEM, 20, 50) };
		app = new GildedRose(items);

		// execute
		app.updateQuality();

		// verify
		assertEquals(19, items[0].sellIn);
		assertEquals(50, items[0].quality);
	}

	@Test
	void incrementBackstagePassesQualityTwiceAsFast_whenSellInValueEqualOrLessThanTen() throws Exception {
		// setup
		items = new Item[] { new Item(ItemFactory.BACKSTAGE_PASSES_ITEM, 9, 12) };
		app = new GildedRose(items);

		// execute
		app.updateQuality();

		// verify
		assertEquals(8, items[0].sellIn);
		assertEquals(14, items[0].quality);
	}

	@Test
	void incrementBackstagePassesQualityThriceAsFast_whenSellInValueEqualOrLessThanFive() throws Exception {
		// setup
		items = new Item[] { new Item(ItemFactory.BACKSTAGE_PASSES_ITEM, 5, 12) };
		app = new GildedRose(items);

		// execute
		app.updateQuality();

		// verify
		assertEquals(4, items[0].sellIn);
		assertEquals(15, items[0].quality);
	}

	@Test
	void decrementBackstagePassesQualityToZero_whenSellByDateHasPassed() throws Exception {
		// setup
		items = new Item[] { new Item(ItemFactory.BACKSTAGE_PASSES_ITEM, -1, 15) };
		app = new GildedRose(items);

		// execute
		app.updateQuality();

		// verify
		assertEquals(-2, items[0].sellIn);
		assertEquals(0, items[0].quality);
	}

	@Test
	void decrementConjuredItemQualityTwiceAsFast() throws Exception {
		// setup
		items = new Item[] { new Item(ItemFactory.CONJURED_ITEM, 20, 12) };
		app = new GildedRose(items);

		// execute
		app.updateQuality();

		// verify
		assertEquals(19, items[0].sellIn);
		assertEquals(10, items[0].quality);
	}

	@Test
	void shouldNotDecrementConjuredItemQualityBelowZero() throws Exception {
		// setup
		items = new Item[] { new Item(ItemFactory.CONJURED_ITEM, 10, 0) };
		app = new GildedRose(items);

		// execute
		app.updateQuality();

		// verify
		assertEquals(9, items[0].sellIn);
		assertEquals(0, items[0].quality);
	}

}
