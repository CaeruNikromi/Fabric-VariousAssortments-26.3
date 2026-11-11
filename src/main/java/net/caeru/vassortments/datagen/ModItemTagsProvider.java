package net.caeru.vassortments.datagen;

import net.caeru.vassortments.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends FabricTagsProvider.ItemTagsProvider {
    public ModItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(ItemTags.AXES).add(ModItems.getRK(ModItems.NETHER_RUBY_AXE));
        tag(ItemTags.HOES).add(ModItems.getRK(ModItems.NETHER_RUBY_HOE));
        tag(ItemTags.PICKAXES).add(ModItems.getRK(ModItems.NETHER_RUBY_PICKAXE));
        tag(ItemTags.SHOVELS).add(ModItems.getRK(ModItems.NETHER_RUBY_SHOVEL));
        tag(ItemTags.SPEARS).add(ModItems.getRK(ModItems.NETHER_RUBY_SPEAR));
        tag(ItemTags.SWORDS).add(ModItems.getRK(ModItems.NETHER_RUBY_SWORD));

        tag(ItemTags.HEAD_ARMOR).add(ModItems.getRK(ModItems.NETHER_RUBY_HELMET));
        tag(ItemTags.CHEST_ARMOR).add(ModItems.getRK(ModItems.NETHER_RUBY_CHESTPLATE));
        tag(ItemTags.LEG_ARMOR).add(ModItems.getRK(ModItems.NETHER_RUBY_LEGGINGS));
        tag(ItemTags.FOOT_ARMOR).add(ModItems.getRK(ModItems.NETHER_RUBY_BOOTS));
    }
}
