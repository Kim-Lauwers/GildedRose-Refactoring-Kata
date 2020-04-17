package com.gildedrose.domain.calculator.quality;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class AgedBrieProductQualityCalculator implements QualityCalculator {
    private static final int QUALITY_CHANGE_AMOUNT = 1;
    private static final int QUALITY_CHANGE_AMOUNT_OVERTIME = 2;
    private static final int MAXIMUM_QUALITY = 50;
    private static final int MINIMUM_QUALITY = 0;

    @Override
    public int calculateQualityWithinSellIn(final int currentQuality, final int sellIn) {
        int newQuality = currentQuality + QUALITY_CHANGE_AMOUNT;

        return min(MAXIMUM_QUALITY, newQuality);
    }

    @Override
    public int calculateQualitySellInOvertime(final int currentQuality) {
        return max(MINIMUM_QUALITY, currentQuality - QUALITY_CHANGE_AMOUNT_OVERTIME);
    }

    @Override
    public boolean appliesTo(final String productName) {
        return "Aged Brie".equals(productName);
    }
}