package com.miskatonicmysteries.common.feature.block.blockentity;

import com.miskatonicmysteries.common.registry.MMObjects;
import com.miskatonicmysteries.common.util.Constants;

import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class AltarBlockEntity extends BaseBlockEntity implements ImplementedBlockEntityInventory {

	private final DefaultedList<ItemStack> ITEMS = DefaultedList.ofSize(1, ItemStack.EMPTY);

	public AltarBlockEntity(BlockPos pos, BlockState state) {
		super(MMObjects.ALTAR_BLOCK_ENTITY_TYPE, pos, state);
	}

	@Override
	public void readNbt(NbtCompound nbt) {
		ITEMS.clear();
		Inventories.readNbt(nbt, ITEMS);
		super.readNbt(nbt);
	}

	@Override
	public void writeNbt(NbtCompound tag) {
		Inventories.writeNbt(tag, ITEMS);
	}

	@Override
	public void markDirty() {
		if (world != null && !world.isClient) {
			sync(world, pos);
		}
		super.markDirty();
	}

	@Override
	public ItemStack removeStack(int slot, int count) {
		return ImplementedBlockEntityInventory.super.removeStack(slot, count);
	}

	@Override
	public ItemStack removeStack(int slot) {
		return ImplementedBlockEntityInventory.super.removeStack(slot);
	}

	@Override
	public void setStack(int slot, ItemStack stack) {
		ImplementedBlockEntityInventory.super.setStack(slot, stack);
	}

	@Override
	public boolean canPlayerUse(PlayerEntity player) {
		return ImplementedBlockEntityInventory.super.canPlayerUse(player);
	}

	public void sync(World world, BlockPos pos) {
		if (world != null && !world.isClient) {
			world.updateListeners(pos, getCachedState(), getCachedState(), Block.NOTIFY_LISTENERS);
		}
	}

	@Override
	public int getMaxCountPerStack() {
		return 1;
	}

	@Override
	public boolean isValid(int slot, ItemStack stack) {
		return stack.isIn(Constants.Tags.ALTAR_BOOKS);
	}

	@Override
	public void clear() {
		ImplementedBlockEntityInventory.super.clear();
	}

	@Override
	public DefaultedList<ItemStack> getItems() {
		return ITEMS;
	}

	@Override
	public ItemStack getStack(Item item) {
		return ImplementedBlockEntityInventory.super.getStack(item);
	}

	@Override
	public int size() {
		return ImplementedBlockEntityInventory.super.size();
	}

	@Override
	public boolean isEmpty() {
		return ImplementedBlockEntityInventory.super.isEmpty();
	}

	@Override
	public ItemStack getStack(int slot) {
		return ImplementedBlockEntityInventory.super.getStack(slot);
	}

	public Item getBook() {
		return getStack(0).getItem();
	}
}
