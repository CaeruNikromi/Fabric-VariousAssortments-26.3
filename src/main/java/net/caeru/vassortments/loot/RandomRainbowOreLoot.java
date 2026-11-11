
package net.caeru.vassortments.loot;

import net.caeru.vassortments.block.ModBlocks;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.List;

public class RandomRainbowOreLoot {

    public static void register() {

        LootTableEvents.MODIFY_DROPS.register((lootTable, context, drops) -> {

            if (!lootTable.is(
                    ModBlocks.RANDOM_RAINBOW_ORE.getLootTable().orElseThrow()
            ) && !lootTable.is(
                    ModBlocks.END_RANDOM_RAINBOW_ORE.getLootTable().orElseThrow()
            ) && !lootTable.is(
                    ModBlocks.NETHER_RANDOM_RAINBOW_ORE.getLootTable().orElseThrow()
            ) && !lootTable.is(
                    ModBlocks.DEEPSLATE_RANDOM_RAINBOW_ORE.getLootTable().orElseThrow()
            )) {
                return;
            }

            List<Item> items = BuiltInRegistries.ITEM.stream()
                    .filter(item ->
                            item != Items.AIR &&
                            item != Items.COMMAND_BLOCK &&
                            item != Items.CHAIN_COMMAND_BLOCK &&
                            item != Items.REPEATING_COMMAND_BLOCK &&
                            item != Items.COMMAND_BLOCK_MINECART
                    )
                    .toList();

            if (!items.isEmpty()) {
                Item randomItem = items.get(
                        context.getRandom().nextInt(items.size())
                );

                drops.clear();
                drops.add(new ItemStack(randomItem));
            }
        });
    }
}
