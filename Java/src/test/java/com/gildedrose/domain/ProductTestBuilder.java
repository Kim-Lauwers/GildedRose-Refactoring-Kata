package com.gildedrose.domain;

import com.gildedrose.domain.Product.ProductBuilder;
import com.gildedrose.domain.calculator.quality.DefaultProductQualityCalculator;
import com.gildedrose.domain.calculator.quality.QualityCalculator;
import com.gildedrose.domain.calculator.sellin.DefaultProductSellInCalculator;
import com.gildedrose.domain.calculator.sellin.SellInCalculator;

import static com.gildedrose.domain.Product.ProductBuilder.product;
import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.apache.commons.lang3.RandomUtils.nextInt;

public class ProductTestBuilder {

    private ProductBuilder productBuilder;

    public static ProductTestBuilder emptyProduct() {
        return new ProductTestBuilder();
    }

    public static ProductTestBuilder emptyProduct(
            final QualityCalculator qualityCalculator,
            final SellInCalculator sellInCalculator) {
        return new ProductTestBuilder(qualityCalculator, sellInCalculator);
    }

    static ProductTestBuilder defaultProduct() {
        return emptyProduct()
                .withName(random(20))
                .withQuality(nextInt(0, 50))
                .withSellIn(nextInt());
    }

    private ProductTestBuilder() {
        this.productBuilder = product(new DefaultProductQualityCalculator(), new DefaultProductSellInCalculator());
    }

    private ProductTestBuilder(final QualityCalculator qualityCalculator,
                               final SellInCalculator sellInCalculator) {
        this.productBuilder = product(qualityCalculator, sellInCalculator);
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