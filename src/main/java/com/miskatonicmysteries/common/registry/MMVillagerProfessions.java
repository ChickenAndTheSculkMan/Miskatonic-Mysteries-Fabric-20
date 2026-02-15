package com.miskatonicmysteries.common.registry;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.miskatonicmysteries.common.MiskatonicMysteries;
import com.miskatonicmysteries.common.util.Constants;
import com.miskatonicmysteries.mixin.entity.PointOfInterestTypesAccessor;
import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

import java.util.*;

public class MMVillagerProfessions {
    public static final RegistryKey<PointOfInterestType> HASTUR = of("hastur");
    public static final PointOfInterestType PSYCHO_POI = registerPOI("psycho_poi", MMObjects.CHEMISTRY_SET);
    public static final VillagerProfession PSYCHONAUT = registerProfession("psychonaut",
            RegistryKey.of(Registries.POINT_OF_INTEREST_TYPE.getKey(), new Identifier(Constants.MOD_ID, "psycho_poi")), SoundEvents.BLOCK_BREWING_STAND_BREW);

    public static void init() {
        PointOfInterestTypesAccessor.callRegister(Registries.POINT_OF_INTEREST_TYPE,
                HASTUR,
                HASTUR_POI,
                1,
                1);
    }

    private static final Set<BlockState> HASTUR_POI = ImmutableList.of(
            MMObjects.HASTUR_OCTAGRAM, MMObjects.HASTUR_STATUE_STONE, MMObjects.HASTUR_STATUE_TERRACOTTA, MMObjects.HASTUR_STATUE_GOLD,
            MMObjects.HASTUR_STATUE_MOSSY, MMObjects.MOSSY_HASTUR_MURAL, MMObjects.STONE_HASTUR_MURAL, MMObjects.TERRACOTTA_HASTUR_MURAL,
            MMObjects.YELLOW_TERRACOTTA_HASTUR_MURAL
            ).stream().flatMap((block) -> block.getStateManager().getStates().stream()).collect(ImmutableSet.toImmutableSet());


    private static RegistryKey<PointOfInterestType> of(String id) {
        return RegistryKey.of(Registries.POINT_OF_INTEREST_TYPE.getKey(), new Identifier(id));
    }

    public static PointOfInterestType registerPOI(String name, Block block){
        return PointOfInterestHelper.register(new Identifier(Constants.MOD_ID, name),
                1,1, ImmutableSet.copyOf(block.getStateManager().getStates()));
    }

    public static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type, SoundEvent sound){
        return Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(Constants.MOD_ID,name),
                VillagerProfessionBuilder.create().id(new Identifier(Constants.MOD_ID,name)).workstation(type)
                        .workSound(sound).build());
    }
}
