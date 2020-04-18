package com.gildedrose.domain.calculator.quality;

import com.gildedrose.domain.ProductType;

import static com.gildedrose.domain.ProductType.SULFARUS;

public class LegendaryProductQualityCalculator implements QualityCalculator {
    private static final int QUALITY_AMOUNT = 80;

    @Override
    public int calculateQualityWithinSellIn(final int currentQuality, final int sellIn) {
        return QUALITY_AMOUNT;
    }

    @Override
    public int calculateQualitySellInOvertime(final int currentQuality) {
        return QUALITY_AMOUNT;
    }

    @Override
    public boolean appliesTo(final String productName) {
        return SULFARUS.equals(ProductType.fromValue(productName));
    }
}