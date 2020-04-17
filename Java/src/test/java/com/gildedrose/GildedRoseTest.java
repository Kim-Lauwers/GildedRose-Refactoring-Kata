package com.gildedrose;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(ReplaceUnderscores.class)
class GildedRoseTest {

    @Test
    void product_quality_decrease_with_one_when_selldate_is_not_overtime() {
        final Item[] items = new Item[] {new Item("+5 Dexterity Vest", 10, 20)};

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0]).isEqualTo(new Item("+5 Dexterity Vest", 9, 19));
    }

    @Test
    void aged_brie_quality_increase_with_one_when_selldate_is_not_overtime() {
        final Item[] items = new Item[] {new Item("Aged Brie", 2, 0)};

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0]).isEqualTo(new Item("Aged Brie", 1, 1));
    }

    @Test
    void backstage_quality_increase_with_one_when_selldate_10_days_or_more() {
        final Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)};

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0]).isEqualTo(new Item("Backstage passes to a TAFKAL80ETC concert", 14, 21));
    }

    @Test
    void backstage_quality_increase_with_more_when_selldate_is_less_than_10_but_may_not_exceed_50() {
        final Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)};

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0]).isEqualTo(new Item("Backstage passes to a TAFKAL80ETC concert", 9, 50));
        assertThat(app.items[1]).isEqualTo(new Item("Backstage passes to a TAFKAL80ETC concert", 4, 50));
    }

    @Test
    void sulfuras_quality_never_changes_and_has_no_sellin() {
        final Item[] items = new Item[] {new Item("Sulfuras, Hand of Ragnaros", 0, 80)};

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0]).isEqualTo(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
    }

    @Test
    void sulfuras_quality_never_changes_and_has_no_sellin_negative_sellin_does_not_change() {
        final Item[] items = new Item[] {new Item("Sulfuras, Hand of Ragnaros", -1, 80)};

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0]).isEqualTo(new Item("Sulfuras, Hand of Ragnaros", -1, 80));
    }

    @Test
    @Disabled("Is a bug in the original solution")
    void conjured_quality_decrease_with_two_when_selldate_is_not_overtime() {
        final Item[] items = new Item[] {new Item("Conjured Mana Cake", 3, 6)};

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0]).isEqualTo(new Item("Conjured Mana Cake", 2, 4));
    }
}