package net.msmp.mod.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.msmp.mod.MsmpMod;
import net.msmp.mod.entity.custom.*;
import net.msmp.mod.entity.projectile.BombaDePregosEntity;
import net.msmp.mod.entity.projectile.GranadaEntity;
import net.msmp.mod.entity.projectile.MolotovEntity;
import net.msmp.mod.entity.projectile.PregoEntity;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MsmpMod.MOD_ID);

    public static final RegistryObject<EntityType<TestEntity>> SEU_MOB =
            ENTITY_TYPES.register("clicker",
                    () -> EntityType.Builder.of(TestEntity::new, MobCategory.MONSTER)
                            .sized(0.8f, 1.5f)
                            .build("clicker"));

    public static final RegistryObject<EntityType<RastejadorEntity>> RASTEJADOR_MOB =
            ENTITY_TYPES.register("rastejador",
                    () -> EntityType.Builder.of(RastejadorEntity::new, MobCategory.MONSTER)
                            .sized(0.8f, 1.5f)
                            .build("rastejador"));

    public static final RegistryObject<EntityType<MolotovEntity>> MOLOTOV_PROJECTILE =
            ENTITY_TYPES.register("molotov_projectile",
                    () -> EntityType.Builder.<MolotovEntity>of(MolotovEntity::new, MobCategory.MISC)
                            .sized(0.25F, 0.25F)
                            .clientTrackingRange(4)
                            .updateInterval(10)
                            .build("molotov_projectile"));

    public static final RegistryObject<EntityType<GranadaEntity>> GRANADA_PROJECTILE =
            ENTITY_TYPES.register("granada_projectile",
                    () -> EntityType.Builder.<GranadaEntity>of(GranadaEntity::new, MobCategory.MISC)
                            .sized(0.25F, 0.25F)
                            .updateInterval(10)
                            .build("granada_projectile"));

    public static final RegistryObject<EntityType<BombaDePregosEntity>> BOMBA_DE_PREGO_PROJECTILE =
            ENTITY_TYPES.register("bomba_de_prego_projectile", () -> EntityType.Builder.<BombaDePregosEntity>of(BombaDePregosEntity::new, MobCategory.MISC)
                    .sized(0.25f, 0.25f)
                    .build("bomba_de_prego_projectile"));

    public static final RegistryObject<EntityType<PregoEntity>> PREGO_PROJECTILE =
            ENTITY_TYPES.register("prego_projectile", () -> EntityType.Builder.<PregoEntity>of(PregoEntity::new, MobCategory.MISC)
                    .sized(0.1f, 0.1f) // Hitbox bem pequena
                    .clientTrackingRange(4)
                    .updateInterval(20)
                    .build("prego_projectile"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
