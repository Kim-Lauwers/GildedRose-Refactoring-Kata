package com.gildedrose.domain.calculator.quality;

import com.gildedrose.domain.ProductType;

import static com.gildedrose.domain.ProductType.BACKSTAGE_PASS;
import static java.lang.Math.min;

public class BackstagePassProductQualityCalculator implements QualityCalculator {
    private static final int MAXIMUM_QUALITY = 50;
    private static final int MINIMUM_QUALITY = 0;
    private static final int QUALITY_INCREASE_AMOUNT = 1;

    @Override
    public int calculateQualityWithinSellIn(final int currentQuality, final int sellIn) {
        int newQuality = currentQuality;
        newQuality = increaseQuality(newQuality);
        newQuality = addExtraQualityWhenSellInWithIn10Days(sellIn, newQuality);
        newQuality = addExtraQualityWhenSellInWithIn5Days(sellIn, newQuality);
        return min(MAXIMUM_QUALITY, newQuality);
    }

    private int addExtraQualityWhenSellInWithIn10Days(final int sellIn, int newQuality) {
        return sellIn < 11 ? increaseQuality(newQuality) : newQuality;
    }

    private int addExtraQualityWhenSellInWithIn5Days(final int sellIn, int newQuality) {
        return sellIn < 6 ? increaseQuality(newQuality) : newQuality;
    }

    private int increaseQuality(int quality) {
        return quality + QUALITY_INCREASE_AMOUNT;
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