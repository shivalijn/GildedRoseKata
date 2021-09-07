package com.gildedrose;

class GildedRose {
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		ItemFactory itemFactory = new ItemFactory();
		for (Item item : items) {
			// get an object of item to be updated
			RequestedItem requestedItem = itemFactory.getItem(item);

			// call updateItemQuality method of item to be updated
			requestedItem.updateItemQuality(item);
		}
	}
}
