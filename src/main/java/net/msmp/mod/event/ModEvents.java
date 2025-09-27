package net.msmp.mod.event;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.msmp.mod.MsmpMod;
import net.msmp.mod.entity.ModEntityTypes;
import net.msmp.mod.entity.custom.TestEntity;
import net.msmp.mod.entity.render.TesteRenderer;
import net.msmp.mod.item.ModItems;


@Mod.EventBusSubscriber(modid = MsmpMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        // Associe os atributos ao seu mob recém-registrado
        event.put(ModEntityTypes.SEU_MOB.get(), TestEntity.createAttributes().build());
    }
}
