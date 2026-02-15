package com.miskatonicmysteries.api.interfaces;

import net.minecraft.entity.player.PlayerEntity;
import org.jetbrains.annotations.Nullable;

public interface PlayerProvider {
	@Nullable PlayerEntity mm_getPlayer();
}
