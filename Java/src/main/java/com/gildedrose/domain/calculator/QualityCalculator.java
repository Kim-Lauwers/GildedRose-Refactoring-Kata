package com.gildedrose.domain.calculator;

public interface QualityCalculator {
    int calculateQualityWithinSellIn(final int currentQuality, final int sellIn);

    int calculateQualitySellInOvertime(final int currentQuality);

    boolean appliesTo(final String productName);
}
