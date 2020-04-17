package com.gildedrose.domain.calculator;

public interface QualityCalculator {
    int calculateQualityWithinSellIn(final int currentQuality, final int sellIn);

    int decreaseQuality(final int currentQuality, final int amountToDecreaseWith);

    boolean appliesTo(final String productName);
}
