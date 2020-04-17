package com.gildedrose.domain.calculator.sellin;

public class LegendaryProductSellInCalculator implements SellInCalculator {
    @Override
    public int calculateSellIn(final int currentSellIn) {
        return currentSellIn;
    }

    @Override
    public boolean appliesTo(final String productName) {
        return "Sulfuras, Hand of Ragnaros".equals(productName);
    }
}