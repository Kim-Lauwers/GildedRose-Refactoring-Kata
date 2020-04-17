package com.gildedrose;

import com.gildedrose.domain.Item;
import com.gildedrose.domain.Product;
import com.gildedrose.domain.ProductFactory;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

class GildedRose {
    List<Product> products;

    public GildedRose(final Item[] input) {
        products = stream(input)
                .map(ProductFactory::createProduct)
                .collect(toList());
    }

    public void updateQuality() {
        products.forEach(Product::applyNewDay);
    }
}