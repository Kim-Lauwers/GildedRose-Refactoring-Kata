package com.gildedrose.domain;

import com.gildedrose.domain.calculator.QualityCalculatorFinder;

import static com.gildedrose.domain.Product.ProductBuilder.product;

public class ProductFactory {

    private static QualityCalculatorFinder qualityCalculatorFinder = new QualityCalculatorFinder();

    public static Product createProduct(final Item item) {
        return product(item, qualityCalculatorFinder.find(item.name)).build();
    }
}