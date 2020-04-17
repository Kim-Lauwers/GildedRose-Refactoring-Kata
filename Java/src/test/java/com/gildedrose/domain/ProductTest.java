package com.gildedrose.domain;

import com.google.common.testing.EqualsTester;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

import static com.gildedrose.domain.ProductTestBuilder.defaultProduct;
import static com.gildedrose.domain.ProductTestBuilder.emptyProduct;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(ReplaceUnderscores.class)
class ProductTest {

    @Test
    void test_sellIn_overtime_true() {
        final Product product = defaultProduct().withSellIn(-1).build();

        assertThat(product.isSellInOvertime()).isTrue();
    }

    @Test
    void test_sellIn_overtime_false() {
        final Product product = defaultProduct().withSellIn(0).build();

        assertThat(product.isSellInOvertime()).isFalse();
    }

    @Test
    void test_decrease_sellIn() {
        final Product product = defaultProduct().withSellIn(100).build();

        product.decreaseSellIn();

        assertThat(product.getSellIn()).isEqualTo(99);
    }

    @Test
    void test_decrease_quality_cannot_go_below_zero() {
        final Product product = defaultProduct().withQuality(0).build();

        product.decreaseQuality(1);

        assertThat(product.getQuality()).isEqualTo(0);
    }

    @Test
    void test_decrease_quality() {
        final Product product = defaultProduct().withQuality(10).build();

        product.decreaseQuality(1);

        assertThat(product.getQuality()).isEqualTo(9);
    }

    @Test
    void item_EqualsTester() {
        new EqualsTester()
                .addEqualityGroup(emptyProduct().withName("+5 Dexterity Vest").withSellIn(10).withQuality(20).build())
                .addEqualityGroup(emptyProduct().withName("+5 Dexterity Vest").withSellIn(10).withQuality(19).build())
                .addEqualityGroup(emptyProduct().withName("+5 Dexterity Vest").withSellIn(9).withQuality(20).build())
                .addEqualityGroup(emptyProduct().withName("5 Dexterity Vest").withSellIn(10).withQuality(20).build())
                .testEquals();
    }
}
