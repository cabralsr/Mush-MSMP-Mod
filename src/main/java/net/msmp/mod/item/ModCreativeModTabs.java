package net.msmp.mod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.msmp.mod.MsmpMod;
import net.msmp.mod.block.ModBlocks;
import net.msmp.mod.entity.ModEntityTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MsmpMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MSMP_TAB = CREATIVE_MODE_TABS.register("msmp_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MUSH_SIGN_MNPC01.get()))
                    .displayItems((itemDisplayParameters, output) -> {

                        // BLOCOS

                        output.accept(ModBlocks.MUSH_GRASS_BLOCK.get());

                        output.accept(ModBlocks.MUSH_GRASSBLUE_BLOCK.get());

                        output.accept(ModBlocks.MUSH_GRASSPURPLE_BLOCK.get());

                        output.accept(ModBlocks.MUSH_MUSS_BLOCK.get());

                        output.accept(ModBlocks.MUSH_SLEEPING_BLOCK.get());

                        output.accept(ModBlocks.MUSH_SLEEPING_GRASS_BLOCK.get());

                        output.accept(ModItems.EKKO_PLUSHIE.get());

                        output.accept(ModItems.ASTRO_PLUSHIE.get());

                        output.accept(ModItems.ARTHEMIS_PLUSHIE.get());

                        output.accept(ModItems.SUZZY_PLUSHIE.get());

                        // PLACAS

                        output.accept(ModItems.MUSH_SIGN_MNPC01.get());

                        output.accept(ModItems.MUSH_SIGN_MNPC02.get());

                        output.accept(ModItems.MUSH_SIGN_MNPC03.get());

                        output.accept(ModItems.MUSH_SIGN_MNPC04.get());

                        output.accept(ModItems.MUSH_SIGN_MNPC05.get());

                        output.accept(ModItems.MUSH_SIGN_MNPC06.get());

                        output.accept(ModItems.MUSH_SIGN_MNPC07.get());

                        output.accept(ModItems.MUSH_SIGN_MNPC08.get());

                        output.accept(ModItems.MUSH_SIGN_MNPC09.get());

                        output.accept(ModItems.MUSH_SIGN_MNPC10.get());

                        output.accept(ModItems.MUSH_SIGN_MNPC11.get());

                        output.accept(ModItems.MUSH_SIGN_GHOST.get());

                        // Frasco/Comida

                        output.accept(ModItems.FUNGO_VINHO.get());

                        output.accept(ModItems.FRASC0.get());

                        // Spawner's

                        output.accept(ModItems.CLICKER_SPAWN_EGG.get());
                    })
                    .title(Component.translatable("creativetab.msmp_tab"))
                    .build());

    public static final RegistryObject<CreativeModeTab> MSMP_TAB_WEAPONS = CREATIVE_MODE_TABS.register("msmp_tab_weapons",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.KNIFE_GHOST.get()))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModItems.KNIFE_GHOST.get());

                        output.accept(ModItems.SWORD_REPHAL.get());

                        output.accept(ModItems.FOICE_FIRST.get());

                        output.accept(ModItems.ADAGA_SANGUE.get());

                        output.accept(ModItems.FOICE_CANIBAL.get());

                        output.accept(ModItems.AXE_GUITTAR.get());

                        output.accept(ModItems.MOLOTOV.get());

                        output.accept(ModItems.GRANADA.get());

                        output.accept(ModItems.BOMBA_DE_PREGO.get());

                        output.accept(ModItems.GAS_MASK.get());

                        output.accept(ModItems.GAS_MASK_FILTER.get());

                    }).title(Component.translatable("creativetab.msmp_tab_weapons")).build());

    public static final RegistryObject<CreativeModeTab> MSMP_TAB_FOODS = CREATIVE_MODE_TABS.register("msmp_tab_foods",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.REFRI1.get()))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModItems.GARRAFA_AGUA.get());

                        output.accept(ModItems.GARRAFA_AGUA_VAZIA.get());

                        output.accept(ModItems.REFRI1.get());

                        output.accept(ModItems.REFRI2.get());

                        output.accept(ModItems.REFRI3.get());

                        output.accept(ModItems.WHISKY.get());

                        output.accept(ModItems.CERVEJA1.get());

                        output.accept(ModItems.CERVEJA2.get());

                        output.accept(ModItems.COMIDA_CONSERVA1.get());

                        output.accept(ModItems.COMIDA_CONSERVA2.get());

                        output.accept(ModItems.COMIDA_CONSERVA3.get());

                        output.accept(ModItems.CANTIL_VAZIO.get());

                    }).title(Component.translatable("creativetab.msmp_tab_foods")).build());

    public static final RegistryObject<CreativeModeTab> MSMP_TAB_RESOURCE = CREATIVE_MODE_TABS.register("msmp_tab_resource",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PREGOS.get()))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModItems.PREGOS.get());

                        output.accept(ModItems.TABUAS.get());

                        output.accept(ModItems.SUCATAS.get());

                        output.accept(ModItems.PILHAS.get());

                        output.accept(ModItems.BATERIA.get());

                        output.accept(ModItems.FIO_DE_COBRE.get());

                        output.accept(ModItems.ARAME_FARPADO.get());

                        output.accept(ModItems.VIDRO_ESTILHACADO.get());

                        output.accept(ModItems.GARRAFA_VIDRO.get());

                        output.accept(ModItems.LAMINA.get());

                        output.accept(ModItems.TESOURA_QUEBRADA.get());

                        output.accept(ModItems.TRAPOS.get());

                        output.accept(ModItems.FITA.get());

                        output.accept(ModItems.AGULHA_AMPOLA_ADRENALINE.get());

                        output.accept(ModItems.AGULHA_VAZIA.get());

                        output.accept(ModItems.AMPOLA_VAZIA.get());

                        output.accept(ModItems.AMPOLA_ADRENALINE.get());

                        output.accept(ModItems.REMEDIOS.get());

                        output.accept(ModItems.Kit_Primeiros_Socorros.get());

                        output.accept(ModItems.LORE_BOOK1.get());

                    }).title(Component.translatable("creativetab.msmp_tab_resource")).build());
    private static final Logger log = LoggerFactory.getLogger(ModCreativeModTabs.class);


    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
