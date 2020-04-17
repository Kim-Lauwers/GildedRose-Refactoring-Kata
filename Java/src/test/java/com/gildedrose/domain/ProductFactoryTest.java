package com.gildedrose.domain;

import com.gildedrose.domain.calculator.DefaultProductQualityCalculator;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static com.gildedrose.domain.Product.ProductBuilder.product;
import static com.gildedrose.domain.ProductFactory.createProduct;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ProductFactoryTest {

    @Test
    void create_product() {
        final Item sourceItem = new Item("name", 10, 99);

        final Product product = createProduct(sourceItem);

        assertThat(product).isEqualTo(product(sourceItem, new DefaultProductQualityCalculator()).build());
    }
}