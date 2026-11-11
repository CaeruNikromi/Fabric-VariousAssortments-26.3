package net.caeru.vassortments.block;

import net.caeru.vassortments.VariousAssortments;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.CookingFuel;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.storage.loot.providers.number.floats.ContextFloatProviders;
import net.minecraft.world.level.storage.loot.providers.number.floats.ResolvableFloat;
import net.minecraft.world.level.storage.loot.providers.number.ints.ResolvableInt;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ModBlocks {
    public static final Block BLOCK_OF_CHARCOAL = registerBlock("block_of_charcoal",
            properties -> new Block(properties.strength(5f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)),
            properties -> properties.component(DataComponents.COOKING_FUEL, new CookingFuel(new ResolvableInt.Constant(16000), ResolvableFloat.fromKey(ContextFloatProviders.COOKING_DEFAULT_SPEED_MULTIPLIER))));
    public static final Block BLOCK_OF_NETHER_RUBY = registerBlock("block_of_nether_ruby",
            properties -> new Block(properties.strength(3.5f)
                    .requiresCorrectToolForDrops().sound(SoundType.METAL)),
            properties -> properties.component(DataComponents.COOKING_FUEL, new CookingFuel(new ResolvableInt.Constant(43200), ResolvableFloat.fromKey(ContextFloatProviders.COOKING_DEFAULT_SPEED_MULTIPLIER))));
    public static final Block DEEPSLATE_EXPERIENCE_ORE = registerBlock("deepslate_experience_ore",
            properties -> new DropExperienceBlock(UniformInt.of(10, 20), properties.strength(4.5f)
                    .requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final Block DEEPSLATE_RANDOM_RAINBOW_ORE = registerBlock("deepslate_random_rainbow_ore",
            properties -> new Block(properties.strength(4.5f)
                    .requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final Block END_EXPERIENCE_ORE = registerBlock("end_experience_ore",
            properties -> new DropExperienceBlock(UniformInt.of(10, 20), properties.strength(3f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final Block END_RANDOM_RAINBOW_ORE = registerBlock("end_random_rainbow_ore",
            properties -> new Block(properties.strength(3f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final Block EXPERIENCE_ORE = registerBlock("experience_ore",
            properties -> new DropExperienceBlock(UniformInt.of(10, 20), properties.strength(3f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final Block NETHER_COPPER_ORE = registerBlock("nether_copper_ore",
            properties -> new DropExperienceBlock(UniformInt.of(0, 1), properties.strength(3f)
                    .requiresCorrectToolForDrops().sound(SoundType.NETHERRACK)));
    public static final Block NETHER_DIAMOND_ORE = registerBlock("nether_diamond_ore",
            properties -> new DropExperienceBlock(UniformInt.of(2, 5), properties.strength(3f)
                    .requiresCorrectToolForDrops().sound(SoundType.NETHERRACK)));
    public static final Block NETHER_EXPERIENCE_ORE = registerBlock("nether_experience_ore",
            properties -> new DropExperienceBlock(UniformInt.of(10, 20), properties.strength(3f)
                    .requiresCorrectToolForDrops().sound(SoundType.NETHERRACK)));
    public static final Block NETHER_IRON_ORE = registerBlock("nether_iron_ore",
            properties -> new DropExperienceBlock(UniformInt.of(1, 2), properties.strength(3f)
                    .requiresCorrectToolForDrops().sound(SoundType.NETHERRACK)));
    public static final Block NETHER_RUBY_ORE = registerBlock("nether_ruby_ore",
            properties -> new DropExperienceBlock(UniformInt.of(5, 10), properties.strength(3.5f)
                    .requiresCorrectToolForDrops().sound(SoundType.NETHERRACK)));
    public static final Block NETHER_RANDOM_RAINBOW_ORE = registerBlock("nether_random_rainbow_ore",
            properties -> new Block(properties.strength(3f)
                    .requiresCorrectToolForDrops().sound(SoundType.NETHERRACK)));
    public static final Block RANDOM_RAINBOW_ORE = registerBlock("random_rainbow_ore",
            properties -> new Block(properties.strength(3f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        return registerBlock(name, function, properties -> properties);
    } private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function, UnaryOperator<Item.Properties> itemProperties) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(VariousAssortments.MOD_ID, name))));

        registerBlockItem(name, toRegister, itemProperties);

        return Registry.register(BuiltInRegistries.BLOCK,
                Identifier.fromNamespaceAndPath(VariousAssortments.MOD_ID, name), toRegister);
    }

    private static Item registerBlockItem(String name, Block block, UnaryOperator<Item.Properties> itemProperties) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(VariousAssortments.MOD_ID, name), new BlockItem(block, itemProperties.apply(new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(VariousAssortments.MOD_ID, name))))));
    }

    public static void registerModBlocks() {
        VariousAssortments.LOGGER.info("Registering Mod Blocks For " + VariousAssortments.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS).register( output -> {
            output.accept(DEEPSLATE_RANDOM_RAINBOW_ORE);
            output.accept(DEEPSLATE_EXPERIENCE_ORE);
            output.accept(END_EXPERIENCE_ORE);
            output.accept(EXPERIENCE_ORE);
            output.accept(END_RANDOM_RAINBOW_ORE);
            output.accept(NETHER_COPPER_ORE);
            output.accept(NETHER_DIAMOND_ORE);
            output.accept(NETHER_EXPERIENCE_ORE);
            output.accept(NETHER_IRON_ORE);
            output.accept(NETHER_RANDOM_RAINBOW_ORE);
            output.accept(NETHER_RUBY_ORE);
            output.accept(RANDOM_RAINBOW_ORE);
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS).register(output -> {
            output.accept(BLOCK_OF_CHARCOAL);
            output.accept(BLOCK_OF_NETHER_RUBY);
        });
    }
}
