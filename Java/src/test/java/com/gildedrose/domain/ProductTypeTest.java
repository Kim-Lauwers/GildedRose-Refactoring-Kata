package com.gildedrose.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

import static com.gildedrose.domain.ProductType.AGED_BRIE;
import static com.gildedrose.domain.ProductType.BACKSTAGE_PASS;
import static com.gildedrose.domain.ProductType.CONJURED;
import static com.gildedrose.domain.ProductType.DEFAULT;
import static com.gildedrose.domain.ProductType.SULFARUS;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(ReplaceUnderscores.class)
class ProductTypeTest {

    @Test
    void from_value_aged_brie() {
        assertThat(ProductType.fromValue("Aged Brie")).isEqualTo(AGED_BRIE);
    }

    @Test
    void from_value_backstage_pass() {
        assertThat(ProductType.fromValue("Backstage passes to a TAFKAL80ETC concert")).isEqualTo(BACKSTAGE_PASS);
    }

    @Test
    void from_value_conjured() {
        assertThat(ProductType.fromValue("Conjured Mana Cake")).isEqualTo(CONJURED);
    }

    @Test
    void from_value_sulfarus() {
        assertThat(ProductType.fromValue("Sulfuras, Hand of Ragnaros")).isEqualTo(SULFARUS);
    }

    @Test
    void from_value_default() {
        assertThat(ProductType.fromValue("def")).isEqualTo(DEFAULT);
        assertThat(ProductType.fromValue("")).isEqualTo(DEFAULT);
        assertThat(ProductType.fromValue("BLAAT")).isEqualTo(DEFAULT);
    }
}