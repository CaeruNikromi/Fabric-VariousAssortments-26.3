package net.caeru.vassortments.datagen;

import net.caeru.vassortments.block.ModBlocks;
import net.caeru.vassortments.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }


    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registres, BootstrapContext<Recipe<?>> recipes, BootstrapContext<Advancement> advancements) {
        return new RecipeProvider(recipes, advancements) {
            @Override
            public void buildRecipes() {
                List<ItemLike> DIAMOND_NUGGET_SMELTABLES = List.of(Items.DIAMOND_AXE, Items.DIAMOND_HOE, Items.DIAMOND_PICKAXE, Items.DIAMOND_SHOVEL, Items.DIAMOND_SPEAR, Items.DIAMOND_SWORD, Items.DIAMOND_HELMET, Items.DIAMOND_CHESTPLATE, Items.DIAMOND_LEGGINGS, Items.DIAMOND_BOOTS, Items.DIAMOND_HORSE_ARMOR, Items.DIAMOND_NAUTILUS_ARMOR);
                List<ItemLike> EXPERIENCE_SMELTABLES = List.of(ModBlocks.DEEPSLATE_EXPERIENCE_ORE, ModBlocks.END_EXPERIENCE_ORE, ModBlocks.EXPERIENCE_ORE, ModBlocks.NETHER_EXPERIENCE_ORE);
                List<ItemLike> RANDOM_RAINBOW_SMELTABLES = List.of(ModBlocks.RANDOM_RAINBOW_ORE, ModBlocks.DEEPSLATE_RANDOM_RAINBOW_ORE, ModBlocks.NETHER_RANDOM_RAINBOW_ORE, ModBlocks.END_RANDOM_RAINBOW_ORE);

                oreSmelting(DIAMOND_NUGGET_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.DIAMOND_NUGGET, 1f, 200, "diamond");
                oreSmelting(EXPERIENCE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, Items.EXPERIENCE_BOTTLE, 1f, 200, "experience");
                oreSmelting(List.of(ModBlocks.NETHER_COPPER_ORE), RecipeCategory.MISC, CookingBookCategory.MISC, Items.COPPER_INGOT, 0.7f, 200, "copper");
                oreSmelting(List.of(ModBlocks.NETHER_DIAMOND_ORE), RecipeCategory.MISC, CookingBookCategory.MISC, Items.DIAMOND, 1f, 200, "diamond");
                oreSmelting(List.of(ModBlocks.NETHER_IRON_ORE), RecipeCategory.MISC, CookingBookCategory.MISC, Items.IRON_INGOT, 0.7f, 200, "iron");
                oreSmelting(RANDOM_RAINBOW_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.RANDOM_RAINBOW_GEM, 0.25f, 200, "random_rainbow");

                oreBlasting(List.of(ModBlocks.NETHER_COPPER_ORE), RecipeCategory.MISC, CookingBookCategory.MISC, Items.COPPER_INGOT, 0.7f, 150, "copper");
                oreBlasting(List.of(ModBlocks.NETHER_DIAMOND_ORE), RecipeCategory.MISC, CookingBookCategory.MISC, Items.DIAMOND, 1f, 150, "diamond");
                oreBlasting(List.of(ModBlocks.NETHER_IRON_ORE), RecipeCategory.MISC, CookingBookCategory.MISC, Items.IRON_INGOT, 0.7f, 150, "iron");
                oreBlasting(RANDOM_RAINBOW_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.RANDOM_RAINBOW_GEM, 0.25f, 150, "random_rainbow");

                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.NETHER_RUBY, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLOCK_OF_NETHER_RUBY);

                nineBlockStorageRecipes(RecipeCategory.MISC, Items.CHARCOAL, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLOCK_OF_CHARCOAL);

                shaped(RecipeCategory.MISC, ModItems.DIAMOND_BEETROOT)
                        .pattern("DDD")
                        .pattern("DBD")
                        .pattern("DDD")
                        .define('D', ModItems.DIAMOND_NUGGET)
                        .define('B', Items.BEETROOT)
                        .unlockedBy(getHasName(ModItems.DIAMOND_NUGGET), has(ModItems.DIAMOND_NUGGET))
                        .group("food")
                        .save(output);

                shapeless(RecipeCategory.MISC, ModItems.DIAMOND_NUGGET, 9)
                        .requires(Items.DIAMOND)
                        .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                        .group("material")
                        .save(output);

                shaped(RecipeCategory.MISC, ModBlocks.DEEPSLATE_RANDOM_RAINBOW_ORE)
                        .pattern("DSD")
                        .pattern("SRS")
                        .pattern("DSD")
                        .define('D', Items.DIAMOND)
                        .define('S', Blocks.DEEPSLATE)
                        .define('R', ModItems.NETHER_RUBY)
                        .unlockedBy(getHasName(ModItems.NETHER_RUBY), has(ModItems.NETHER_RUBY))
                        .group("nether_ruby")
                        .save(output);

                shaped(RecipeCategory.MISC, ModBlocks.END_RANDOM_RAINBOW_ORE)
                        .pattern("DED")
                        .pattern("ERE")
                        .pattern("DED")
                        .define('D', Items.DIAMOND)
                        .define('E', Blocks.END_STONE)
                        .define('R', ModItems.NETHER_RUBY)
                        .unlockedBy(getHasName(ModItems.NETHER_RUBY), has(ModItems.NETHER_RUBY))
                        .group("nether_ruby")
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.NAUGHTY_STICK)
                        .pattern("  S")
                        .pattern(" R ")
                        .pattern("S  ")
                        .define('S', Items.STICK)
                        .define('R', ModItems.NETHER_RUBY)
                        .unlockedBy(getHasName(ModItems.NETHER_RUBY), has(ModItems.NETHER_RUBY))
                        .group("nether_ruby")
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.NAUGHTY_STICK)
                        .pattern("S  ")
                        .pattern(" R ")
                        .pattern("  S")
                        .define('S', Items.STICK)
                        .define('R', ModItems.NETHER_RUBY)
                        .unlockedBy(getHasName(ModItems.NETHER_RUBY), has(ModItems.NETHER_RUBY))
                        .group("nether_ruby")
                        .save(output, "naughty_stick_other_way");

                shaped(RecipeCategory.MISC, ModBlocks.NETHER_RANDOM_RAINBOW_ORE)
                        .pattern("DND")
                        .pattern("NRN")
                        .pattern("DND")
                        .define('D', Items.DIAMOND)
                        .define('N', Blocks.NETHERRACK)
                        .define('R', ModItems.NETHER_RUBY)
                        .unlockedBy(getHasName(ModItems.NETHER_RUBY), has(ModItems.NETHER_RUBY))
                        .group("nether_ruby")
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.NETHER_RUBY_AXE)
                        .pattern("NN")
                        .pattern("SN")
                        .pattern("S ")
                        .define('N', ModItems.NETHER_RUBY)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.NETHER_RUBY), has(ModItems.NETHER_RUBY))
                        .group("nether_ruby")
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.NETHER_RUBY_BOOTS)
                        .pattern("N N")
                        .pattern("N N")
                        .define('N', ModItems.NETHER_RUBY)
                        .unlockedBy(getHasName(ModItems.NETHER_RUBY), has(ModItems.NETHER_RUBY))
                        .group("nether_ruby")
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.NETHER_RUBY_CHESTPLATE)
                        .pattern("N N")
                        .pattern("NNN")
                        .pattern("NNN")
                        .define('N', ModItems.NETHER_RUBY)
                        .unlockedBy(getHasName(ModItems.NETHER_RUBY), has(ModItems.NETHER_RUBY))
                        .group("nether_ruby")
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.NETHER_RUBY_HELMET)
                        .pattern("NNN")
                        .pattern("N N")
                        .define('N', ModItems.NETHER_RUBY)
                        .unlockedBy(getHasName(ModItems.NETHER_RUBY), has(ModItems.NETHER_RUBY))
                        .group("nether_ruby")
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.NETHER_RUBY_HOE)
                        .pattern("NN")
                        .pattern("S ")
                        .pattern("S ")
                        .define('N', ModItems.NETHER_RUBY)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.NETHER_RUBY), has(ModItems.NETHER_RUBY))
                        .group("nether_ruby")
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.NETHER_RUBY_LEGGINGS)
                        .pattern("NNN")
                        .pattern("N N")
                        .pattern("N N")
                        .define('N', ModItems.NETHER_RUBY)
                        .unlockedBy(getHasName(ModItems.NETHER_RUBY), has(ModItems.NETHER_RUBY))
                        .group("nether_ruby")
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.NETHER_RUBY_PICKAXE)
                        .pattern("NNN")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('N', ModItems.NETHER_RUBY)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.NETHER_RUBY), has(ModItems.NETHER_RUBY))
                        .group("nether_ruby")
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.NETHER_RUBY_SHOVEL)
                        .pattern("N")
                        .pattern("S")
                        .pattern("S")
                        .define('N', ModItems.NETHER_RUBY)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.NETHER_RUBY), has(ModItems.NETHER_RUBY))
                        .group("nether_ruby")
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.NETHER_RUBY_SPEAR)
                        .pattern("  N")
                        .pattern(" S ")
                        .pattern("S  ")
                        .define('N', ModItems.NETHER_RUBY)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.NETHER_RUBY), has(ModItems.NETHER_RUBY))
                        .group("nether_ruby")
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.NETHER_RUBY_SWORD)
                        .pattern("N")
                        .pattern("N")
                        .pattern("S")
                        .define('N', ModItems.NETHER_RUBY)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.NETHER_RUBY), has(ModItems.NETHER_RUBY))
                        .group("nether_ruby")
                        .save(output);

                shaped(RecipeCategory.MISC, ModBlocks.RANDOM_RAINBOW_ORE)
                        .pattern("DSD")
                        .pattern("SRS")
                        .pattern("DSD")
                        .define('D', Items.DIAMOND)
                        .define('S', Blocks.STONE)
                        .define('R', ModItems.NETHER_RUBY)
                        .unlockedBy(getHasName(ModItems.NETHER_RUBY), has(ModItems.NETHER_RUBY))
                        .group("nether_ruby")
                        .save(output);


            }
        };
    }

    @Override
    public String getName() {return "Various Assortments Recipes";}
}