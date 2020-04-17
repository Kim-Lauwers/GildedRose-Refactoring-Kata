package com.gildedrose;

import com.gildedrose.domain.Item;
import com.gildedrose.domain.Product;

import java.util.Arrays;
import java.util.List;

import static com.gildedrose.domain.Product.ProductBuilder.product;
import static java.util.stream.Collectors.toList;

class GildedRose {
    List<Product> products;

    public GildedRose(Item[] input) {
        products = Arrays.stream(input)
                .map(item -> product(item).build())
                .collect(toList());
    }

    public void updateQuality() {
        for (int i = 0; i < products.size(); i++) {
            final Product currentProduct = products.get(i);

            if (!currentProduct.getName().equals("Aged Brie")
                    && !currentProduct.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (!currentProduct.getName().equals("Sulfuras, Hand of Ragnaros")) {
                    currentProduct.decreaseQuality(1);
                }
            } else {
                currentProduct.increaseQuality();

                if (currentProduct.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (currentProduct.getSellIn() < 11) {
                        currentProduct.increaseQuality();
                    }

                    if (currentProduct.getSellIn() < 6) {
                        currentProduct.increaseQuality();
                    }
                }
            }

            if (!currentProduct.getName().equals("Sulfuras, Hand of Ragnaros")) {
                currentProduct.decreaseSellIn();
            }

            if (currentProduct.isSellInOvertime()) {
                if (!currentProduct.getName().equals("Aged Brie")) {
                    if (!currentProduct.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (!currentProduct.getName().equals("Sulfuras, Hand of Ragnaros")) {
                            currentProduct.decreaseQuality(1);
                        }
                    } else {
                        currentProduct.decreaseQuality(currentProduct.getQuality());
                    }
                } else {
                    currentProduct.increaseQuality();
                }
            }
        }
    }
}