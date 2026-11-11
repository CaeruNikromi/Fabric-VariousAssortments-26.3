package net.caeru.vassortments.datagen;

import net.caeru.vassortments.block.ModBlocks;
import net.caeru.vassortments.item.ModArmorMaterials;
import net.caeru.vassortments.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;

import java.util.Map;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createTrivialCube(ModBlocks.BLOCK_OF_CHARCOAL);
        blockModelGenerators.createTrivialCube(ModBlocks.BLOCK_OF_NETHER_RUBY);
        blockModelGenerators.createTrivialCube(ModBlocks.DEEPSLATE_EXPERIENCE_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.DEEPSLATE_RANDOM_RAINBOW_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.END_EXPERIENCE_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.END_RANDOM_RAINBOW_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.EXPERIENCE_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.NETHER_COPPER_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.NETHER_DIAMOND_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.NETHER_EXPERIENCE_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.NETHER_IRON_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.NETHER_RANDOM_RAINBOW_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.NETHER_RUBY_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.RANDOM_RAINBOW_ORE);

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.DIAMOND_BEETROOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.DIAMOND_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.NAUGHTY_STICK, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.NETHER_RUBY, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.NETHER_RUBY_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.NETHER_RUBY_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.NETHER_RUBY_HORSE_ARMOR, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.NETHER_RUBY_NAUTILUS_ARMOR, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.NETHER_RUBY_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.NETHER_RUBY_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateSpear(ModItems.NETHER_RUBY_SPEAR);
        itemModelGenerators.generateFlatItem(ModItems.NETHER_RUBY_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RANDOM_RAINBOW_GEM, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SPRITE_LOCATOR, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateTrimmableArmorSet(ModItems.NETHER_RUBY_HELMET, ModItems.NETHER_RUBY_CHESTPLATE, ModItems.NETHER_RUBY_LEGGINGS, ModItems.NETHER_RUBY_BOOTS, false, Map.of());

    }
}
