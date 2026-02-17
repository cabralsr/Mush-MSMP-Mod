package net.msmp.mod.event;


import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.msmp.mod.MsmpMod;
import net.msmp.mod.entity.ModEntityTypes;
import net.msmp.mod.entity.custom.RastejadorEntity;
import net.msmp.mod.entity.custom.TestEntity;

@Mod.EventBusSubscriber(modid = MsmpMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventsBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.SEU_MOB.get(), TestEntity.createAttributes().build());
        event.put(ModEntityTypes.RASTEJADOR_MOB.get(), RastejadorEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {

        event.register(
                ModEntityTypes.SEU_MOB.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules,
                SpawnPlacementRegisterEvent.Operation.REPLACE
        );

        event.register(
                ModEntityTypes.RASTEJADOR_MOB.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules,
                SpawnPlacementRegisterEvent.Operation.REPLACE
        );
    }
}
