package com.gildedrose.domain.calculator;

import static java.lang.Math.min;

public class AgedBrieProductQualityCalculator implements QualityCalculator {
    private static final int QUALITY_CHANGE_AMOUNT = 1;
    private static final int MAXIMUM_QUALITY = 50;
    private static final int MINIMUM_QUALITY = 0;

    @Override
    public int applyNewDay(final int currentQuality, final int sellIn) {
        int newQuality = currentQuality + QUALITY_CHANGE_AMOUNT;

        return min(MAXIMUM_QUALITY, newQuality);
    }

    @Override
    public int decreaseQuality(final int currentQuality, final int amountToDecreaseWith) {
        return (currentQuality - amountToDecreaseWith) >= MINIMUM_QUALITY ? currentQuality - amountToDecreaseWith : MINIMUM_QUALITY;
    }

    @Override
    public boolean appliesTo(final String productName) {
        return "Aged Brie".equals(productName);
    }
}