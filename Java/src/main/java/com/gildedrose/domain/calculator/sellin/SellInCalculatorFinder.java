package com.gildedrose.domain.calculator.sellin;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class SellInCalculatorFinder {
    private final List<SellInCalculator> qualityCalculatorList = newArrayList(
            new LegendaryProductSellInCalculator());


    public SellInCalculator find(final String productName) {
        return qualityCalculatorList.stream()
                .filter(calculator -> calculator.appliesTo(productName))
                .findFirst()
                .orElse(new DefaultProductSellInCalculator());
    }
}