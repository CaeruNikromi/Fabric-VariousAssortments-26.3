package net.caeru.vassortments.tags;

import net.caeru.vassortments.VariousAssortments;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_NETHER_RUBY_TOOL = createTag("needs_nether_ruby_tool");
        public static final TagKey<Block> INCORRECT_FOR_NETHER_RUBY_TOOL = createTag("incorrect_for_nether_ruby_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(VariousAssortments.MOD_ID, name));
        }
    }
    public static class Items {
        public static final TagKey<Item> NETHER_RUBY_REPAIR = createTag("nether_ruby_repair");

        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(VariousAssortments.MOD_ID, name));
        }
    }
}
