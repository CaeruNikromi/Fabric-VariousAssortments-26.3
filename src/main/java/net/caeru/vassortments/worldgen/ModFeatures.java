package net.caeru.vassortments.worldgen;

import net.caeru.vassortments.VariousAssortments;
import net.caeru.vassortments.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.BlockReplacement;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModFeatures {
    public static final ResourceKey<Feature> END_EXPERIENCE_ORE_KEY = registerKey("end_experience_ore");
    public static final ResourceKey<Feature> END_RANDOM_RAINBOW_ORE_KEY = registerKey("end_random_rainbow_ore");
    public static final ResourceKey<Feature> NETHER_COPPER_ORE_KEY = registerKey("nether_copper_ore");
    public static final ResourceKey<Feature> NETHER_DIAMOND_ORE_KEY = registerKey("nether_diamond_ore");
    public static final ResourceKey<Feature> NETHER_EXPERIENCE_ORE_KEY = registerKey("nether_experience_ore");
    public static final ResourceKey<Feature> NETHER_IRON_ORE_KEY = registerKey("nether_iron_ore");
    public static final ResourceKey<Feature> NETHER_RANDOM_RAINBOW_ORE_KEY = registerKey("nether_random_rainbow_ore");
    public static final ResourceKey<Feature> NETHER_RUBY_ORE_KEY = registerKey("nether_ruby_ore");
    public static final ResourceKey<Feature> OVERWORLD_EXPERIENCE_ORE_KEY = registerKey("overworld_experience_ore");
    public static final ResourceKey<Feature> OVERWORLD_RANDOM_RAINBOW_ORE_KEY = registerKey("overworld_random_rainbow_ore");


    public static void bootstrap(BootstrapContext<Feature> context) {
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);
        RuleTest netherReplaceables = new TagMatchTest(BlockTags.BASE_STONE_NETHER);
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);

        context.register(END_EXPERIENCE_ORE_KEY, new OreFeature(
                List.of(BlockReplacement.replace(endReplaceables, ModBlocks.END_EXPERIENCE_ORE.defaultBlockState())),
        8));

        context.register(END_RANDOM_RAINBOW_ORE_KEY, new OreFeature(
                List.of(BlockReplacement.replace(endReplaceables, ModBlocks.END_RANDOM_RAINBOW_ORE.defaultBlockState())),
        6));

        context.register(NETHER_COPPER_ORE_KEY, new OreFeature(
                List.of(BlockReplacement.replace(netherReplaceables, ModBlocks.NETHER_COPPER_ORE.defaultBlockState())),
        16));

        context.register(NETHER_DIAMOND_ORE_KEY, new OreFeature(
                List.of(BlockReplacement.replace(netherReplaceables, ModBlocks.NETHER_DIAMOND_ORE.defaultBlockState())),
        8));

        context.register(NETHER_EXPERIENCE_ORE_KEY, new OreFeature(
                List.of(BlockReplacement.replace(netherReplaceables, ModBlocks.NETHER_EXPERIENCE_ORE.defaultBlockState())),
        8));

        context.register(NETHER_IRON_ORE_KEY, new OreFeature(
                List.of(BlockReplacement.replace(netherReplaceables, ModBlocks.NETHER_IRON_ORE.defaultBlockState())),
        16));

        context.register(NETHER_RANDOM_RAINBOW_ORE_KEY, new OreFeature(
                List.of(BlockReplacement.replace(netherReplaceables, ModBlocks.NETHER_RANDOM_RAINBOW_ORE.defaultBlockState())),
        6));

        context.register(NETHER_RUBY_ORE_KEY, new OreFeature(
                List.of(BlockReplacement.replace(netherReplaceables, ModBlocks.NETHER_RUBY_ORE.defaultBlockState())),
        6));

        context.register(OVERWORLD_EXPERIENCE_ORE_KEY, new OreFeature(
                List.of(BlockReplacement.replace(stoneReplaceables, ModBlocks.EXPERIENCE_ORE.defaultBlockState()),
                BlockReplacement.replace(deepslateReplaceables, ModBlocks.DEEPSLATE_EXPERIENCE_ORE.defaultBlockState())),
        10));

        context.register(OVERWORLD_RANDOM_RAINBOW_ORE_KEY, new OreFeature(
                List.of(BlockReplacement.replace(stoneReplaceables, ModBlocks.RANDOM_RAINBOW_ORE.defaultBlockState()),
                        BlockReplacement.replace(deepslateReplaceables, ModBlocks.DEEPSLATE_RANDOM_RAINBOW_ORE.defaultBlockState())),
        8));
    }
    public static ResourceKey<Feature> registerKey(String name) {
        return ResourceKey.create(Registries.FEATURE, Identifier.fromNamespaceAndPath(VariousAssortments.MOD_ID, name));
    }
}
