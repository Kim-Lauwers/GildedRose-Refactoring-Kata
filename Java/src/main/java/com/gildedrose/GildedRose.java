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
            if (!products.get(i).getName().equals("Aged Brie")
                    && !products.get(i).getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (products.get(i).getQuality() > 0) {
                    if (!products.get(i).getName().equals("Sulfuras, Hand of Ragnaros")) {
                        products.get(i).decreaseQuality(1);
                    }
                }
            } else {
                if (products.get(i).getQuality() < 50) {
                    products.get(i).increaseQuality(1);

                    if (products.get(i).getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (products.get(i).getSellIn() < 11) {
                            if (products.get(i).getQuality() < 50) {
                                products.get(i).increaseQuality(1);
                            }
                        }

                        if (products.get(i).getSellIn() < 6) {
                            if (products.get(i).getQuality() < 50) {
                                products.get(i).increaseQuality(1);
                            }
                        }
                    }
                }
            }

            if (!products.get(i).getName().equals("Sulfuras, Hand of Ragnaros")) {
                products.get(i).setSellIn(products.get(i).getSellIn() - 1);
            }

            if (products.get(i).getSellIn() < 0) {
                if (!products.get(i).getName().equals("Aged Brie")) {
                    if (!products.get(i).getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (products.get(i).getQuality() > 0) {
                            if (!products.get(i).getName().equals("Sulfuras, Hand of Ragnaros")) {
                                products.get(i).decreaseQuality(1);
                            }
                        }
                    } else {
                        products.get(i).decreaseQuality(products.get(i).getQuality());
                    }
                } else {
                    if (products.get(i).getQuality() < 50) {
                        products.get(i).increaseQuality(1);
                    }
                }
            }
        }
    }
}