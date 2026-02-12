package net.msmp.mod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.msmp.mod.MsmpMod;
import net.msmp.mod.block.custom.*;
import net.msmp.mod.block.entity.ModBlockEntities;
import net.msmp.mod.item.ModItems;
import net.msmp.mod.util.ModWoodTypes;
import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MsmpMod.MOD_ID);

    //Blocos
    public static final RegistryObject<Block> MUSH_GRASS_BLOCK = registerBlock("mush_grass_block",
            () -> new MushBlock(BlockBehaviour.Properties.copy(Blocks.BEDROCK).sound(SoundType.GRASS)));

    public static final RegistryObject<Block> MUSH_GRASSBLUE_BLOCK = registerBlock("mush_grassblue_block",
            () -> new MushBlockNausea(BlockBehaviour.Properties.copy(Blocks.BEDROCK).sound(SoundType.GRASS)));

    public static final RegistryObject<Block> EKKO_PLUSHIE = registerBlockWithoutItem("ekko_plushie",
            () -> new PlushieBlock(
                    BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).noOcclusion().strength(0.5f),
                    () -> ModBlockEntities.PLUSHIE_BE.get()
            ));

    public static final RegistryObject<Block> ASTRO_PLUSHIE = registerBlockWithoutItem("astro_plushie",
            () -> new PlushieBlock(
                    BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).noOcclusion().strength(0.5f),
                    () -> ModBlockEntities.PLUSHIE_BE.get()
            ));

    public static final RegistryObject<Block> ARTHEMIS_PLUSHIE = registerBlockWithoutItem("arthemis_plushie",
            () -> new PlushieBlock(
                    BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).noOcclusion().strength(0.5f),
                    () -> ModBlockEntities.PLUSHIE_BE.get()
            ));

    public static final RegistryObject<Block> SUZZY_PLUSHIE = registerBlockWithoutItem("suzzy_plushie",
            () -> new PlushieBlock(
                    BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).noOcclusion().strength(0.5f),
                    () -> ModBlockEntities.PLUSHIE_BE.get()
            ));

    public static final RegistryObject<Block> MUSH_GRASSPURPLE_BLOCK = registerBlock("mush_grasspurple_block",
            () -> new MushBlockDarkness(BlockBehaviour.Properties.copy(Blocks.BEDROCK).sound(SoundType.GRASS)));

    public static final RegistryObject<Block> MUSH_MUSS_BLOCK = registerBlock("mush_muss_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SOUL_SAND).sound(SoundType.GRASS).strength(-1.0F)));

    public static final RegistryObject<Block> MUSH_SLEEPING_BLOCK = registerBlock("mush_sleeping_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK).sound(SoundType.GRASS).strength(-1.0F)));

    public static final RegistryObject<Block> MUSH_SLEEPING_GRASS_BLOCK = registerBlock("mush_sleeping_grass_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK).sound(SoundType.GRASS).strength(-1.0F)));

    //PLACAS
    public static final RegistryObject<Block> MUSH_SIGN_MNPC01 = BLOCKS.register("mush_sign_mnpc01",
            () -> new ModStandingSingBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).strength(0.15f)
                    .sound(SoundType.WOOD).noParticlesOnBreak(), ModWoodTypes.PLACA_MUSHIN01));
    public static final RegistryObject<Block> MUSH_WALL_SIGN_MNPC01 = BLOCKS.register("mush_wall_sign_mnpc01",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).strength(0.15f)
                    .sound(SoundType.WOOD).noParticlesOnBreak(), ModWoodTypes.PLACA_MUSHIN01));

    public static final RegistryObject<Block> MUSH_SIGN_MNPC02 = BLOCKS.register("mush_sign_mnpc02",
            () -> new ModStandingSingBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).strength(0.15f)
                    .sound(SoundType.WOOD).noParticlesOnBreak(), ModWoodTypes.PLACA_MUSHIN02));
    public static final RegistryObject<Block> MUSH_WALL_SIGN_MNPC02 = BLOCKS.register("mush_wall_sign_mnpc02",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).strength(0.15f)
                    .sound(SoundType.WOOD).noParticlesOnBreak(), ModWoodTypes.PLACA_MUSHIN02));

    public static final RegistryObject<Block> MUSH_SIGN_MNPC03 = BLOCKS.register("mush_sign_mnpc03",
            () -> new ModStandingSingBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).strength(0.15f)
                    .sound(SoundType.WOOD).noParticlesOnBreak(), ModWoodTypes.PLACA_MUSHIN03));
    public static final RegistryObject<Block> MUSH_WALL_SIGN_MNPC03 = BLOCKS.register("mush_wall_sign_mnpc03",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).strength(0.15f)
                    .sound(SoundType.WOOD).noParticlesOnBreak(), ModWoodTypes.PLACA_MUSHIN03));

    public static final RegistryObject<Block> MUSH_SIGN_MNPC04 = BLOCKS.register("mush_sign_mnpc04",
            () -> new ModStandingSingBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).strength(0.15f)
                    .sound(SoundType.WOOD).noParticlesOnBreak(), ModWoodTypes.PLACA_MUSHIN04));
    public static final RegistryObject<Block> MUSH_WALL_SIGN_MNPC04 = BLOCKS.register("mush_wall_sign_mnpc04",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).strength(0.15f)
                    .sound(SoundType.WOOD).noParticlesOnBreak(), ModWoodTypes.PLACA_MUSHIN04));

    public static final RegistryObject<Block> MUSH_SIGN_MNPC05 = BLOCKS.register("mush_sign_mnpc05",
            () -> new ModStandingSingBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).strength(0.15f)
                    .sound(SoundType.WOOD).noParticlesOnBreak(), ModWoodTypes.PLACA_MUSHIN05));
    public static final RegistryObject<Block> MUSH_WALL_SIGN_MNPC05 = BLOCKS.register("mush_wall_sign_mnpc05",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).strength(0.15f)
                    .sound(SoundType.WOOD).noParticlesOnBreak(), ModWoodTypes.PLACA_MUSHIN05));

    public static final RegistryObject<Block> MUSH_SIGN_MNPC06 = BLOCKS.register("mush_sign_mnpc06",
            () -> new ModStandingSingBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).strength(0.15f)
                    .sound(SoundType.WOOD).noParticlesOnBreak(), ModWoodTypes.PLACA_MUSHIN06));
    public static final RegistryObject<Block> MUSH_WALL_SIGN_MNPC06 = BLOCKS.register("mush_wall_sign_mnpc06",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).strength(0.15f)
                    .sound(SoundType.WOOD).noParticlesOnBreak(), ModWoodTypes.PLACA_MUSHIN06));

    public static final RegistryObject<Block> MUSH_SIGN_MNPC07 = BLOCKS.register("mush_sign_mnpc07",
            () -> new ModStandingSingBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).strength(0.15f)
                    .sound(SoundType.WOOD).noParticlesOnBreak(), ModWoodTypes.PLACA_MUSHIN07));
    public static final RegistryObject<Block> MUSH_WALL_SIGN_MNPC07 = BLOCKS.register("mush_wall_sign_mnpc07",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).strength(0.15f)
                    .sound(SoundType.WOOD).noParticlesOnBreak(), ModWoodTypes.PLACA_MUSHIN07));

    public static final RegistryObject<Block> MUSH_SIGN_MNPC08 = BLOCKS.register("mush_sign_mnpc08",
            () -> new ModStandingSingBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).strength(0.15f)
                    .sound(SoundType.WOOD).noParticlesOnBreak(), ModWoodTypes.PLACA_MUSHIN08));
    public static final RegistryObject<Block> MUSH_WALL_SIGN_MNPC08 = BLOCKS.register("mush_wall_sign_mnpc08",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).strength(0.15f)
                    .sound(SoundType.WOOD).noParticlesOnBreak(), ModWoodTypes.PLACA_MUSHIN08));

    public static final RegistryObject<Block> MUSH_SIGN_MNPC09 = BLOCKS.register("mush_sign_mnpc09",
            () -> new ModStandingSingBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).strength(0.15f)
                    .sound(SoundType.WOOD).noParticlesOnBreak(), ModWoodTypes.PLACA_MUSHIN09));
    public static final RegistryObject<Block> MUSH_WALL_SIGN_MNPC09 = BLOCKS.register("mush_wall_sign_mnpc09",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).strength(0.15f)
                    .sound(SoundType.WOOD).noParticlesOnBreak(), ModWoodTypes.PLACA_MUSHIN09));

    public static final RegistryObject<Block> MUSH_SIGN_MNPC10 = BLOCKS.register("mush_sign_mnpc10",
            () -> new ModStandingSingBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).strength(0.15f)
                    .sound(SoundType.WOOD).noParticlesOnBreak(), ModWoodTypes.PLACA_MUSHIN10));
    public static final RegistryObject<Block> MUSH_WALL_SIGN_MNPC10 = BLOCKS.register("mush_wall_sign_mnpc10",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).strength(0.15f)
                    .sound(SoundType.WOOD).noParticlesOnBreak(), ModWoodTypes.PLACA_MUSHIN10));

    public static final RegistryObject<Block> MUSH_SIGN_MNPC11 = BLOCKS.register("mush_sign_mnpc11",
            () -> new ModStandingSingBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).strength(0.15f)
                    .sound(SoundType.WOOD).noParticlesOnBreak(), ModWoodTypes.PLACA_MUSHIN11));
    public static final RegistryObject<Block> MUSH_WALL_SIGN_MNPC11 = BLOCKS.register("mush_wall_sign_mnpc11",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).strength(0.15f)
                    .sound(SoundType.WOOD).noParticlesOnBreak(), ModWoodTypes.PLACA_MUSHIN11));

    public static final RegistryObject<Block> MUSH_SIGN_GHOST = BLOCKS.register("mush_sign_ghost",
            () -> new ModStandingSingBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).strength(0.15f)
                    .sound(SoundType.WOOD).noParticlesOnBreak(), ModWoodTypes.PLACA_GHOST));
    public static final RegistryObject<Block> MUSH_WALL_SIGN_GHOST = BLOCKS.register("mush_wall_sign_ghost",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).strength(0.15f)
                    .sound(SoundType.WOOD).noParticlesOnBreak(), ModWoodTypes.PLACA_GHOST));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
    return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static <T extends Block> RegistryObject<T> registerBlockWithoutItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }


    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
