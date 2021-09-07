package com.gildedrose;

public interface RequestedItem {
	
	public static final Integer MINIMUM_QUALITY = 0;
	public static final Integer MAXIMUM_QUALITY = 50;

	default void updateItemQuality(Item item) {
		decrementQuality(item);

		// the sell by date has passed
		if (item.sellIn < 0) {
			decrementQuality(item);
		}

		item.sellIn--;
	}

	default void decrementQuality(Item item) {
		if (item.quality > MINIMUM_QUALITY) {
			item.quality--;
		}
	}

	default void incrementQuality(Item item) {
		if (item.quality < MAXIMUM_QUALITY) {
			item.quality++;
		}
	}

}
