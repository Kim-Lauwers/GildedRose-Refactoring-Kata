package com.gildedrose.domain.calculator.quality;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class QualityCalculatorFinder {
    private final List<QualityCalculator> qualityCalculatorList = newArrayList(new LegendaryProductQualityCalculator(),
            new BackstagePassProductQualityCalculator(),
            new AgedBrieProductQualityCalculator(),
            new ConjuredProductQualityCalculator());

    public QualityCalculator find(final String productName) {
        return qualityCalculatorList.stream()
                .filter(calculator -> calculator.appliesTo(productName))
                .findFirst().orElse(new DefaultProductQualityCalculator());
    }
}