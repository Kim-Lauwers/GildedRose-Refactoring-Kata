package com.gildedrose.domain.calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BackstagePassProductQualityCalculatorTest {
    final QualityCalculator qualityCalculator = new BackstagePassProductQualityCalculator();

    @Test
    void apply_new_day_add_1() {
        assertThat(qualityCalculator.applyNewDay(49,11)).isEqualTo(50);
    }

    @Test
    void apply_new_day_sellin_less_than_11_add_2() {
        assertThat(qualityCalculator.applyNewDay(5,10)).isEqualTo(7);
    }

    @Test
    void apply_new_day_sellin_less_than_6_add_2() {
        assertThat(qualityCalculator.applyNewDay(5,5)).isEqualTo(8);
    }

    @Test
    void apply_new_day_sellin_passed_no_value() {
        assertThat(qualityCalculator.applyNewDay(5,0)).isEqualTo(0);
    }

    @Test
    void apply_new_day_max_50() {
        assertThat(qualityCalculator.applyNewDay(50,1)).isEqualTo(50);
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
    void applies_to_pass_true() {
        assertThat(qualityCalculator.appliesTo("Backstage passes to a TAFKAL80ETC concert")).isTrue();
    }

    @Test
    void applies_to_other_than_pass_false() {
        assertThat(qualityCalculator.appliesTo("Not Backstage passes to a TAFKAL80ETC concert")).isFalse();
    }
}