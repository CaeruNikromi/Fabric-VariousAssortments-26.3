package net.caeru.vassortments.worldgen;

import net.caeru.vassortments.VariousAssortments;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> END_EXPERIENCE_ORE_PLACED_KEY = registerKey("end_experience_ore_placed");
    public static final ResourceKey<PlacedFeature> END_RANDOM_RAINBOW_ORE_PLACED_KEY = registerKey("end_random_rainbow_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_COPPER_ORE_PLACED_KEY = registerKey("nether_copper_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_DIAMOND_ORE_PLACED_KEY = registerKey("nether_diamond_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_EXPERIENCE_ORE_PLACED_KEY = registerKey("nether_experience_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_IRON_ORE_PLACED_KEY = registerKey("nether_iron_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_RANDOM_RAINBOW_ORE_PLACED_KEY = registerKey("nether_random_rainbow_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_RUBY_ORE_PLACED_KEY = registerKey("nether_ruby_ore_placed");
    public static final ResourceKey<PlacedFeature> OVERWORLD_EXPERIENCE_ORE_PLACED_KEY = registerKey("overworld_experience_ore_placed");
    public static final ResourceKey<PlacedFeature> OVERWORLD_RANDOM_RAINBOW_ORE_PLACED_KEY = registerKey("overworld_random_rainbow_ore_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.FEATURE);

        register(context, END_EXPERIENCE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModFeatures.END_EXPERIENCE_ORE_KEY),
                OrePlacements.commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-64), VerticalAnchor.aboveBottom(100))));
        register(context, END_RANDOM_RAINBOW_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModFeatures.END_RANDOM_RAINBOW_ORE_KEY),
                OrePlacements.rareOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-64), VerticalAnchor.aboveBottom(100))));
        register(context, NETHER_COPPER_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModFeatures.NETHER_COPPER_ORE_KEY),
                OrePlacements.commonOrePlacement(8, HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(20), VerticalAnchor.aboveBottom(100))));
        register(context, NETHER_DIAMOND_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModFeatures.NETHER_DIAMOND_ORE_KEY),
                OrePlacements.rareOrePlacement(2, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-32), VerticalAnchor.aboveBottom(30))));
        register(context, NETHER_EXPERIENCE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModFeatures.NETHER_EXPERIENCE_ORE_KEY),
                OrePlacements.commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-32), VerticalAnchor.aboveBottom(100))));
        register(context, NETHER_IRON_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModFeatures.NETHER_IRON_ORE_KEY),
                OrePlacements.commonOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(0), VerticalAnchor.aboveBottom(100))));
        register(context, NETHER_RANDOM_RAINBOW_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModFeatures.NETHER_RANDOM_RAINBOW_ORE_KEY),
                OrePlacements.rareOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-32), VerticalAnchor.aboveBottom(50))));
        register(context, NETHER_RUBY_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModFeatures.NETHER_RUBY_ORE_KEY),
                OrePlacements.rareOrePlacement(2, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-32), VerticalAnchor.aboveBottom(50))));
        register(context, OVERWORLD_EXPERIENCE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModFeatures.OVERWORLD_EXPERIENCE_ORE_KEY),
                OrePlacements.commonOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-48), VerticalAnchor.aboveBottom(100))));
        register(context, OVERWORLD_RANDOM_RAINBOW_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModFeatures.OVERWORLD_RANDOM_RAINBOW_ORE_KEY),
                OrePlacements.rareOrePlacement(3, HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(60))));

    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(VariousAssortments.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                 Holder<Feature> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
