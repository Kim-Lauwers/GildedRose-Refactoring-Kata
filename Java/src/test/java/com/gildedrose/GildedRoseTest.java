package com.gildedrose;

import com.gildedrose.domain.Item;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

import static com.gildedrose.domain.ProductTestBuilder.emptyProduct;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(ReplaceUnderscores.class)
class GildedRoseTest {

    @Test
    void product_quality_decrease_with_one_when_selldate_is_not_overtime() {
        final Item[] items = new Item[] {new Item("+5 Dexterity Vest", 10, 20)};

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.products.get(0)).isEqualTo(emptyProduct().withName("+5 Dexterity Vest").withSellIn(9).withQuality(19).build());
    }

    @Test
    void product_quality_decrease_with_two_when_selldate_is_overtime() {
        final Item[] items = new Item[] {new Item("+5 Dexterity Vest", 0, 20)};

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.products.get(0)).isEqualTo(emptyProduct().withName("+5 Dexterity Vest").withSellIn(-1).withQuality(18).build());
    }

    @Test
    void product_quality_decrease_cannot_be_below_zero() {
        final Item[] items = new Item[] {new Item("+5 Dexterity Vest", 0, 0)};

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.products.get(0)).isEqualTo(emptyProduct().withName("+5 Dexterity Vest").withSellIn(-1).withQuality(0).build());
    }

    @Test
    void aged_brie_quality_increase_with_one_when_selldate_is_not_overtime() {
        final Item[] items = new Item[] {new Item("Aged Brie", 2, 0)};

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.products.get(0)).isEqualTo(emptyProduct().withName("Aged Brie").withSellIn(1).withQuality(1).build());
    }

    @Test
    void aged_brie_quality_increase_cannot_surpass_50() {
        final Item[] items = new Item[] {new Item("Aged Brie", 2, 50)};

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.products.get(0)).isEqualTo(emptyProduct().withName("Aged Brie").withSellIn(1).withQuality(50).build());
    }

    @Test
    void backstage_quality_increase_with_one_when_selldate_10_days_or_more() {
        final Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)};

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.products.get(0)).isEqualTo(emptyProduct().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(14).withQuality(21).build());
    }

    @Test
    void backstage_quality_increase_with_two_when_selldate_10_days_or_less() {
        final Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20)};

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.products.get(0)).isEqualTo(emptyProduct().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(9).withQuality(22).build());
    }

    @Test
    void backstage_quality_increase_with_three_when_selldate_5_days_or_less() {
        final Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20)};

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.products.get(0)).isEqualTo(emptyProduct().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(4).withQuality(23).build());
    }

    @Test
    void backstage_quality_drops_to_zero_after_concert() {
        final Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50)};

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.products.get(0)).isEqualTo(emptyProduct().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(-1).withQuality(0).build());
    }

    @Test
    void backstage_quality_increase_with_more_when_selldate_is_less_than_10_but_may_not_exceed_50() {
        final Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)};

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.products).containsExactly(emptyProduct().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(9).withQuality(50).build(),
                emptyProduct().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(4).withQuality(50).build());
    }

    @Test
    void sulfuras_quality_never_changes_and_has_no_sellin() {
        final Item[] items = new Item[] {new Item("Sulfuras, Hand of Ragnaros", 0, 80)};

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.products.get(0)).isEqualTo(emptyProduct().withName("Sulfuras, Hand of Ragnaros").withSellIn(0).withQuality(80).build());
    }

    @Test
    void sulfuras_quality_never_changes_and_has_no_sellin_negative_sellin_does_not_change() {
        final Item[] items = new Item[] {new Item("Sulfuras, Hand of Ragnaros", -1, 80)};

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.products.get(0)).isEqualTo(emptyProduct().withName("Sulfuras, Hand of Ragnaros").withSellIn(-1).withQuality(80).build());
    }

    @Test
    @Disabled("Is a bug in the original solution")
    void conjured_quality_decrease_with_two_when_selldate_is_not_overtime() {
        final Item[] items = new Item[] {new Item("Conjured Mana Cake", 3, 6)};

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.products.get(0)).isEqualTo(emptyProduct().withName("Conjured Mana Cake").withSellIn(2).withQuality(4).build());
    }
}