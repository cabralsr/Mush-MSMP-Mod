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
//import net.msmp.mod.entity.ModEntityTypes;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MsmpMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MSMP_TAB = CREATIVE_MODE_TABS.register("msmp_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MUSH_SIGN_MNPC01.get()))
                    .displayItems((itemDisplayParameters, output) -> {

                        //BLOCOS
                        output.accept(ModBlocks.MUSH_GRASS_BLOCK.get());

                        output.accept(ModBlocks.MUSH_GRASSBLUE_BLOCK.get());

                        output.accept(ModBlocks.MUSH_GRASSPURPLE_BLOCK.get());

                        output.accept(ModBlocks.MUSH_MUSS_BLOCK.get());

                        output.accept(ModBlocks.MUSH_SLEEPING_BLOCK.get());

                        output.accept(ModBlocks.MUSH_SLEEPING_GRASS_BLOCK.get());

                        //COLECIONAVEIS GHOSTFACE

                        output.accept(ModItems.NECKLACE_SHERINA.get());

                        output.accept(ModItems.NECKLACE_HEART_FRIZT.get());

                        output.accept(ModItems.NECKLACE_MOON_ROSS.get());

                        output.accept(ModItems.HAIR_BOW_MINAYAS.get());

                        output.accept(ModItems.R_L_POLAROID.get());

                        output.accept(ModItems.CAMERA_RAVIEL.get());

                        output.accept(ModItems.MASK_LUKA.get());

                        //PLACAS
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

                    }).title(Component.translatable("creativetab.msmp_tab_weapons")).build());


    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
