package net.caeru.vassortments;

import net.caeru.vassortments.block.ModBlocks;
import net.caeru.vassortments.item.ModItems;
import net.caeru.vassortments.loot.RandomRainbowOreLoot;
import net.caeru.vassortments.worldgen.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VariousAssortments implements ModInitializer {
	public static final String MOD_ID = "vassortments";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		ModWorldGeneration.generateModWorldGen();
		RandomRainbowOreLoot.register();

	}
}
