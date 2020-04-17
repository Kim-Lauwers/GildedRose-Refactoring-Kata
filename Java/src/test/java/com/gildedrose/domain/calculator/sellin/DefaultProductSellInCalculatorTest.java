package com.gildedrose.domain.calculator.sellin;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(ReplaceUnderscores.class)
class DefaultProductSellInCalculatorTest {
    final SellInCalculator sellInCalculator = new DefaultProductSellInCalculator();

    @Test
    void calculate_sell_in_minus_one() {
        assertThat(sellInCalculator.calculateSellIn(123)).isEqualTo(122);
    }

    @Test
    void applies_to_always_true() {
        assertThat(sellInCalculator.appliesTo("BLAAT")).isTrue();
    }
}