package com.miskatonicmysteries.common.registry;

import com.miskatonicmysteries.common.util.Constants;
import com.miskatonicmysteries.common.util.RegistryUtil;

import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;

public class MMSounds {
	//todo more entity sounds
	public static final SoundEvent AMBIENT_SCARY = register("ambient.scary");
	public static final SoundEvent BLOCK_RESONATOR_AMBIENT = register("block.resonator.ambient");
	public static final SoundEvent ENTITY_BYAKHEE_SADDLE = SoundEvents.ENTITY_HORSE_SADDLE;
	public static final SoundEvent ENTITY_HARROW_AMBIENT = register("entity.harrow.ambient");
	public static final SoundEvent ENTITY_HARROW_DEATH = register("entity.harrow.death");
	public static final SoundEvent ENTITY_HARROW_HURT = register("entity.harrow.hurt");
	public static final SoundEvent ENTITY_HARROW_CHARGE = register("entity.harrow.charge");
	public static final SoundEvent ITEM_BELL_USE = register("item.bell.use");
	public static final SoundEvent ITEM_GUN_GUN_SHOT = register("item.gun.gun_shot");
	public static final SoundEvent ITEM_INCANTATION_YOG_INCANTATION_BOUND = register("item.incantation_yog.incantation_bound");
	public static final SoundEvent ITEM_INFESTED_WHEAT_USE = register("item.infested_wheat.use");
	public static final SoundEvent RANDOM_PLING = register("random.pling");
	public static final SoundEvent RITE_RITE_TRIGGERED = register("rite.rite_triggered");
	public static final SoundEvent RITE_SPOTLIGHT = register("rite.spotlight");
	public static final SoundEvent RITE_TELEPORT = register("rite.teleport");
	public static final SoundEvent RITE_VEIL_SPAWN = register("rite.veil_spawn");
	public static final SoundEvent SPELL_SPELL_CAST = register("spell.spell_cast");
	public static void init() {
		//praying this *mess* actually works
	}

	private static SoundEvent register(String string) {
		Identifier id = new Identifier(Constants.MOD_ID, string);
		return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
	}
}
