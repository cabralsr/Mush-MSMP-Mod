package net.msmp.mod.item;

import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.msmp.mod.MsmpMod;
import net.msmp.mod.block.ModBlocks;

import java.awt.*;

public class ModItems {

    public static final DeferredRegister<Item>ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MsmpMod.MOD_ID);

    //COLECIONAVEIS GHOSTFACE
    public static final RegistryObject<Item> NECKLACE_HEART_FRIZT = ITEMS.register("necklace_heart_frizt",
            () -> new TooltipItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> NECKLACE_MOON_ROSS = ITEMS.register("necklace_moon_ross",
            () -> new TooltipItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> HAIR_BOW_MINAYAS = ITEMS.register("hair_bow_minayas",
            () -> new TooltipItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> R_L_POLAROID = ITEMS.register("r_l_polaroid",
            () -> new TooltipItem(new Item.Properties().stacksTo(1)));

    //PLACAS
    public static final RegistryObject<Item> MUSH_SIGN_MNPC01 = ITEMS.register("mush_sign_mnpc01",
            () ->  new SignItem(new Item.Properties().stacksTo(64),
                    ModBlocks.MUSH_SIGN_MNPC01.get(), ModBlocks.MUSH_WALL_SIGN_MNPC01.get()));

    public static final RegistryObject<Item> MUSH_SIGN_MNPC02 = ITEMS.register("mush_sign_mnpc02",
            () ->  new SignItem(new Item.Properties().stacksTo(64),
                    ModBlocks.MUSH_SIGN_MNPC02.get(), ModBlocks.MUSH_WALL_SIGN_MNPC02.get()));

    public static final RegistryObject<Item> MUSH_SIGN_MNPC03 = ITEMS.register("mush_sign_mnpc03",
            () ->  new SignItem(new Item.Properties().stacksTo(64),
                    ModBlocks.MUSH_SIGN_MNPC03.get(), ModBlocks.MUSH_WALL_SIGN_MNPC03.get()));

    public static final RegistryObject<Item> MUSH_SIGN_MNPC04 = ITEMS.register("mush_sign_mnpc04",
            () ->  new SignItem(new Item.Properties().stacksTo(64),
                    ModBlocks.MUSH_SIGN_MNPC04.get(), ModBlocks.MUSH_WALL_SIGN_MNPC04.get()));

    public static final RegistryObject<Item> MUSH_SIGN_MNPC05 = ITEMS.register("mush_sign_mnpc05",
            () ->  new SignItem(new Item.Properties().stacksTo(64),
                    ModBlocks.MUSH_SIGN_MNPC05.get(), ModBlocks.MUSH_WALL_SIGN_MNPC05.get()));

    public static final RegistryObject<Item> MUSH_SIGN_MNPC06 = ITEMS.register("mush_sign_mnpc06",
            () ->  new SignItem(new Item.Properties().stacksTo(64),
                    ModBlocks.MUSH_SIGN_MNPC06.get(), ModBlocks.MUSH_WALL_SIGN_MNPC06.get()));

    public static final RegistryObject<Item> MUSH_SIGN_MNPC07 = ITEMS.register("mush_sign_mnpc07",
            () ->  new SignItem(new Item.Properties().stacksTo(64),
                    ModBlocks.MUSH_SIGN_MNPC07.get(), ModBlocks.MUSH_WALL_SIGN_MNPC07.get()));

    public static final RegistryObject<Item> MUSH_SIGN_MNPC08 = ITEMS.register("mush_sign_mnpc08",
            () ->  new SignItem(new Item.Properties().stacksTo(64),
                    ModBlocks.MUSH_SIGN_MNPC08.get(), ModBlocks.MUSH_WALL_SIGN_MNPC08.get()));

    public static final RegistryObject<Item> MUSH_SIGN_MNPC09 = ITEMS.register("mush_sign_mnpc09",
            () ->  new SignItem(new Item.Properties().stacksTo(64),
                    ModBlocks.MUSH_SIGN_MNPC09.get(), ModBlocks.MUSH_WALL_SIGN_MNPC09.get()));

    public static final RegistryObject<Item> MUSH_SIGN_MNPC10 = ITEMS.register("mush_sign_mnpc10",
            () ->  new SignItem(new Item.Properties().stacksTo(64),
                    ModBlocks.MUSH_SIGN_MNPC10.get(), ModBlocks.MUSH_WALL_SIGN_MNPC10.get()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
