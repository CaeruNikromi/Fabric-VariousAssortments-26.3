package net.caeru.vassortments.food;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;

public class ModFoods {
    public static final FoodProperties DIAMOND_BEETROOT = new FoodProperties.Builder().nutrition(8).saturationModifier(1.4F).build();

    public static final Consumable DIAMOND_BEETROOT_CONSUMABLE = Consumables.defaultFood()
            .consumeSeconds(1.6f).build();
}
