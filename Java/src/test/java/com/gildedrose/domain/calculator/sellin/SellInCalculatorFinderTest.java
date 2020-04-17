package com.gildedrose.domain.calculator.sellin;

import org.junit.jupiter.api.Test;

import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.assertj.core.api.Assertions.assertThat;

class SellInCalculatorFinderTest {
    private final SellInCalculatorFinder finder = new SellInCalculatorFinder();

    @Test
    void default_find_default_calculator() {
        assertThat(finder.find(random(50))).isInstanceOf(DefaultProductSellInCalculator.class);
    }

    @Test
    void legendary_find_legendary_calculator() {
        assertThat(finder.find("Sulfuras, Hand of Ragnaros")).isInstanceOf(LegendaryProductSellInCalculator.class);
    }
}