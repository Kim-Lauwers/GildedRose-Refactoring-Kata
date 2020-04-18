package com.gildedrose.domain.calculator.sellin;

import com.gildedrose.domain.ProductType;

import static com.gildedrose.domain.ProductType.SULFARUS;

public class LegendaryProductSellInCalculator implements SellInCalculator {
    @Override
    public int calculateSellIn(final int currentSellIn) {
        return currentSellIn;
    }

    @Override
    public boolean appliesTo(final String productName) {
        return SULFARUS.equals(ProductType.fromValue(productName));
    }
}