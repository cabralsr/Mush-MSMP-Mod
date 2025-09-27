package net.msmp.mod.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.msmp.mod.MsmpMod;
import net.msmp.mod.entity.custom.TestEntity;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MsmpMod.MOD_ID);

    // 2. Registre sua entidade
    public static final RegistryObject<EntityType<TestEntity>> SEU_MOB =
            ENTITY_TYPES.register("clicker", // O ID do seu mob. Ex: "seu_mod_id:seu_mob"
                    () -> EntityType.Builder.of(TestEntity::new, MobCategory.MONSTER)
                            .sized(0.8f, 1.5f) // Largura e Altura do hitbox
                            .build(ResourceLocation.fromNamespaceAndPath(MsmpMod.MOD_ID, "clicker").toString()));


    // 3. Crie um método para registrar o DeferredRegister no Event Bus do mod
    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
