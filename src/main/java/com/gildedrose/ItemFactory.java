package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

public class ItemFactory {

	public static final String AGED_BRIE_ITEM = "Aged Brie";
	public static final String SULFURAS_ITEM = "Sulfuras, Hand of Ragnaros";
	public static final String BACKSTAGE_PASSES_ITEM = "Backstage passes to a TAFKAL80ETC concert";
	public static final String CONJURED_ITEM = "Conjured Mana Cake";

	private static final Map<String, RequestedItem> ITEM_TYPES_LIST = new HashMap<>();

	public ItemFactory() {
		ITEM_TYPES_LIST.put(AGED_BRIE_ITEM, new AgedBrieItem());
		ITEM_TYPES_LIST.put(SULFURAS_ITEM, new LegendaryItem());
		ITEM_TYPES_LIST.put(BACKSTAGE_PASSES_ITEM, new BackstagePassesItem());
		ITEM_TYPES_LIST.put(CONJURED_ITEM, new ConjuredItem());
	}

	public RequestedItem getItem(Item item) {
		if (isStandardItem(item)) {
			return new RequestedItem() {};
		}
		return ITEM_TYPES_LIST.get(item.name);
	}

	private boolean isStandardItem(Item item) {
		return !ITEM_TYPES_LIST.keySet().contains(item.name);
	}

}
