package com.gildedrose.domain.calculator.sellin;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LegendaryProductSellInCalculatorTest {
    final SellInCalculator sellInCalculator = new LegendaryProductSellInCalculator();


    @Test
    void calculate_sell_in_returns_input() {
        assertThat(sellInCalculator.calculateSellIn(123)).isEqualTo(123);
    }

    @Test
    void applies_to_sulfarus_true() {
        assertThat(sellInCalculator.appliesTo("Sulfuras, Hand of Ragnaros")).isTrue();
    }

    @Test
    void applies_to_other_than_sulfarus_false() {
        assertThat(sellInCalculator.appliesTo("Not Sulfuras, Hand of Ragnaros")).isFalse();
    }
}