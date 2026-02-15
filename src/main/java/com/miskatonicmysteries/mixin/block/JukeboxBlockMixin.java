package com.miskatonicmysteries.mixin.block;

import com.miskatonicmysteries.common.feature.world.party.MMPartyState;
import com.miskatonicmysteries.common.feature.world.party.Party;

import net.minecraft.block.BlockState;
import net.minecraft.block.JukeboxBlock;
import net.minecraft.block.entity.JukeboxBlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(JukeboxBlockEntity.class)
public class JukeboxBlockMixin {
/*todo fix this up
	@Inject(method = "startPlaying", at = @At("HEAD"))
	private void onRecordSet(CallbackInfo ci) {
		if (world instanceof ServerWorld s) {
			Party party = MMPartyState.get(s).getParty(pos);
			if (party != null) {
				party.musicSources.add(pos);
			}
		}
	}

	@Inject(method = "stopPlaying", at = @At("HEAD"))
	private void onRecordRemoved(CallbackInfo ci) {
		if (world instanceof ServerWorld s) {
			Party party = MMPartyState.get(s).getParty(pos);
			if (party != null) {
				party.musicSources.remove(pos);
			}
		}
	}*/
}
