package net.msmp.mod.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.msmp.mod.MsmpMod;
import net.msmp.mod.entity.ModEntityTypes;
import net.msmp.mod.entity.render.TesteRenderer;

@Mod.EventBusSubscriber(modid = MsmpMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void registerEntityRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        // Esta linha conecta sua entidade ao seu renderer
        event.registerEntityRenderer(ModEntityTypes.SEU_MOB.get(), TesteRenderer::new);
    }
}
