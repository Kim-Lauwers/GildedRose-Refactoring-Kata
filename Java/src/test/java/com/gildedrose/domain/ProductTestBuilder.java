package com.gildedrose.domain;

import com.gildedrose.domain.Product.ProductBuilder;

import static com.gildedrose.domain.Product.ProductBuilder.product;
import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.apache.commons.lang3.RandomUtils.nextInt;

public class ProductTestBuilder {

    private ProductBuilder productBuilder;

    public static ProductTestBuilder emptyProduct() {
        return new ProductTestBuilder();
    }

    public static ProductTestBuilder defaultProduct() {
        return emptyProduct()
                .withName(random(20))
                .withQuality(nextInt(0, 50))
                .withSellIn(nextInt());
    }

    private ProductTestBuilder() {
        this.productBuilder = product();
    }

    public ProductTestBuilder withName(final String name) {
        this.productBuilder.withName(name);
        return this;
    }

    public ProductTestBuilder withQuality(final int quality) {
        this.productBuilder.withQuality(quality);
        return this;
    }

    public ProductTestBuilder withSellIn(final int sellIn) {
        this.productBuilder.withSellIn(sellIn);
        return this;
    }

    public Product build() {
        return productBuilder.build();
    }
}