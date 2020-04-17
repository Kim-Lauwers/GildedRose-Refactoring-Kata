package com.gildedrose;

import com.gildedrose.domain.Item;
import com.gildedrose.domain.Product;

import java.util.Arrays;
import java.util.List;

import static com.gildedrose.domain.ProductFactory.createProduct;
import static java.util.stream.Collectors.toList;

class GildedRose {
    List<Product> products;

    public GildedRose(Item[] input) {
        products = Arrays.stream(input)
                .map(item -> createProduct(item))
                .collect(toList());
    }

    public void updateQuality() {
        for (final Product currentProduct : products) {
            if (!currentProduct.getName().equals("Sulfuras, Hand of Ragnaros")) {
                currentProduct.applyNewDay();
                currentProduct.decreaseSellIn();
            }

            if (currentProduct.isSellInOvertime()) {
                if (!currentProduct.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (!currentProduct.getName().equals("Sulfuras, Hand of Ragnaros")) {
                        currentProduct.applyNewDay();
                    }
                } else {
                    currentProduct.decreaseQuality(currentProduct.getQuality());
                }
            }
        }
    }
}