package com.miskatonicmysteries.common.registry;

import com.miskatonicmysteries.api.interfaces.Resonating;
import com.miskatonicmysteries.api.interfaces.SpellCaster;
import com.miskatonicmysteries.common.feature.effect.BleedStatusEffect;
import com.miskatonicmysteries.common.feature.effect.BrainDrainStatusEffect;
import com.miskatonicmysteries.common.feature.effect.ClairvoyanceStatusEffect;
import com.miskatonicmysteries.common.feature.effect.ExoticCravingsStatusEffect;
import com.miskatonicmysteries.common.feature.effect.GreenFairyStatusEffect;
import com.miskatonicmysteries.common.feature.effect.HomelyStatusEffect;
import com.miskatonicmysteries.common.feature.effect.LazarusStatusEffect;
import com.miskatonicmysteries.common.feature.effect.ManiaStatusEffect;
import com.miskatonicmysteries.common.feature.effect.OthervibesStatusEffect;
import com.miskatonicmysteries.common.feature.effect.OvermedicalizedStatusEffect;
import com.miskatonicmysteries.common.feature.effect.ResonanceStatusEffect;
import com.miskatonicmysteries.common.feature.effect.TranquilizedStatusEffect;
import com.miskatonicmysteries.common.feature.effect.UltraViolenceStatusEffect;
import com.miskatonicmysteries.common.util.RegistryUtil;
import com.miskatonicmysteries.mixin.recipe.BrewingRecipeRegistryAccessor;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;

public class MMStatusEffects {

	public static final StatusEffect MANIA = new ManiaStatusEffect();
	public static final StatusEffect TRANQUILIZED = new TranquilizedStatusEffect();
	public static final StatusEffect OVERMEDICATED = new OvermedicalizedStatusEffect();
	public static final StatusEffect LAZARUS = new LazarusStatusEffect();
	public static final StatusEffect BLEED = new BleedStatusEffect();
	public static final StatusEffect RESONANCE = new ResonanceStatusEffect();
	public static final StatusEffect EXOTIC_CRAVINGS = new ExoticCravingsStatusEffect();
	public static final StatusEffect ULTRA_VIOLENCE = new UltraViolenceStatusEffect();
	public static final StatusEffect CLAIRVOYANCE = new ClairvoyanceStatusEffect();
	public static final StatusEffect OTHERVIBES = new OthervibesStatusEffect();
	public static final StatusEffect HOMELY = new HomelyStatusEffect();
	public static final StatusEffect BRAIN_DRAIN = new BrainDrainStatusEffect();
	public static final StatusEffect GREEN_FAIRY = new GreenFairyStatusEffect();

	public static void init() {
		RegistryUtil.register(Registries.STATUS_EFFECT, "mania", MANIA);
		RegistryUtil.register(Registries.STATUS_EFFECT, "tranquilized", TRANQUILIZED);
		RegistryUtil.register(Registries.STATUS_EFFECT, "overmedicated", OVERMEDICATED);
		RegistryUtil.register(Registries.STATUS_EFFECT, "lazarus", LAZARUS);
		RegistryUtil.register(Registries.STATUS_EFFECT, "bleed", BLEED);
		RegistryUtil.register(Registries.STATUS_EFFECT, "resonance", RESONANCE);
		RegistryUtil.register(Registries.STATUS_EFFECT, "exotic_cravings", EXOTIC_CRAVINGS);
		RegistryUtil.register(Registries.STATUS_EFFECT, "ultra_violence", ULTRA_VIOLENCE);
		RegistryUtil.register(Registries.STATUS_EFFECT, "clairvoyance", CLAIRVOYANCE);
		RegistryUtil.register(Registries.STATUS_EFFECT, "othervibes", OTHERVIBES);
		RegistryUtil.register(Registries.STATUS_EFFECT, "homely", HOMELY);
		RegistryUtil.register(Registries.STATUS_EFFECT, "brain_drain", BRAIN_DRAIN);
		RegistryUtil.register(Registries.STATUS_EFFECT, "green_fairy", GREEN_FAIRY);
		RegistryUtil.register(Registries.POTION, "resonance", Potions.RESONANCE);
		RegistryUtil.register(Registries.POTION, "resonance_long", Potions.LONG_RESONANCE);
		RegistryUtil.register(Registries.POTION, "resonance_strong", Potions.STRONG_RESONANCE);

		BrewingRecipeRegistryAccessor
			.invokeRegister(net.minecraft.potion.Potions.WATER, MMObjects.RESONATE_OOZE, Potions.RESONANCE);
		BrewingRecipeRegistryAccessor.invokeRegister(Potions.RESONANCE, Items.REDSTONE, Potions.LONG_RESONANCE);
		BrewingRecipeRegistryAccessor.invokeRegister(Potions.RESONANCE, Items.GLOWSTONE_DUST, Potions.STRONG_RESONANCE);
	}

	public static void intoxicatedUpdate(LivingEntity entity, int amplifier) {
		SpellCaster.of(entity).ifPresent(caster -> {
			if (!caster.getLearnedEffects().contains(MMSpellEffects.CLAIRVOYANCE)) {
				Resonating.of(entity).ifPresent(resonating -> {
					if (resonating.getResonance() > 0) {
						caster.learnEffect(MMSpellEffects.CLAIRVOYANCE);
					}
				});
			}
		});
	}

	static class Potions {

		public static final Potion RESONANCE = new Potion(new StatusEffectInstance(MMStatusEffects.RESONANCE, 3600, 0));
		public static final Potion LONG_RESONANCE = new Potion(new StatusEffectInstance(MMStatusEffects.RESONANCE, 9600, 0));
		public static final Potion STRONG_RESONANCE = new Potion(new StatusEffectInstance(MMStatusEffects.RESONANCE, 1800, 1));
	}
}
