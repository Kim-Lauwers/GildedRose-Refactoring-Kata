package com.gildedrose.domain.calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AgedBrieProductQualityCalculatorTest {
    final QualityCalculator qualityCalculator = new AgedBrieProductQualityCalculator();

    @Test
    void apply_new_day_add_1() {
        assertThat(qualityCalculator.calculateQualityWithinSellIn(49,0)).isEqualTo(50);
    }

    @Test
    void apply_new_day_max_50() {
        assertThat(qualityCalculator.calculateQualityWithinSellIn(50,0)).isEqualTo(50);
    }

    @Test
    void decrease_subtracts_1() {
        assertThat(qualityCalculator.decreaseQuality(49, 1)).isEqualTo(48);
    }

    @Test
    void decrease_subtracts_2() {
        assertThat(qualityCalculator.decreaseQuality(49, 2)).isEqualTo(47);
    }

    @Test
    void decrease_cannot_go_under_zero() {
        assertThat(qualityCalculator.decreaseQuality(1, 222)).isEqualTo(0);
    }


    @Test
    void applies_to_aged_brie_true() {
        assertThat(qualityCalculator.appliesTo("Aged Brie")).isTrue();
    }

    @Test
    void applies_to_other_than_sulfarus_false() {
        assertThat(qualityCalculator.appliesTo("Not Aged Brie")).isFalse();
    }
}