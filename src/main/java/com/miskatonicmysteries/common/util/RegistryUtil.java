package com.miskatonicmysteries.common.util;

import com.miskatonicmysteries.mixin.world.StructurePoolAccessor;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BannerPattern;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.structure.processor.StructureProcessorList;
import net.minecraft.structure.processor.StructureProcessorLists;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;

import com.mojang.datafixers.util.Pair;

public class RegistryUtil {

	public static Block registerBlock(Block block, String name) {
		Block registeredBlock = register(Registries.BLOCK, name, block);
		register(Registries.ITEM, name, new BlockItem(block, new FabricItemSettings()));
		return registeredBlock;
	}

	public static <T> T register(Registry<? super T> registry, String name, T entry) {
		return Registry.register(registry, new Identifier(Constants.MOD_ID, name), entry);
	}

	public static RegistryEntry<BannerPattern> registerPattern(String id, String shortId) {
		BannerPattern pattern = Registry.register(Registries.BANNER_PATTERN, new Identifier(Constants.MOD_ID, id), new BannerPattern(Constants.MOD_ID + "_" + shortId));
		return Registries.BANNER_PATTERN.getEntry(Registries.BANNER_PATTERN.getKey(pattern).get()).get();
	}
	//Note, this might crash
	public static void tryAddElementToPool(Identifier targetPool, StructurePool pool, String elementId, StructurePool.Projection projection,
										   int weight) {
		tryAddElementToPool(targetPool, pool, elementId, projection, weight, (RegistryEntry<StructureProcessorList>)StructureProcessorLists.EMPTY);
	}

	public static void tryAddElementToPool(Identifier targetPool, StructurePool pool, String elementId, StructurePool.Projection projection,
										   int weight, RegistryEntry<StructureProcessorList> processors) {
		if (targetPool.equals(pool.getId())) {
			StructurePoolElement element = StructurePoolElement.ofProcessedLegacySingle(elementId, processors).apply(projection);
			for (int i = 0; i < weight; i++) {
				((StructurePoolAccessor) pool).getElements().add(element);
			}
			((StructurePoolAccessor) pool).getElementCounts().add(Pair.of(element, weight));
		}
	}
}
