package net.msmp.mod.item;

import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.msmp.mod.MsmpMod;
import net.msmp.mod.block.ModBlocks;
import net.msmp.mod.entity.ModEntityTypes;

public class ModItems {

    public static final DeferredRegister<Item>ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MsmpMod.MOD_ID);

    //ESPADAS
    public static final RegistryObject<Item> KNIFE_GHOST = ITEMS.register("knife_ghost",
            () -> new CustomSword(Tiers.NETHERITE, 30, 2,
                    new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SWORD_REPHAL = ITEMS.register("sword_rephal",
            () -> new CustomSword(Tiers.NETHERITE, 40, -2,
                    new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> FOICE_FIRST = ITEMS.register("foice_first",
            () -> new CustomSword(Tiers.NETHERITE, 18, -1.5,
                    new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> FOICE_CANIBAL = ITEMS.register("foice_canibal",
            () -> new CustomSword(Tiers.NETHERITE, 18, -1.5,
                    new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> ADAGA_SANGUE = ITEMS.register("adaga_sangue",
            () -> new CustomSword(Tiers.NETHERITE, 21, -0.5,
                    new Item.Properties().stacksTo(1)));

    //COLECIONAVEIS GHOSTFACE
    public static final RegistryObject<Item> NECKLACE_SHERINA = ITEMS.register("necklace_sherina",
            () -> new TooltipItem(new Item.Properties()));

    public static final RegistryObject<Item> NECKLACE_HEART_FRIZT = ITEMS.register("necklace_heart_frizt",
            () -> new TooltipItem(new Item.Properties()));

    public static final RegistryObject<Item> NECKLACE_MOON_ROSS = ITEMS.register("necklace_moon_ross",
            () -> new TooltipItem(new Item.Properties()));

    public static final RegistryObject<Item> HAIR_BOW_MINAYAS = ITEMS.register("hair_bow_minayas",
            () -> new TooltipItem(new Item.Properties()));

    public static final RegistryObject<Item> R_L_POLAROID = ITEMS.register("r_l_polaroid",
            () -> new TooltipItem(new Item.Properties()));

    public static final RegistryObject<Item> CAMERA_RAVIEL = ITEMS.register("camera_raviel",
            () -> new TooltipItem(new Item.Properties()));

    public static final RegistryObject<Item> MASK_LUKA = ITEMS.register("mask_luka",
            () -> new TooltipItem(new Item.Properties()));

    //PLACAS
    public static final RegistryObject<Item> MUSH_SIGN_MNPC01 = ITEMS.register("mush_sign_mnpc01",
            () ->  new SignItem(new Item.Properties().stacksTo(64),
                    ModBlocks.MUSH_SIGN_MNPC01.get(),
                    ModBlocks.MUSH_WALL_SIGN_MNPC01.get()
            )
    );

    public static final RegistryObject<Item> MUSH_SIGN_MNPC02 = ITEMS.register("mush_sign_mnpc02",
            () ->  new SignItem(new Item.Properties().stacksTo(64),
                    ModBlocks.MUSH_SIGN_MNPC02.get(),
                    ModBlocks.MUSH_WALL_SIGN_MNPC02.get()
            )
    );

    public static final RegistryObject<Item> MUSH_SIGN_MNPC03 = ITEMS.register("mush_sign_mnpc03",
            () ->  new SignItem(new Item.Properties().stacksTo(64),
                    ModBlocks.MUSH_SIGN_MNPC03.get(),
                    ModBlocks.MUSH_WALL_SIGN_MNPC03.get()
            )
    );

    public static final RegistryObject<Item> MUSH_SIGN_MNPC04 = ITEMS.register("mush_sign_mnpc04",
            () ->  new SignItem(new Item.Properties().stacksTo(64),
                    ModBlocks.MUSH_SIGN_MNPC04.get(),
                    ModBlocks.MUSH_WALL_SIGN_MNPC04.get()
            )
    );

    public static final RegistryObject<Item> MUSH_SIGN_MNPC05 = ITEMS.register("mush_sign_mnpc05",
            () ->  new SignItem(new Item.Properties().stacksTo(64),
                    ModBlocks.MUSH_SIGN_MNPC05.get(),
                    ModBlocks.MUSH_WALL_SIGN_MNPC05.get()
            )
    );

    public static final RegistryObject<Item> MUSH_SIGN_MNPC06 = ITEMS.register("mush_sign_mnpc06",
            () ->  new SignItem(new Item.Properties().stacksTo(64),
                    ModBlocks.MUSH_SIGN_MNPC06.get(),
                    ModBlocks.MUSH_WALL_SIGN_MNPC06.get()
            )
    );

    public static final RegistryObject<Item> MUSH_SIGN_MNPC07 = ITEMS.register("mush_sign_mnpc07",
            () ->  new SignItem(new Item.Properties().stacksTo(64),
                    ModBlocks.MUSH_SIGN_MNPC07.get(),
                    ModBlocks.MUSH_WALL_SIGN_MNPC07.get()
            )
    );

    public static final RegistryObject<Item> MUSH_SIGN_MNPC08 = ITEMS.register("mush_sign_mnpc08",
            () ->  new SignItem(new Item.Properties().stacksTo(64),
                    ModBlocks.MUSH_SIGN_MNPC08.get(),
                    ModBlocks.MUSH_WALL_SIGN_MNPC08.get()
            )
    );

    public static final RegistryObject<Item> MUSH_SIGN_MNPC09 = ITEMS.register("mush_sign_mnpc09",
            () ->  new SignItem(new Item.Properties().stacksTo(64),
                    ModBlocks.MUSH_SIGN_MNPC09.get(),
                    ModBlocks.MUSH_WALL_SIGN_MNPC09.get()
            )
    );

    public static final RegistryObject<Item> MUSH_SIGN_MNPC10 = ITEMS.register("mush_sign_mnpc10",
            () ->  new SignItem(new Item.Properties().stacksTo(64),
                    ModBlocks.MUSH_SIGN_MNPC10.get(),
                    ModBlocks.MUSH_WALL_SIGN_MNPC10.get()
            )
    );

    public static final RegistryObject<Item> MUSH_SIGN_MNPC11 = ITEMS.register("mush_sign_mnpc11",
            () ->  new SignItem(new Item.Properties().stacksTo(64),
                    ModBlocks.MUSH_SIGN_MNPC11.get(),
                    ModBlocks.MUSH_WALL_SIGN_MNPC11.get()
            )
    );

    public static final RegistryObject<Item> MUSH_SIGN_GHOST = ITEMS.register("mush_sign_ghost",
            () ->  new SignItem(new Item.Properties().stacksTo(64),
                    ModBlocks.MUSH_SIGN_GHOST.get(),
                    ModBlocks.MUSH_WALL_SIGN_GHOST.get()
            )
    );

    public static final RegistryObject<Item> CLICKER_SPAWN_EGG = ITEMS.register("clicker_spawn_egg",
            () -> new ForgeSpawnEggItem(
                    ModEntityTypes.SEU_MOB, // 1. O tipo de entidade que este ovo irá invocar
                    0xFFFFFF,            // 2. A cor primária do ovo (ex: marrom escuro)
                    0xA9A9A9,            // 3. A cor secundária (das manchas) (ex: bege)
                    new Item.Properties())); // 4. Propriedades do item

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
