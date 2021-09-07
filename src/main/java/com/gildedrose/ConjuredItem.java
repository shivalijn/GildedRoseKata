package com.gildedrose;

public class ConjuredItem implements RequestedItem {

	@Override
	public void updateItemQuality(Item item) {
		decrementQuality(item);
		decrementQuality(item);

		// the sell by date has passed
		if (item.sellIn <= 0) {
			decrementQuality(item);
			decrementQuality(item);
		}
		item.sellIn--;
	}

}
