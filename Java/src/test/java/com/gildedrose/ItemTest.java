package com.gildedrose;

import com.google.common.testing.EqualsTester;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
class ItemTest {

    @Test
    void item_EqualsTester() {
        new EqualsTester()
                .addEqualityGroup(new Item("+5 Dexterity Vest", 10, 20))
                .addEqualityGroup(new Item("+5 Dexterity Vest", 10, 19))
                .addEqualityGroup(new Item("+5 Dexterity Vest", 9, 20))
                .addEqualityGroup(new Item("5 Dexterity Vest", 10, 20))
                .testEquals();
    }
}
