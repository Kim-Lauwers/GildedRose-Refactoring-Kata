package com.gildedrose.domain.calculator;

public class LegendaryProductQualityCalculator implements QualityCalculator {
    private static final int QUALITY_AMOUNT = 80;

    @Override
    public int applyNewDay(final int currentQuality, final int sellIn) {
        return QUALITY_AMOUNT;
    }

    @Override
    public int decreaseQuality(final int currentQuality, final int amountToDecreaseWith) {
        return QUALITY_AMOUNT;
    }

    @Override
    public boolean appliesTo(final String productName) {
        return "Sulfuras, Hand of Ragnaros".equals(productName);
    }
}