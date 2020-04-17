package com.gildedrose;

import com.google.common.testing.EqualsTester;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

import static com.gildedrose.ProductTestBuilder.emptyProduct;

@DisplayNameGeneration(ReplaceUnderscores.class)
class ProductTest {

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
