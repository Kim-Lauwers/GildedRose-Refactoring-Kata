package com.gildedrose.domain.calculator.quality;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(ReplaceUnderscores.class)
class ConjuredProductQualityCalculatorTest {
    final QualityCalculator qualityCalculator = new ConjuredProductQualityCalculator();

    @Test
    void apply_new_day_subtracts_2() {
        assertThat(qualityCalculator.calculateQualityWithinSellIn(49, 0)).isEqualTo(47);
    }

    @Test
    void decrease_subtracts_2() {
        assertThat(qualityCalculator.calculateQualitySellInOvertime(49)).isEqualTo(45);
    }

    @Test
    void decrease_cannot_go_under_zero() {
        assertThat(qualityCalculator.calculateQualitySellInOvertime(0)).isEqualTo(0);
    }

    @Test
    void applies_to_always_true() {
        assertThat(qualityCalculator.appliesTo("49")).isTrue();
        assertThat(qualityCalculator.appliesTo("0")).isTrue();
    }
}