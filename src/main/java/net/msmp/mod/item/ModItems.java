package net.msmp.mod.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.msmp.mod.MsmpMod;
import net.msmp.mod.block.ModBlocks;
import net.msmp.mod.entity.ModEntityTypes;
import net.msmp.mod.item.custom.BombaDePregoItem;
import net.msmp.mod.item.food.GarrafaAguaItem;
import net.msmp.mod.item.food.*;
import net.msmp.mod.item.medicine.AgulhaAdrenalineItem;
import net.msmp.mod.item.medicine.KitPrimeiroItem;
import net.msmp.mod.item.medicine.RemedioItem;
import net.msmp.mod.lorebook.LoreBookItem;

import static net.msmp.mod.item.food.ModFood.*;

public class ModItems {

    public static final DeferredRegister<Item>ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MsmpMod.MOD_ID);

    public static final RegistryObject<Item> EKKO_PLUSHIE = ITEMS.register("ekko_plushie",
            () -> new PlushieItem(ModBlocks.EKKO_PLUSHIE.get(), new Item.Properties()));

    public static final RegistryObject<Item> ASTRO_PLUSHIE = ITEMS.register("astro_plushie",
            () -> new PlushieItem(ModBlocks.ASTRO_PLUSHIE.get(), new Item.Properties()));

    public static final RegistryObject<Item> ARTHEMIS_PLUSHIE = ITEMS.register("arthemis_plushie",
            () -> new PlushieItem(ModBlocks.ARTHEMIS_PLUSHIE.get(), new Item.Properties()));

    public static final RegistryObject<Item> SUZZY_PLUSHIE = ITEMS.register("suzzy_plushie",
            () -> new PlushieItem(ModBlocks.SUZZY_PLUSHIE.get(), new Item.Properties()));

    public static final RegistryObject<Item> GAS_MASK = ITEMS.register("gas_mask",
            () -> new GasMaskItem(
                    ArmorMaterials.IRON,
                    ArmorItem.Type.HELMET,
                    new Item.Properties()
            ));

    public static final RegistryObject<Item> GAS_MASK_FILTER = ITEMS.register("gas_mask_filter",
            () -> new Item(new Item.Properties()));

    //COMIDAS

    public static final RegistryObject<Item> FRASC0 = ITEMS.register("frasco",
            () -> new Item(new Item.Properties().food(FRASCO)));

    public static final RegistryObject<Item> FUNGO_VINHO = ITEMS.register("fungo_vinho",
            () -> new Item(new Item.Properties().food(ModFood.FUNGO_VINHO)));

    public static final RegistryObject<Item> COMIDA_CONSERVA1 = ITEMS.register("comida_conserva1",
            () -> new Item(new Item.Properties().food(ModFood.COMIDA_CONSERVA).stacksTo(16)));

    public static final RegistryObject<Item> COMIDA_CONSERVA2 = ITEMS.register("comida_conserva2",
            () -> new Item(new Item.Properties().food(ModFood.COMIDA_CONSERVA).stacksTo(16)));

    public static final RegistryObject<Item> COMIDA_CONSERVA3 = ITEMS.register("comida_conserva3",
            () -> new Item(new Item.Properties().food(ModFood.COMIDA_CONSERVA).stacksTo(16)));

    public static final RegistryObject<Item> CERVEJA1 = ITEMS.register("cerveja1",
            () -> new AlcoolicoItem(new Item.Properties().food(CERVEJA).stacksTo(8)));

    public static final RegistryObject<Item> CERVEJA2 = ITEMS.register("cerveja2",
            () -> new AlcoolicoItem(new Item.Properties().food(CERVEJA).stacksTo(8)));

    public static final RegistryObject<Item> WHISKY = ITEMS.register("whisky",
            () -> new AlcoolicoItem(new Item.Properties().food(ModFood.WHISKY).stacksTo(1)));

    public static final RegistryObject<Item> GARRAFA_AGUA_VAZIA = ITEMS.register("garrafa_agua_vazia",
            () -> new Item(new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> GARRAFA_AGUA = ITEMS.register("garrafa_agua",
            () -> new GarrafaAguaItem(new Item.Properties()
                    .stacksTo(16)
                    .food(AGUA_PROPERTIES)));

    public static final RegistryObject<Item> REFRI1 = ITEMS.register("refri1",
            () -> new RefriItem(new Item.Properties()
                    .stacksTo(16)
                    .food(REFRIGERANTE)));

    public static final RegistryObject<Item> REFRI2 = ITEMS.register("refri2",
            () -> new RefriItem(new Item.Properties()
                    .stacksTo(16)
                    .food(REFRIGERANTE)));

    public static final RegistryObject<Item> REFRI3 = ITEMS.register("refri3",
            () -> new RefriItem(new Item.Properties()
                    .stacksTo(16)
                    .food(REFRIGERANTE)));

    public static final RegistryObject<Item> CANTIL_VAZIO = ITEMS.register("cantil_vazio",
            () -> new CantilVazioItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> CANTIL_SUJO = ITEMS.register("cantil_sujo",
            () -> new CantilItem(new Item.Properties().stacksTo(1).durability(3), true));

    public static final RegistryObject<Item> CANTIL_LIMPO = ITEMS.register("cantil_limpo",
            () -> new CantilItem(new Item.Properties().stacksTo(1).durability(3), false));

    //PROJÉTIL

    public static final RegistryObject<Item> MOLOTOV = ITEMS.register("molotov",
            () -> new MolotovItem(new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> GRANADA = ITEMS.register("granada",
            () -> new GranadaItem(new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> BOMBA_DE_PREGO = ITEMS.register("bomba_de_prego",
            () -> new BombaDePregoItem(new Item.Properties().stacksTo(16)));

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

    public static final RegistryObject<Item> AXE_GUITTAR = ITEMS.register("axe_guittar",
            () -> new CustomSword(Tiers.NETHERITE, 26, -3,
                    new Item.Properties().stacksTo(1)));

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

    //recursos

    public static final RegistryObject<Item> PREGOS = ITEMS.register("pregos",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> TABUAS = ITEMS.register("tabuas",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> VIDRO_ESTILHACADO = ITEMS.register("vidro_estilhacado",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> TRAPOS = ITEMS.register("trapos",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> SUCATAS = ITEMS.register("sucatas",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> ARAME_FARPADO = ITEMS.register("arame_farpado",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> TESOURA_QUEBRADA = ITEMS.register("tesoura_quebrada",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> GARRAFA_VIDRO = ITEMS.register("garrafa_vidro",
            () -> new Item(new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> REMEDIOS = ITEMS.register("remedios",
            () -> new RemedioItem(new Item.Properties().stacksTo(16)
                    .food(new FoodProperties.Builder().nutrition(0)
                            .saturationMod(0).alwaysEat().build())));

    public static final RegistryObject<Item> Kit_Primeiros_Socorros = ITEMS.register("kit_primeiros_socorros",
            () -> new KitPrimeiroItem(new Item.Properties().stacksTo(16)
                    .food(new FoodProperties.Builder().nutrition(0)
                            .saturationMod(0).alwaysEat().build())));

    public static final RegistryObject<Item> AGULHA_AMPOLA_ADRENALINE = ITEMS.register("agulha_ampola_adrenaline",
            () -> new AgulhaAdrenalineItem(new Item.Properties().stacksTo(16)
                    .food(new FoodProperties.Builder().nutrition(0)
                            .saturationMod(0).alwaysEat().build())));

    public static final RegistryObject<Item> AGULHA_VAZIA = ITEMS.register("agulha_vazia",
            () -> new Item(new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> AMPOLA_VAZIA = ITEMS.register("ampola_vazia",
            () -> new Item(new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> AMPOLA_ADRENALINE = ITEMS.register("ampola_adrenaline",
            () -> new Item(new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> PILHAS = ITEMS.register("pilhas",
            () -> new Item(new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> BATERIA = ITEMS.register("bateria",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> LAMINA = ITEMS.register("lamina",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> FIO_DE_COBRE = ITEMS.register("fio_de_cobre",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> FITA = ITEMS.register("fita",
            () -> new Item(new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> LORE_BOOK1 = ITEMS.register("lore_book1",
            () -> new LoreBookItem(new Item.Properties().stacksTo(1)));


    //Spawner's

    public static final RegistryObject<Item> CLICKER_SPAWN_EGG = ITEMS.register("clicker_spawn_egg",
            () -> new ForgeSpawnEggItem(
                    ModEntityTypes.SEU_MOB,
                    0xFFFFFF,
                    0xA9A9A9,
                    new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
