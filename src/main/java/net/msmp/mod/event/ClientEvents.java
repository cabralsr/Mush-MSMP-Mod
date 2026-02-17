package net.msmp.mod.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.msmp.mod.MsmpMod;
import net.msmp.mod.client.renderer.InvisiblePregoRenderer;
import net.msmp.mod.entity.ModEntityTypes;
import net.msmp.mod.entity.render.*;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;


@Mod.EventBusSubscriber(modid = MsmpMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void registerEntityRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntityTypes.SEU_MOB.get(), TesteRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.RASTEJADOR_MOB.get(), RastejadorRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.MOLOTOV_PROJECTILE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.GRANADA_PROJECTILE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.BOMBA_DE_PREGO_PROJECTILE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.PREGO_PROJECTILE.get(), InvisiblePregoRenderer::new);
    }


    @SubscribeEvent
    public static void registerGuiOverlays(RegisterGuiOverlaysEvent event) {
        event.registerAboveAll("thirst", ThirstHudOverlay.HUD_THIRST);
    }
}
