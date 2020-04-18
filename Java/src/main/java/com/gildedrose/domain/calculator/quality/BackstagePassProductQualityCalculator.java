package com.gildedrose.domain.calculator.quality;

import com.gildedrose.domain.ProductType;

import static com.gildedrose.domain.ProductType.BACKSTAGE_PASS;
import static java.lang.Math.min;

public class BackstagePassProductQualityCalculator implements QualityCalculator {
    private static final int MAXIMUM_QUALITY = 50;
    private static final int MINIMUM_QUALITY = 0;

    @Override
    public int calculateQualityWithinSellIn(final int currentQuality, final int sellIn) {
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
    public int calculateQualitySellInOvertime(final int currentQuality) {
        return MINIMUM_QUALITY;
    }

    @Override
    public boolean appliesTo(final String productName) {
        return BACKSTAGE_PASS.equals(ProductType.fromValue(productName));
    }
}