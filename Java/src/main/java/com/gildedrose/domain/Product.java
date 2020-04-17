package com.gildedrose.domain;

import com.gildedrose.domain.calculator.QualityCalculator;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

public class Product {
    private static final int SELL_IN_DECREASE_AMOUNT = 1;

    private QualityCalculator qualityCalculator;

    private String name;

    private int sellIn;

    private int quality;

    private Product(final QualityCalculator qualityCalculator) {
        this.qualityCalculator = qualityCalculator;
    }

    public String getName() {
        return name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public boolean isSellInOvertime() {
        return sellIn < 0;
    }

    public void decreaseQuality(final int amountToDecreaseWith) {
        this.quality = qualityCalculator.decreaseQuality(this.quality, amountToDecreaseWith);
    }

    public void decreaseQuality() {
        decreaseQuality(1);
    }

    public void applyNewDay() {
        if (this.isSellInOvertime()) {
            this.quality = qualityCalculator.decreaseQuality(this.quality, 1);
        } else {
            this.sellIn -= SELL_IN_DECREASE_AMOUNT;
            this.quality = qualityCalculator.calculateQualityWithinSellIn(this.quality, this.sellIn);
        }
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        final Product product = (Product) obj;

        return new EqualsBuilder()
                .append(getName(), product.name)
                .append(getSellIn(), product.sellIn)
                .append(getQuality(), product.quality)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getName()).append(getSellIn()).append(getQuality()).toHashCode();
    }

    @Override
    public String toString() {
        return reflectionToString(this, SHORT_PREFIX_STYLE);
    }

    public static final class ProductBuilder {
        private Product product;

        private ProductBuilder(final QualityCalculator qualityCalculator) {
            this.product = new Product(qualityCalculator);
        }

        public static ProductBuilder product(final QualityCalculator qualityCalculator) {
            return new ProductBuilder(qualityCalculator);
        }

        public static ProductBuilder product(final Item item, final QualityCalculator qualityCalculator) {
            return product(qualityCalculator)
                    .withName(item.name)
                    .withQuality(item.quality)
                    .withSellIn(item.sellIn);
        }

        public ProductBuilder withName(final String name) {
            this.product.name = name;
            return this;
        }

        public ProductBuilder withQuality(final int quality) {
            this.product.quality = quality;
            return this;
        }

        public ProductBuilder withSellIn(final int sellIn) {
            this.product.sellIn = sellIn;
            return this;
        }

        public Product build() {
            return product;
        }
    }
}