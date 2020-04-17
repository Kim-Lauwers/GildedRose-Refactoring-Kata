package com.gildedrose.domain.calculator;

import static java.lang.Math.max;

public class ConjuredProductQualityCalculator implements QualityCalculator {
    private static final int QUALITY_DECREASE_AMOUNT = 2;
    private static final int MINIMUM_QUALITY = 0;

    @Override
    public int calculateQualityWithinSellIn(final int currentQuality, final int sellIn) {
        return max(MINIMUM_QUALITY, currentQuality - QUALITY_DECREASE_AMOUNT);
    }

    @Override
    public int calculateQualitySellInOvertime(final int currentQuality, final int amountToDecreaseWith) {
        return max(MINIMUM_QUALITY, currentQuality - (amountToDecreaseWith * 2));
    }

    @Override
    public boolean appliesTo(final String productName) {
        return true;
    }
}