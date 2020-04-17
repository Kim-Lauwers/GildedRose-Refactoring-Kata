package com.gildedrose;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(ReplaceUnderscores.class)
class GildedRoseTest {

    @Test
    void product_quality_decrease_with_one_selldate_not_overtime() {
        final Item[] items = new Item[] {new Item("+5 Dexterity Vest", 10, 20)};

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0]).isEqualTo(new Item("+5 Dexterity Vest", 9, 19));
    }
}