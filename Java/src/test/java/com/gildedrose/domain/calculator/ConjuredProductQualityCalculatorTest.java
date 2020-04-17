package com.gildedrose.domain.calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConjuredProductQualityCalculatorTest {
    final QualityCalculator qualityCalculator = new ConjuredProductQualityCalculator();

    @Test
    void apply_new_day_subtracts_2() {
        assertThat(qualityCalculator.calculateQualityWithinSellIn(49,0)).isEqualTo(47);
    }

    @Test
    void decrease_subtracts_2() {
        assertThat(qualityCalculator.calculateQualitySellInOvertime(49, 1)).isEqualTo(47);
    }

    @Test
    void decrease_subtracts_4() {
        assertThat(qualityCalculator.calculateQualitySellInOvertime(49, 2)).isEqualTo(45);
    }

    @Test
    void decrease_cannot_go_under_zero() {
        assertThat(qualityCalculator.calculateQualitySellInOvertime(1, 222)).isEqualTo(0);
    }

    @Test
    void applies_to_always_true() {
        assertThat(qualityCalculator.appliesTo("49")).isTrue();
        assertThat(qualityCalculator.appliesTo("0")).isTrue();
    }
}