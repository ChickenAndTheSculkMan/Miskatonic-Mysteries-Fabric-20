package com.miskatonicmysteries.api.interfaces;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Recipe;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.world.World;

public interface LazySerializable extends Recipe<Inventory> {

	@Override
	default boolean matches(Inventory inv, World world) {
		return true;
	}

	@Override
    default ItemStack craft(Inventory inventory, DynamicRegistryManager registryManager) {
		return ItemStack.EMPTY;
	}

	@Override
	default boolean fits(int width, int height) {
		return true;
	}

	@Override
    default ItemStack getOutput(DynamicRegistryManager registryManager) {
		return ItemStack.EMPTY;
	}

	@Override
	default String getGroup() {
		return getId().toString();
	}
}
