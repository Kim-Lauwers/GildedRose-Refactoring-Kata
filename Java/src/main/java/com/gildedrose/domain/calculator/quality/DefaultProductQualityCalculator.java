package com.gildedrose.domain.calculator.quality;

import static java.lang.Math.max;

public class DefaultProductQualityCalculator implements QualityCalculator {
    private static final int QUALITY_DECREASE_AMOUNT = 1;
    private static final int QUALITY_CHANGE_AMOUNT_OVERTIME = 2;
    private static final int MINIMUM_QUALITY = 0;

    @Override
    public int calculateQualityWithinSellIn(final int currentQuality, final int sellIn) {
        return max(MINIMUM_QUALITY, currentQuality - QUALITY_DECREASE_AMOUNT);
    }

    @Override
    public int calculateQualitySellInOvertime(final int currentQuality) {
        return max(MINIMUM_QUALITY, currentQuality - QUALITY_CHANGE_AMOUNT_OVERTIME);
    }

    @Override
    public boolean appliesTo(final String productName) {
        return true;
    }
}