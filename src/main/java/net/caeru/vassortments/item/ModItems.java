package net.caeru.vassortments.item;

import net.caeru.vassortments.VariousAssortments;
import net.caeru.vassortments.food.ModFoods;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.CookingFuel;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.storage.loot.providers.number.floats.ContextFloatProviders;
import net.minecraft.world.level.storage.loot.providers.number.floats.ResolvableFloat;
import net.minecraft.world.level.storage.loot.providers.number.ints.ResolvableInt;

import java.util.function.Function;

public class ModItems {
    public static final Item DIAMOND_BEETROOT = registerItem("diamond_beetroot", properties -> new Item(properties.food(ModFoods.DIAMOND_BEETROOT, ModFoods.DIAMOND_BEETROOT_CONSUMABLE)));
    public static final Item DIAMOND_NUGGET = registerItem("diamond_nugget", Item::new);
    public static final Item NAUGHTY_STICK = registerItem("naughty_stick", Item::new);
    public static final Item NETHER_RUBY = registerItem("nether_ruby", properties -> new Item(properties.component(DataComponents.COOKING_FUEL, new CookingFuel(new ResolvableInt.Constant(4800), ResolvableFloat.fromKey(ContextFloatProviders.COOKING_DEFAULT_SPEED_MULTIPLIER))).fireResistant()));
    public static final Item NETHER_RUBY_AXE = registerItem("nether_ruby_axe", properties -> new Item(properties.axe(ModToolMaterials.NETHER_RUBY, 5, -3.0f).fireResistant()));
    public static final Item NETHER_RUBY_BOOTS = registerItem("nether_ruby_boots", properties -> new Item(properties.humanoidArmor(ModArmorMaterials.NETHER_RUBY_ARMOR_MATERIAL, ArmorType.BOOTS).fireResistant()));
    public static final Item NETHER_RUBY_CHESTPLATE = registerItem("nether_ruby_chestplate", properties -> new Item(properties.humanoidArmor(ModArmorMaterials.NETHER_RUBY_ARMOR_MATERIAL, ArmorType.CHESTPLATE).fireResistant()));
    public static final Item NETHER_RUBY_HELMET = registerItem("nether_ruby_helmet", properties -> new Item(properties.humanoidArmor(ModArmorMaterials.NETHER_RUBY_ARMOR_MATERIAL, ArmorType.HELMET).fireResistant()));
    public static final Item NETHER_RUBY_HOE = registerItem("nether_ruby_hoe", properties -> new Item(properties.hoe(ModToolMaterials.NETHER_RUBY, -3, 0.0f).fireResistant()));
    public static final Item NETHER_RUBY_HORSE_ARMOR = registerItem("nether_ruby_horse_armor", properties -> new Item(properties.horseArmor(ModArmorMaterials.NETHER_RUBY_ARMOR_MATERIAL).fireResistant()));
    public static final Item NETHER_RUBY_NAUTILUS_ARMOR = registerItem("nether_ruby_nautilus_armor", properties -> new Item(properties.nautilusArmor(ModArmorMaterials.NETHER_RUBY_ARMOR_MATERIAL).fireResistant()));
    public static final Item NETHER_RUBY_LEGGINGS = registerItem("nether_ruby_leggings", properties -> new Item(properties.humanoidArmor(ModArmorMaterials.NETHER_RUBY_ARMOR_MATERIAL, ArmorType.LEGGINGS).fireResistant()));
    public static final Item NETHER_RUBY_PICKAXE = registerItem("nether_ruby_pickaxe", properties -> new Item(properties.pickaxe(ModToolMaterials.NETHER_RUBY, 1, -2.8f).fireResistant()));
    public static final Item NETHER_RUBY_SHOVEL = registerItem("nether_ruby_shovel", properties -> new Item(properties.shovel(ModToolMaterials.NETHER_RUBY, 1.5f, -3.0f).fireResistant()));
    public static final Item NETHER_RUBY_SPEAR = registerItem("nether_ruby_spear", properties -> new Item(properties.spear(ModToolMaterials.NETHER_RUBY, 1.05f, 1.075f, 0.5f, 3.0f, 10.0f, 6.5f, 5.1f, 8.75f, 4.6f).fireResistant()));
    public static final Item NETHER_RUBY_SWORD = registerItem("nether_ruby_sword", properties -> new Item(properties.sword(ModToolMaterials.NETHER_RUBY, 3, -2.4f).fireResistant()));
    public static final Item RANDOM_RAINBOW_GEM = registerItem("random_rainbow_gem", Item::new);
    public static final Item SPRITE_LOCATOR = registerItem("sprite_locator", Item::new);


    public static ResourceKey<Item> getRK(Item item) {
        return BuiltInRegistries.ITEM.getResourceKey(item).get();
    }

    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(VariousAssortments.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(VariousAssortments.MOD_ID, name)))));
    }

    public static void registerModItems() {
        VariousAssortments.LOGGER.info("Registering Mod Items for " + VariousAssortments.MOD_ID);

// These items currently use placeholder models taken online: Random Rainbow Gem
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
            output.accept(DIAMOND_NUGGET);
            output.accept(NETHER_RUBY);
            output.accept(RANDOM_RAINBOW_GEM);
            output.accept(SPRITE_LOCATOR);
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register( output -> {
            output.accept(NAUGHTY_STICK);
            output.accept(NETHER_RUBY_AXE);
            output.accept(NETHER_RUBY_HOE);
            output.accept(NETHER_RUBY_PICKAXE);
            output.accept(NETHER_RUBY_SHOVEL);
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FOOD_AND_DRINKS).register( output -> {
            output.accept(DIAMOND_BEETROOT);
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(output -> {
            output.accept(NETHER_RUBY_HELMET);
            output.accept(NETHER_RUBY_CHESTPLATE);
            output.accept(NETHER_RUBY_LEGGINGS);
            output.accept(NETHER_RUBY_BOOTS);
            output.accept(NETHER_RUBY_SPEAR);
            output.accept(NETHER_RUBY_SWORD);
            output.accept(NETHER_RUBY_HORSE_ARMOR);
            output.accept(NETHER_RUBY_NAUTILUS_ARMOR);
        });
    }
}
