package com.gildedrose.domain.calculator.quality;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(ReplaceUnderscores.class)
class LegendaryProductQualityCalculatorTest {
    final QualityCalculator qualityCalculator = new LegendaryProductQualityCalculator();


    @Test
    void apply_end_of_day_always_returns_80() {
        assertThat(qualityCalculator.calculateQualityWithinSellIn(0, 0)).isEqualTo(80);
    }

    @Test
    void decrease_always_returns_80() {
        assertThat(qualityCalculator.calculateQualitySellInOvertime(0)).isEqualTo(80);
    }

    @Test
    void applies_to_sulfarus_true() {
        assertThat(qualityCalculator.appliesTo("Sulfuras, Hand of Ragnaros")).isTrue();
    }

    @Test
    void applies_to_other_than_sulfarus_false() {
        assertThat(qualityCalculator.appliesTo("Not Sulfuras, Hand of Ragnaros")).isFalse();
    }
}