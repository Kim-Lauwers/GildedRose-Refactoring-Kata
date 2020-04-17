package com.gildedrose.domain;

import com.gildedrose.domain.calculator.quality.QualityCalculator;
import com.gildedrose.domain.calculator.quality.QualityCalculatorFinder;
import com.gildedrose.domain.calculator.sellin.SellInCalculator;
import com.gildedrose.domain.calculator.sellin.SellInCalculatorFinder;

import static com.gildedrose.domain.Product.ProductBuilder.product;

public class ProductFactory {

    private static QualityCalculatorFinder qualityCalculatorFinder = new QualityCalculatorFinder();
    private static SellInCalculatorFinder sellInCalculatorFinder = new SellInCalculatorFinder();

    public static Product createProduct(final Item item) {
        final String itemName = item.name;
        final QualityCalculator qualityCalculator = qualityCalculatorFinder.find(itemName);
        final SellInCalculator sellInCalculator = sellInCalculatorFinder.find(itemName);
        return product(item, qualityCalculator, sellInCalculator).build();
    }
}