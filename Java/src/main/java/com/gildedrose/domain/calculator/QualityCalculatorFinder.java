package com.gildedrose.domain.calculator;

import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;

public class QualityCalculatorFinder {
    private final Map<String, QualityCalculator> qualityCalculatorMap;

    public QualityCalculatorFinder() {
        qualityCalculatorMap = newHashMap();
        qualityCalculatorMap.put("Sulfuras, Hand of Ragnaros", new LegendaryProductQualityCalculator());
        qualityCalculatorMap.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassProductQualityCalculator());
        qualityCalculatorMap.put("Aged Brie", new AgedBrieProductQualityCalculator());
    }

    public QualityCalculator find(final String productName) {
        return qualityCalculatorMap.entrySet().stream()
                .filter(e -> e.getKey().equals(productName))
                .map(Map.Entry::getValue)
                .findFirst().orElse(new DefaultProductQualityCalculator());
    }
}
