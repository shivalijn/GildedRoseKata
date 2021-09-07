package com.gildedrose;

public class BackstagePassesItem implements RequestedItem {

	@Override
	public void updateItemQuality(Item item) {
		// after the concert
		if (item.sellIn < 0) {
			item.quality = 0;
		} else {
			incrementQuality(item);
			qualityIncreaseJustBeforeConcert(item);
		}
		item.sellIn--;
	}

	private void qualityIncreaseJustBeforeConcert(Item item) {
		if (item.sellIn <= 10) {
			incrementQuality(item);
		}
		if (item.sellIn <= 5) {
			incrementQuality(item);
		}
	}

}
