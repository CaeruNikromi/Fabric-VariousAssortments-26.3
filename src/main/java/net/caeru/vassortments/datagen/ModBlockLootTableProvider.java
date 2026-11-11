package net.caeru.vassortments.datagen;

import net.caeru.vassortments.block.ModBlocks;
import net.caeru.vassortments.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootSubProvider {
    public ModBlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {

        dropSelf(ModBlocks.BLOCK_OF_CHARCOAL);
        dropSelf(ModBlocks.BLOCK_OF_NETHER_RUBY);
        dropSelf(ModBlocks.DEEPSLATE_RANDOM_RAINBOW_ORE);
        dropSelf(ModBlocks.END_RANDOM_RAINBOW_ORE);
        dropSelf(ModBlocks.NETHER_RANDOM_RAINBOW_ORE);
        dropSelf(ModBlocks.RANDOM_RAINBOW_ORE);

        dropWhenSilkTouch(ModBlocks.DEEPSLATE_EXPERIENCE_ORE);
        dropWhenSilkTouch(ModBlocks.END_EXPERIENCE_ORE);
        dropWhenSilkTouch(ModBlocks.EXPERIENCE_ORE);
        dropWhenSilkTouch(ModBlocks.NETHER_EXPERIENCE_ORE);

        add(ModBlocks.NETHER_RUBY_ORE, createOreDrop(ModBlocks.NETHER_RUBY_ORE, ModItems.NETHER_RUBY));

        add(ModBlocks.NETHER_COPPER_ORE, createMultipleOreDrops(ModBlocks.NETHER_COPPER_ORE, Items.COPPER_NUGGET, 3, 7));
        add(ModBlocks.NETHER_DIAMOND_ORE, createMultipleOreDrops(ModBlocks.NETHER_COPPER_ORE, ModItems.DIAMOND_NUGGET, 2, 5));
        add(ModBlocks.NETHER_IRON_ORE, createMultipleOreDrops(ModBlocks.NETHER_IRON_ORE, Items.IRON_NUGGET, 2, 6));

    }

    public LootTable.Builder createMultipleOreDrops(final Block block, Item item, int minDrops, int maxDrops) {
        return this.createSilkTouchDispatchTable(block, this.applyExplosionDecay(
                block, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE)))));
    }
}
