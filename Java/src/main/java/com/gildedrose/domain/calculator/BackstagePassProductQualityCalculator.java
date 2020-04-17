package com.gildedrose.domain.calculator;

import static java.lang.Math.min;

public class BackstagePassProductQualityCalculator implements QualityCalculator {
    private static final int MAXIMUM_QUALITY = 50;
    private static final int MINIMUM_QUALITY = 0;

    @Override
    public int applyNewDay(final int currentQuality, final int sellIn) {
        if (sellIn <= 0) {
            return MINIMUM_QUALITY;
        }
        int newQuality = currentQuality;
        newQuality += 1;

        if (sellIn < 11) {
            newQuality += 1;
        }

        if (sellIn < 6) {
            newQuality += 1;
        }

        return min(MAXIMUM_QUALITY, newQuality);
    }

    @Override
    public int decreaseQuality(final int currentQuality, final int amountToDecreaseWith) {
        return (currentQuality - amountToDecreaseWith) >= MINIMUM_QUALITY ? currentQuality - amountToDecreaseWith : MINIMUM_QUALITY;
    }

    @Override
    public boolean appliesTo(final String productName) {
        return "Backstage passes to a TAFKAL80ETC concert".equals(productName);
    }
}