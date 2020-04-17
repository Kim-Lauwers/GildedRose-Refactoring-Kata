package com.gildedrose.domain.calculator;

public class DefaultProductQualityCalculator implements QualityCalculator {
    private static final int QUALITY_DECREASE_AMOUNT = 1;
    private static final int MINIMUM_QUALITY = 0;

    @Override
    public int calculateQualityWithinSellIn(final int currentQuality, final int sellIn) {
        return calculateQualitySellInOvertime(currentQuality,QUALITY_DECREASE_AMOUNT);
    }

    @Override
    public int calculateQualitySellInOvertime(final int currentQuality, final int amountToDecreaseWith) {
        return (currentQuality - amountToDecreaseWith) >= MINIMUM_QUALITY ? currentQuality - amountToDecreaseWith : MINIMUM_QUALITY;
    }

    @Override
    public boolean appliesTo(final String productName) {
        return true;
    }
}