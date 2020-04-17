package com.gildedrose.domain.calculator;

import org.junit.jupiter.api.Test;

import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.assertj.core.api.Assertions.assertThat;

class QualityCalculatorFinderTest {
    private final QualityCalculatorFinder finder = new QualityCalculatorFinder();

    @Test
    void default_find_default_calculator() {
        assertThat(finder.find(random(50))).isInstanceOf(DefaultProductQualityCalculator.class);
    }

    @Test
    void legendary_find_legendary_calculator() {
        assertThat(finder.find("Sulfuras, Hand of Ragnaros")).isInstanceOf(LegendaryProductQualityCalculator.class);
    }

    @Test
    void backstage_find_backstage_calculator() {
        assertThat(finder.find("Backstage passes to a TAFKAL80ETC concert")).isInstanceOf(BackstagePassProductQualityCalculator.class);
    }

    @Test
    void aged_brie_find_aged_brie_calculator() {
        assertThat(finder.find("Aged Brie")).isInstanceOf(AgedBrieProductQualityCalculator.class);
    }
}