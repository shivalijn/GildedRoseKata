package com.gildedrose;

public class AgedBrieItem implements RequestedItem {

	@Override
	public void updateItemQuality(Item item) {

		incrementQuality(item);

		// the sell by date has passed
		if (item.sellIn < 0) {
			incrementQuality(item);
		}

		item.sellIn--;
	}

}
