package com.gildedrose.domain.calculator.sellin;

public class DefaultProductSellInCalculator implements SellInCalculator {
    private static final int SELL_IN_DECREASE_AMOUNT = 1;

    @Override
    public int calculateSellIn(final int currentSellIn) {
        return currentSellIn - SELL_IN_DECREASE_AMOUNT;
    }

    @Override
    public boolean appliesTo(final String productName) {
        return true;
    }
}