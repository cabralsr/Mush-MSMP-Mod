package net.msmp.mod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.Sheets;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.msmp.mod.block.ModBlocks;
import net.msmp.mod.block.entity.ModBlockEntities;
import net.msmp.mod.effects.ModEffects;
import net.msmp.mod.entity.ModEntityTypes;
import net.msmp.mod.item.ModCreativeModTabs;
import net.msmp.mod.item.ModItems;
import net.msmp.mod.loot.ModLootModifiers;
import net.msmp.mod.util.ModSounds;
import net.msmp.mod.util.ModWoodTypes;
import org.slf4j.Logger;

//daqui para baixo é só loucura 0-0

@Mod(MsmpMod.MOD_ID)
public class MsmpMod {

    public static final String MOD_ID = "msmpmod";

    private static final Logger LOGGER = LogUtils.getLogger();

    public MsmpMod(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        ModCreativeModTabs.register(modEventBus);

        ModItems.register(modEventBus);

        ModEffects.register(modEventBus);

        ModBlocks.register(modEventBus);

        ModBlockEntities.register(modEventBus);

        ModLootModifiers.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        ModEntityTypes.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }


    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            //ADICIONAR O NOME DA TEXTURA DAS PLACAS
            Sheets.addWoodType(ModWoodTypes.PLACA_MUSHIN01);
            Sheets.addWoodType(ModWoodTypes.PLACA_MUSHIN02);
            Sheets.addWoodType(ModWoodTypes.PLACA_MUSHIN03);
            Sheets.addWoodType(ModWoodTypes.PLACA_MUSHIN04);
            Sheets.addWoodType(ModWoodTypes.PLACA_MUSHIN05);
            Sheets.addWoodType(ModWoodTypes.PLACA_MUSHIN06);
            Sheets.addWoodType(ModWoodTypes.PLACA_MUSHIN07);
            Sheets.addWoodType(ModWoodTypes.PLACA_MUSHIN08);
            Sheets.addWoodType(ModWoodTypes.PLACA_MUSHIN09);
            Sheets.addWoodType(ModWoodTypes.PLACA_MUSHIN10);
        }
    }
}
