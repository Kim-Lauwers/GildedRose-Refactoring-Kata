package com.gildedrose.domain;

import static java.util.Arrays.stream;
import static org.apache.commons.lang3.StringUtils.EMPTY;

public enum ProductType {
    AGED_BRIE("Aged Brie"),
    BACKSTAGE_PASS("Backstage passes to a TAFKAL80ETC concert"),
    CONJURED("Conjured Mana Cake"),
    SULFARUS("Sulfuras, Hand of Ragnaros"),
    DEFAULT(EMPTY);

    private final String productName;

    ProductType(final String productName) {
        this.productName = productName;
    }

    public static ProductType fromValue(final String productName) {
        return stream(values()).filter(enumValue -> enumValue.productName.equals(productName))
                .findFirst()
                .orElse(DEFAULT);
    }
}