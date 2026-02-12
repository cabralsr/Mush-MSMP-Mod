package net.msmp.mod.event;


import net.minecraft.client.Minecraft;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.msmp.mod.MsmpMod;
import net.msmp.mod.block.entity.ModBlockEntities;
import net.msmp.mod.client.renderer.InvisiblePregoRenderer;
import net.msmp.mod.client.renderer.PlushieRenderer;
import net.msmp.mod.entity.ModEntityTypes;
import net.msmp.mod.entity.render.*;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.msmp.mod.weather.RedRainManager;


@Mod.EventBusSubscriber(modid = MsmpMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void registerEntityRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntityTypes.SEU_MOB.get(), TesteRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.KAIROS_MOB.get(), KairosRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.MOBFINAL_MOB.get(), mobRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.MOLOTOV_PROJECTILE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.GRANADA_PROJECTILE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.BOMBA_DE_PREGO_PROJECTILE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.PREGO_PROJECTILE.get(), InvisiblePregoRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.PLUSHIE_BE.get(), PlushieRenderer::new);
    }


    @SubscribeEvent
    public static void registerGuiOverlays(RegisterGuiOverlaysEvent event) {
        event.registerAboveAll("thirst", ThirstHudOverlay.HUD_THIRST);
    }

    @SubscribeEvent
    public static void onFogColor(ViewportEvent.ComputeFogColor event) {
        Level level = Minecraft.getInstance().level;
        if (level != null && level.isRaining() && RedRainManager.isActive()) {
            event.setRed(0.8f);
            event.setGreen(0.1f);
            event.setBlue(0.1f);
        }
    }

    @SubscribeEvent
    public static void onRenderFog(ViewportEvent.RenderFog event) {
        Level level = Minecraft.getInstance().level;
        if (level != null && level.isRaining() && RedRainManager.isActive()) {
            event.setNearPlaneDistance(0.0F);
            event.setFarPlaneDistance(48.0F);
            event.scaleFarPlaneDistance(0.5f);

            event.setCanceled(true);
        }
    }
}
