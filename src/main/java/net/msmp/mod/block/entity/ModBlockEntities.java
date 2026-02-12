package net.msmp.mod.block.entity;


import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.msmp.mod.block.entity.custom.PlushieBlockEntity;
import net.msmp.mod.MsmpMod;
import net.msmp.mod.block.ModBlocks;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MsmpMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> MOD_SIGN =
            BLOCK_ENTITIES.register("mod_sign", () ->
                    BlockEntityType.Builder.of(ModSignBlockEntity::new,
                            ModBlocks.MUSH_SIGN_MNPC01.get(), ModBlocks.MUSH_WALL_SIGN_MNPC01.get(),
                            ModBlocks.MUSH_SIGN_MNPC02.get(), ModBlocks.MUSH_WALL_SIGN_MNPC02.get(),
                            ModBlocks.MUSH_SIGN_MNPC03.get(), ModBlocks.MUSH_WALL_SIGN_MNPC03.get(),
                            ModBlocks.MUSH_SIGN_MNPC04.get(), ModBlocks.MUSH_WALL_SIGN_MNPC04.get(),
                            ModBlocks.MUSH_SIGN_MNPC05.get(), ModBlocks.MUSH_WALL_SIGN_MNPC05.get(),
                            ModBlocks.MUSH_SIGN_MNPC06.get(), ModBlocks.MUSH_WALL_SIGN_MNPC06.get(),
                            ModBlocks.MUSH_SIGN_MNPC07.get(), ModBlocks.MUSH_WALL_SIGN_MNPC07.get(),
                            ModBlocks.MUSH_SIGN_MNPC08.get(), ModBlocks.MUSH_WALL_SIGN_MNPC08.get(),
                            ModBlocks.MUSH_SIGN_MNPC09.get(), ModBlocks.MUSH_WALL_SIGN_MNPC09.get(),
                            ModBlocks.MUSH_SIGN_MNPC10.get(), ModBlocks.MUSH_WALL_SIGN_MNPC10.get(),
                            ModBlocks.MUSH_SIGN_MNPC11.get(), ModBlocks.MUSH_WALL_SIGN_MNPC11.get(),
                            ModBlocks.MUSH_SIGN_GHOST.get(), ModBlocks.MUSH_WALL_SIGN_GHOST.get()
                    ).build(null)
            );

    public static final RegistryObject<BlockEntityType<PlushieBlockEntity>> PLUSHIE_BE =
            BLOCK_ENTITIES.register("plushie_be", () ->
                    BlockEntityType.Builder.of(
                            PlushieBlockEntity::new,
                            ModBlocks.ASTRO_PLUSHIE.get(),
                            ModBlocks.EKKO_PLUSHIE.get(),
                            ModBlocks.ARTHEMIS_PLUSHIE.get(),
                            ModBlocks.SUZZY_PLUSHIE.get()
                    ).build(null));

    

    public static void register(IEventBus eventBus) {BLOCK_ENTITIES.register(eventBus);}
}
