package com.gildedrose.domain;

import com.gildedrose.domain.calculator.quality.QualityCalculator;
import com.gildedrose.domain.calculator.sellin.SellInCalculator;
import com.google.common.testing.EqualsTester;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static com.gildedrose.domain.ProductTestBuilder.emptyProduct;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayNameGeneration(ReplaceUnderscores.class)
@ExtendWith(MockitoExtension.class)
class ProductTest {
    @Mock
    private QualityCalculator qualityCalculator;

    @Mock
    private SellInCalculator sellInCalculator;

    @Test
    void apply_new_day_within_sell_in() {
        final Product product = emptyProduct(qualityCalculator, sellInCalculator)
                .withName("Product")
                .withQuality(25)
                .withSellIn(10)
                .build();

        when(sellInCalculator.calculateSellIn(10)).thenReturn(15);
        when(qualityCalculator.calculateQualityWithinSellIn(25, 15)).thenReturn(35);

        product.applyNewDay();

        verify(sellInCalculator).calculateSellIn(10);
        verify(qualityCalculator).calculateQualityWithinSellIn(25, 15);

        assertThat(product).isEqualTo(emptyProduct().withName("Product")
                .withQuality(35)
                .withSellIn(15)
                .build());
    }

    @Test
    void apply_new_day_in_overtime() {
        final Product product = emptyProduct(qualityCalculator, sellInCalculator)
                .withName("Product")
                .withQuality(25)
                .withSellIn(0)
                .build();

        when(sellInCalculator.calculateSellIn(0)).thenReturn(0);
        when(qualityCalculator.calculateQualitySellInOvertime(25)).thenReturn(24);

        product.applyNewDay();

        verify(sellInCalculator).calculateSellIn(0);
        verify(qualityCalculator).calculateQualitySellInOvertime(25);

        assertThat(product).isEqualTo(emptyProduct().withName("Product")
                .withQuality(24)
                .withSellIn(0)
                .build());
    }

    @Test
    void item_EqualsTester() {
        new EqualsTester()
                .addEqualityGroup(emptyProduct().withName("+5 Dexterity Vest").withSellIn(10).withQuality(20).build())
                .addEqualityGroup(emptyProduct().withName("+5 Dexterity Vest").withSellIn(10).withQuality(19).build())
                .addEqualityGroup(emptyProduct().withName("+5 Dexterity Vest").withSellIn(9).withQuality(20).build())
                .addEqualityGroup(emptyProduct().withName("5 Dexterity Vest").withSellIn(10).withQuality(20).build())
                .testEquals();
    }
}
