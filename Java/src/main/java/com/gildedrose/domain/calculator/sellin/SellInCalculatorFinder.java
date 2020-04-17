package com.gildedrose.domain.calculator.sellin;

import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;

public class SellInCalculatorFinder {
    private final Map<String, SellInCalculator> qualityCalculatorMap;

    public SellInCalculatorFinder() {
        qualityCalculatorMap = newHashMap();
        qualityCalculatorMap.put("Sulfuras, Hand of Ragnaros", new LegendaryProductSellInCalculator());
    }

    public SellInCalculator find(final String productName) {
        return qualityCalculatorMap.entrySet().stream()
                .filter(e -> e.getKey().equals(productName))
                .map(Map.Entry::getValue)
                .findFirst().orElse(new DefaultProductSellInCalculator());
    }
}