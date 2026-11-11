package net.caeru.vassortments.datagen;

import net.caeru.vassortments.block.ModBlocks;
import net.caeru.vassortments.tags.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {
    public ModBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.BLOCK_OF_CHARCOAL.builtInRegistryHolder().key())
                .add(ModBlocks.BLOCK_OF_NETHER_RUBY.builtInRegistryHolder().key())
                .add(ModBlocks.DEEPSLATE_RANDOM_RAINBOW_ORE.builtInRegistryHolder().key())
                .add(ModBlocks.DEEPSLATE_EXPERIENCE_ORE.builtInRegistryHolder().key())
                .add(ModBlocks.END_EXPERIENCE_ORE.builtInRegistryHolder().key())
                .add(ModBlocks.END_RANDOM_RAINBOW_ORE.builtInRegistryHolder().key())
                .add(ModBlocks.EXPERIENCE_ORE.builtInRegistryHolder().key())
                .add(ModBlocks.NETHER_COPPER_ORE.builtInRegistryHolder().key())
                .add(ModBlocks.NETHER_DIAMOND_ORE.builtInRegistryHolder().key())
                .add(ModBlocks.NETHER_EXPERIENCE_ORE.builtInRegistryHolder().key())
                .add(ModBlocks.NETHER_IRON_ORE.builtInRegistryHolder().key())
                .add(ModBlocks.NETHER_RANDOM_RAINBOW_ORE.builtInRegistryHolder().key())
                .add(ModBlocks.NETHER_RUBY_ORE.builtInRegistryHolder().key())
                .add(ModBlocks.RANDOM_RAINBOW_ORE.builtInRegistryHolder().key());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.DEEPSLATE_EXPERIENCE_ORE.builtInRegistryHolder().key())
                .add(ModBlocks.END_EXPERIENCE_ORE.builtInRegistryHolder().key())
                .add(ModBlocks.EXPERIENCE_ORE.builtInRegistryHolder().key())
                .add(ModBlocks.NETHER_COPPER_ORE.builtInRegistryHolder().key())
                .add(ModBlocks.NETHER_EXPERIENCE_ORE.builtInRegistryHolder().key())
                .add(ModBlocks.NETHER_IRON_ORE.builtInRegistryHolder().key());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BLOCK_OF_NETHER_RUBY.builtInRegistryHolder().key())
                .add(ModBlocks.DEEPSLATE_RANDOM_RAINBOW_ORE.builtInRegistryHolder().key())
                .add(ModBlocks.END_RANDOM_RAINBOW_ORE.builtInRegistryHolder().key())
                .add(ModBlocks.NETHER_DIAMOND_ORE.builtInRegistryHolder().key())
                .add(ModBlocks.NETHER_RANDOM_RAINBOW_ORE.builtInRegistryHolder().key())
                .add(ModBlocks.NETHER_RUBY_ORE.builtInRegistryHolder().key())
                .add(ModBlocks.RANDOM_RAINBOW_ORE.builtInRegistryHolder().key());

        tag(ModTags.Blocks.INCORRECT_FOR_NETHER_RUBY_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL);

        tag(ModTags.Blocks.NEEDS_NETHER_RUBY_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);
    }
}