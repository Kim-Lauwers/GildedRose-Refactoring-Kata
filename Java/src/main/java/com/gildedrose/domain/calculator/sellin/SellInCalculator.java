package com.gildedrose.domain.calculator.sellin;

public interface SellInCalculator {
    int calculateSellIn(final int currentSellIn);

    boolean appliesTo(final String productName);
}
