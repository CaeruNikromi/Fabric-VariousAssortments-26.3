package net.caeru.vassortments.item;

import net.caeru.vassortments.VariousAssortments;
import net.caeru.vassortments.tags.ModTags;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.EquipmentAsset;

public class ModArmorMaterials {
    public static final ResourceKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY =
            ResourceKey.createRegistryKey(Identifier.withDefaultNamespace("equipment_asset"));

    public static final ResourceKey<EquipmentAsset> NETHER_RUBY_KEY = ResourceKey.create(REGISTRY_KEY, Identifier.fromNamespaceAndPath(VariousAssortments.MOD_ID, "nether_ruby"));

    public static final ArmorMaterial NETHER_RUBY_ARMOR_MATERIAL = new ArmorMaterial(33, ArmorMaterials.makeDefense(3, 6, 8, 3, 11), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, ModTags.Items.NETHER_RUBY_REPAIR, NETHER_RUBY_KEY);
}
