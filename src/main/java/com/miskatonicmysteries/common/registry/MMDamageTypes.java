package com.miskatonicmysteries.common.registry;

import com.miskatonicmysteries.common.util.Constants;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class MMDamageTypes {
    //todo fix this mess
    public static final RegistryKey<DamageType> INSANITY = RegistryKey.of(RegistryKeys.DAMAGE_TYPE,
            new Identifier(Constants.MOD_ID + "insanity"));
    public static final RegistryKey<DamageType> FEASTER = RegistryKey.of(RegistryKeys.DAMAGE_TYPE,
            new Identifier(Constants.MOD_ID + "feaster"));
    public static final RegistryKey<DamageType> SLEEP = RegistryKey.of(RegistryKeys.DAMAGE_TYPE,
            new Identifier(Constants.MOD_ID + "sleep"));
    public static final RegistryKey<DamageType> PROTAGONIST = RegistryKey.of(RegistryKeys.DAMAGE_TYPE,
            new Identifier(Constants.MOD_ID + "protagonist_damage"));
    public static void init() {

    }
}
